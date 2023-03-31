package com.teste.sant.gestao.func.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String appointing;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;
}
