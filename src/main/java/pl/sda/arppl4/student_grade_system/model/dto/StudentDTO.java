package pl.sda.arppl4.student_grade_system.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long idStudent;
    private String nameStudent;
    private String surnameStudent;
    private LocalDate dateOfBirthStudent;
    private String indeksNoStudent;


}
