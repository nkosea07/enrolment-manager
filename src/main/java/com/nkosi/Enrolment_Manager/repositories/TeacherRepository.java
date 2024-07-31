package com.nkosi.Enrolment_Manager.repositories;

import com.nkosi.Enrolment_Manager.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByEmail(String email);
}
