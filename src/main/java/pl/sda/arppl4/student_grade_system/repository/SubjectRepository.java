package pl.sda.arppl4.student_grade_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.student_grade_system.model.Subject;

public interface SubjectRepository extends JpaRepository <Subject, Long> {
}
