package pl.sda.arppl4.student_grade_system.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_system.model.Grade;
import pl.sda.arppl4.student_grade_system.model.Student;
import pl.sda.arppl4.student_grade_system.model.Subject;
import pl.sda.arppl4.student_grade_system.model.dto.CreateGradeRequest;
import pl.sda.arppl4.student_grade_system.repository.GradeRepository;
import pl.sda.arppl4.student_grade_system.repository.StudentRepository;
import pl.sda.arppl4.student_grade_system.repository.SubjectRepository;
import pl.sda.arppl4.student_grade_system.service.SubjectNotAvailableException.SubjectNotAvailableException;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    public void addGrade(Long studentId, Long subjectId, CreateGradeRequest request) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            Optional<Subject> subjectOptional = subjectRepository.findById(subjectId);
            if (subjectOptional.isPresent()) {
                Subject subject = subjectOptional.get();

                Grade newGrade = new Grade();
                newGrade.setValue(request.getValueGrade());
                newGrade.setStudent(student);
                newGrade.setSubject(subject);
                gradeRepository.save(newGrade);

                return;
            }
            throw new SubjectNotAvailableException("Subject with id: " + subjectId + "is not available");
        }
        throw new EntityNotFoundException("We couldn't find student with Id: " + studentId);
    }

    public List<Grade> getAllGrades(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            List<Grade> gradesList = new ArrayList<>(student.getGrade());
            // for(Student student : gradesList){
            return gradesList;
        }
        throw new EntityNotFoundException("We couldn't find student with Id: " + studentId);
    }

    public List<Grade> getAllGradesForSubject(Long studentId, Long subjectId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            List<Grade> gradesListForSubject = new ArrayList<>(student.getGrade());
            List<Grade> odfiltrowanaLista = new ArrayList<>();
            for (Grade grade : gradesListForSubject) {
                if (grade.getSubject().getId() == subjectId) {
                    odfiltrowanaLista.add(grade);
                }
            }
            return odfiltrowanaLista;
        }

        throw new EntityNotFoundException("We couldn't find student with Id: " + studentId);
    }

    public List<Grade> getAllGradesForSubject2(Long studentId, Long subjectId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            Optional<Subject> subjectOptional = subjectRepository.findById(subjectId);
            if (subjectOptional.isPresent()) {
                Subject subject = subjectOptional.get();

                return gradeRepository.findAllByStudentAndSubject(student, subject);
            }

            throw new EntityNotFoundException("We couldn't find subject with Id: " + subjectId);
        }
        throw new EntityNotFoundException("We couldn't find student with Id: " + studentId);

    }

    public void deleteById(Long identifier) {
        gradeRepository.deleteById(identifier);
    }
}
