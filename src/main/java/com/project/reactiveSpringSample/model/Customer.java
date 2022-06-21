package com.project.reactiveSpringSample.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Customer {

    @Id
    private Integer id;

    @Column
    private String firstName;
    private String lastName;
    private String address;
    private Integer phoneNumber;
    private String email;
    private Integer cardNumber;

}
