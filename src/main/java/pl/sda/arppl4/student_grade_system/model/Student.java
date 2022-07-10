package pl.sda.arppl4.student_grade_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.student_grade_system.model.dto.StudentDTO;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate dateOfBirth;
    private String indeksNo;


    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Grade> grade;

    public StudentDTO mapToStudentDTO(){
        return new StudentDTO(id, name, surname, dateOfBirth, indeksNo);
    }

    public Student(String name, String surname, LocalDate dateOfBirth, String indeksNo) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.indeksNo = indeksNo;
    }
}
