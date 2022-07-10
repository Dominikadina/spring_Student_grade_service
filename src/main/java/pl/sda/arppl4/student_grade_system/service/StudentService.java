package pl.sda.arppl4.student_grade_system.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_system.model.Student;
import pl.sda.arppl4.student_grade_system.model.dto.CreateStudentRequest;
import pl.sda.arppl4.student_grade_system.model.dto.StudentDTO;
import pl.sda.arppl4.student_grade_system.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(CreateStudentRequest request) {
//        Student student = new Student(null, request.getNameStudent(), request.getSurnameStudent(), request.getDateOfBirthStudent(), request.getIndeksNoStudent(), null);
        Student student = new Student(request.getNameStudent(), request.getSurnameStudent(), request.getDateOfBirthStudent(), request.getIndeksNoStudent());

        studentRepository.save(student);
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student student : studentList) {
            dtoList.add(student.mapToStudentDTO());
        }
        return dtoList;
    }

    public void deleteById(Long identyfier) {
        studentRepository.deleteById(identyfier);
    }

    public void updateStudent(Student updatedData) {
        Long identifier = updatedData.getId();

        Optional<Student> studentOptional = studentRepository.findById(identifier);
        if (studentOptional.isPresent()) {
            Student editedStudent = studentOptional.get();

            if (updatedData.getName() != null) {
                editedStudent.setName(updatedData.getName());
            }
            if (updatedData.getSurname() != null) {
                editedStudent.setSurname(updatedData.getSurname());
            }
            if (updatedData.getDateOfBirth() != null) {
                editedStudent.setDateOfBirth(updatedData.getDateOfBirth());
            }
            studentRepository.save(updatedData);
            log.info("Student was updated.");
            return;
        }
        throw new EntityNotFoundException("There is no student with id: " + updatedData.getId());
    }

    }
