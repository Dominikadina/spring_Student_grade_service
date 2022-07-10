package pl.sda.arppl4.student_grade_system.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.student_grade_system.model.Student;
import pl.sda.arppl4.student_grade_system.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        log.info("Called adding student method:" + student);
        studentService.addStudent(student);
    }

    @GetMapping("/list")
    public List<Student> getAllStudents() {
        log.info("Called list all Students method");
        List<Student> list = studentService.getAllStudents();
        return list;
    }

    @DeleteMapping("/delete/{identifier}")
    public void deleteStudent(@PathVariable(name = "identifier") Long identifier) {
        log.info("Called to delete student: " + identifier);
        studentService.deleteById(identifier);
    }

    @PatchMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        log.info("Called for student actualization:" + student);
        studentService.updateStudent(student);
    }
}
