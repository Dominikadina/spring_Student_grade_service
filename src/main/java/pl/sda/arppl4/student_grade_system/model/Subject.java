package pl.sda.arppl4.student_grade_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.sda.arppl4.student_grade_system.model.dto.StudentDTO;
import pl.sda.arppl4.student_grade_system.model.dto.SubjectDTO;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String name;


    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Set<Grade> grade;

    public SubjectDTO mapToSubjectDTO(){
        return new SubjectDTO(id, name);
    }

    public Subject(String name) {
        this.name = name;

    }
}
