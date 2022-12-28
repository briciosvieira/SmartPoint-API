package entity;

import enums.ProfileEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 140, nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = true, name = "hour_value")
    private BigDecimal hourValue;
    @Column(name = "hours_worked_day")
    private Float hoursWorkedDay;
    @Column(name = "lunch_time")
    private Float lunchTime;
    @Column
    private ProfileEnum profile;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "update_date")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    private ProfileEnum profileEnum;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lauch>lauches;

    @Transient
    public Optional<BigDecimal> getHourValueOpt() {
        return Optional.ofNullable(hourValue);
    }

    @Transient
    public Optional<Float> getHoursWorkedDayOpt() {
        return Optional.ofNullable(hoursWorkedDay) ;
    }
}