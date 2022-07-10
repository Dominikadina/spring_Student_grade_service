package pl.sda.arppl4.student_grade_system.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.sda.arppl4.student_grade_system.model.Student;
import pl.sda.arppl4.student_grade_system.model.Subject;
import pl.sda.arppl4.student_grade_system.model.dto.CreateSubjectRequest;
import pl.sda.arppl4.student_grade_system.model.dto.SubjectDTO;
import pl.sda.arppl4.student_grade_system.service.SubjectService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @PostMapping("/add")
            public void addSubject(@RequestBody CreateSubjectRequest request){
        log.info("Comend adding subcejt was called:" + request);
        subjectService.addSubject(request);
    }
 @GetMapping("/list")
 List<SubjectDTO> getAllSubjects(){
        log.info("Method list all subjcts");
        List<SubjectDTO> listaSubject = subjectService.getAllSubjects();
        return listaSubject;
 }
@DeleteMapping("/delete/{identifier}")
    public void deleteSubject(@PathVariable(name = "identifier") Long identifier) {
        log.info("Method delete subject was called" + identifier);
        subjectService.deletebyId(identifier);

    }

}
