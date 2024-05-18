package com.hutech.ngay3c5.RequestEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateStudent {
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String password;
}
