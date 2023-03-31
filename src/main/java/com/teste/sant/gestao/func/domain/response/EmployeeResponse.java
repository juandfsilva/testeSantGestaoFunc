package com.teste.sant.gestao.func.domain.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String appointing;
    private double salary;
    private String phoneNumber;
    private String address;
}
