package com.rapisolver.rapisolveruserservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
//@Table(name="customer")
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("CUSTOMER")
@AllArgsConstructor
public class Customer extends User {

    @Column(length = 100)
    String randomColumn;


}
