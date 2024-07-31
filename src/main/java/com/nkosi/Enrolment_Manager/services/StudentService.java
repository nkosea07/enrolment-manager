package com.nkosi.Enrolment_Manager.services;

import com.nkosi.Enrolment_Manager.dtos.PersonDto;
import com.nkosi.Enrolment_Manager.models.Student;
import com.nkosi.Enrolment_Manager.models.Teacher;
import com.nkosi.Enrolment_Manager.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final TeacherService teacherService;

    public Student registerStudent(String teacherEmail, PersonDto personDto) {

        //first check if student exists before registration
        Optional<Student> student = getStudentByEmail(personDto.getEmail());

        //fetch teacher to be assigned to student
        Teacher teacher = teacherService.getTeacherByEmail(teacherEmail);

        //save or else return existing student object
        return student.orElseGet(() -> studentRepository.save(Student.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .age(personDto.getAge())
                .sex(personDto.getSex())
                .teacher(teacher)
                .build()));

    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


    public Student updateStudent(Long id, PersonDto personDto) {
        //check if student exists
        Optional<Student> optionalStudent = getStudentById(id);
        if (optionalStudent.isPresent()) {
            //update details orelse return existing details
            Student student = optionalStudent.get();
            student.setFirstName(Objects.isNull(personDto.getFirstName()) ? student.getFirstName() : personDto.getFirstName());
            student.setLastName(Objects.isNull(personDto.getLastName()) ? student.getLastName() : personDto.getLastName());
            student.setEmail(Objects.isNull(personDto.getEmail()) ? student.getEmail() : personDto.getEmail());
            student.setAge(Objects.isNull(personDto.getAge()) ? student.getAge() : personDto.getAge());
            student.setSex(Objects.isNull(personDto.getSex()) ? student.getSex() : personDto.getSex());
            return saveStudent(student);

        }
        return null;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
