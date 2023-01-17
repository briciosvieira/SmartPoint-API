package com.studies.smartPoint.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "corporate_name",nullable = false, length = 50)
    private String corporateName;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Column(name = "created_date",updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdDate;

    @Column(name = "update_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String updateDate;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;

    @PrePersist
    public void prePersist(){
        setCreatedDate(LocalDate.now());
    }



}
