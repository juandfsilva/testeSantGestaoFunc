package com.teste.sant.gestao.func.domain.request;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String name;
    private String appointing;
    private double salary;
    private String phoneNumber;
    private String address;
}
