package pl.sda.arppl4.student_grade_system.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.arppl4.student_grade_system.model.Subject;
import pl.sda.arppl4.student_grade_system.repository.SubjectRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void deletebyId(Long identifier) {
        subjectRepository.deleteById(identifier);
    }
}
