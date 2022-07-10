package pl.sda.arppl4.student_grade_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String indeksNo;


    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Grade> grade;

}
