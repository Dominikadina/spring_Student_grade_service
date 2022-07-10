package pl.sda.arppl4.student_grade_system.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_system.model.Student;
import pl.sda.arppl4.student_grade_system.model.Subject;
import pl.sda.arppl4.student_grade_system.model.dto.CreateSubjectRequest;
import pl.sda.arppl4.student_grade_system.model.dto.StudentDTO;
import pl.sda.arppl4.student_grade_system.model.dto.SubjectDTO;
import pl.sda.arppl4.student_grade_system.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public void addSubject(CreateSubjectRequest request) {
        Subject subject = new Subject (request.getNameSubject());
        subjectRepository.save(subject);
    }

    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjectList = new ArrayList<>();
               List<SubjectDTO> dtoList = new ArrayList<>();
        for (Subject subject : subjectList) {
            dtoList.add(subject.mapToSubjectDTO());
        }

        return dtoList;
    }

    public void deletebyId(Long identifier) {
        subjectRepository.deleteById(identifier);
    }
}
