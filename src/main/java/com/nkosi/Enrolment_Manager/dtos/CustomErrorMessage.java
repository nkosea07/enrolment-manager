package com.nkosi.Enrolment_Manager.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomErrorMessage {
    private String title;
    private String message;
    private String description;
    private HttpStatus code;
    private ZonedDateTime eventTime;
}
