package com.studies.smartPoint.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studies.smartPoint.enums.TypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "lauch")
public class Lauch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column( nullable = false)
    private Date date;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String localization;
    @Column(name = "created_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdDate;
    @Column(name = "update_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "enm_type")
    private TypeEnum type;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @PreUpdate
    public void preUpdate(){
        createdDate =  new Date();
    }
    @PrePersist
    public  void prePersist(){
        final Date current = new Date();
        createdDate = current;
        updateDate = current;

    }

}
