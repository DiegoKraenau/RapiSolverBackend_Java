package com.rapisolver.rapisolveruserservice.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class UserSignUpRequestDTO {
    @Column(length = 100, nullable = false)
    private String firstname;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 250, nullable = false)
    private String password;

    @Column(length = 9, nullable = false)
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date birthdate;

    @Column(length = 20, nullable = false)
    private String country;

    @Column(length = 20, nullable = false)
    private String state;

    @Column(length = 20, nullable = false)
    private String city;

    @Column(length = 70, nullable = false)
    private String address;
}
