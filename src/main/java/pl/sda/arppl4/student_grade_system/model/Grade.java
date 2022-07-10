package pl.sda.arppl4.student_grade_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer value;
    @CreationTimestamp
    private LocalDate dateAdded;


    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Subject subject;

    @ManyToOne()
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private Student student;

}
