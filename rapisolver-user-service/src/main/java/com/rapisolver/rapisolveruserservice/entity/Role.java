package com.rapisolver.rapisolveruserservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true, nullable = false)
    private String name;

    @Column(name = "can_publish", nullable = false)
    private boolean canPublish;

    public Role(String role_customer) {
        this.name=role_customer;
        this.canPublish = !name.equals("ROLE_CUSTOMER");
    }

}
