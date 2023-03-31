package com.teste.sant.gestao.func.service;

import com.teste.sant.gestao.func.domain.response.EmployeeResponse;
import com.teste.sant.gestao.func.domain.vo.EmployeeVo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeVo employeeVo);

    List<EmployeeResponse> getAll();

    EmployeeResponse updateEmployee(EmployeeVo employeeVo);

    void deleteEmployee(Long id);

    EmployeeResponse getById(Long id);
}
