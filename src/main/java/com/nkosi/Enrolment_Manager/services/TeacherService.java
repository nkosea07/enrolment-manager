package com.nkosi.Enrolment_Manager.services;

import com.nkosi.Enrolment_Manager.dtos.PersonDto;
import com.nkosi.Enrolment_Manager.exceptions.DataNotFoundException;
import com.nkosi.Enrolment_Manager.models.Teacher;
import com.nkosi.Enrolment_Manager.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher getTeacherByEmail(String email) {
        return teacherRepository.findByEmail(email).orElseThrow(()-> new DataNotFoundException("Failed to find teacher with the given email"
                .concat(" ").concat(email )));
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, PersonDto teacherDetails) {
        Optional<Teacher> teacherOptional = getTeacherById(id);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            teacher.setFirstName(teacherDetails.getFirstName());
            teacher.setLastName(teacherDetails.getLastName());
            teacher.setAge(teacherDetails.getAge());
            teacher.setSex(teacherDetails.getSex());
            saveTeacher(teacher);
        }
        return null;
    }
    public Teacher registerTeacher(PersonDto personDto) {

        Optional<Teacher> teacher = teacherRepository.findByEmail(personDto.getEmail());

        return teacher.orElseGet(() -> saveTeacher(Teacher.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .age(personDto.getAge())
                .sex(personDto.getSex())
                .build()));
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
