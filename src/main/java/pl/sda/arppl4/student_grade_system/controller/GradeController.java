package pl.sda.arppl4.student_grade_system.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.student_grade_system.model.Grade;
import pl.sda.arppl4.student_grade_system.model.Student;
import pl.sda.arppl4.student_grade_system.model.dto.CreateGradeRequest;
import pl.sda.arppl4.student_grade_system.service.GradeService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;
    // samochód -> X wynajmów
    // aby dodać wynajem potrzebujemy carId

    // student -> X grades
    // subject -> X grades
    // aby dodać grade potrzebujemy studentId
    // aby dodać grade potrzebujemy subjectId
    @PostMapping("/add")
    public void addGrade(@RequestParam Long studentId,@RequestParam Long subjectId, @RequestBody CreateGradeRequest request) {
        log.info("Commend add grade was called:");
        gradeService.addGrade(studentId, subjectId, request);
    }
    @GetMapping("/list")
    public List<Grade> getAllGrades(@RequestParam Long studentId) {
        log.info("Called list of grades for student with id:" + studentId);
        List<Grade> list = gradeService.getAllGrades(studentId);
        return list;
    }

    @GetMapping("/list/subject")
    public List<Grade> getAllGradesForSubject(@RequestParam Long studentId, @RequestParam Long subjectId) {
        log.info("Called list of grades for student with id:" + studentId + "and subcjet id: " + subjectId);
        List<Grade> list = gradeService.getAllGradesForSubject(studentId, subjectId);
        return list;
    }

    @PostMapping("/delete/{identifier}")
    public void deleteById(@PathVariable(name = "identifier") Long identifier){
        log.info("Deleted grade");
        gradeService.deleteById(identifier);
    }
}
