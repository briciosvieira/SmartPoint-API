package entity;

import enums.ProfileEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private BigDecimal hourValue;
    private Float hoursWorkedDay;
    private Float lunchTime;
    private ProfileEnum profile;
    private LocalDate createdDate;
    private Date updateDate;
    private List<Lauch>lauches;


}
