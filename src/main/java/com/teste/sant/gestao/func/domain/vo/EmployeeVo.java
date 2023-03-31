package com.teste.sant.gestao.func.domain.vo;

import lombok.Data;


@Data
public class EmployeeVo {
    private Long id;
    private String name;
    private String appointing;
    private double salary;
    private String phoneNumber;
    private String address;
}
