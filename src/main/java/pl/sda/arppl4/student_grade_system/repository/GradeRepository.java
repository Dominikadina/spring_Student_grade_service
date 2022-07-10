package pl.sda.arppl4.student_grade_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.arppl4.student_grade_system.model.Grade;
import pl.sda.arppl4.student_grade_system.model.Student;
import pl.sda.arppl4.student_grade_system.model.Subject;

import java.util.List;

public interface GradeRepository extends JpaRepository <Grade, Long> {
    List<Grade> findAllByStudentAndSubject(Student student, Subject subject);
}
