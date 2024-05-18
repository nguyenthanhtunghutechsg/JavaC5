package com.hutech.ngay3c5.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdateStudent {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String password;
}
