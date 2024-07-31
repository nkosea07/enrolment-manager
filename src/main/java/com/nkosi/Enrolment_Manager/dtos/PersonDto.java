package com.nkosi.Enrolment_Manager.dtos;

import com.nkosi.Enrolment_Manager.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Sex sex;
}
