package com.teste.sant.gestao.func.repository;

import com.teste.sant.gestao.func.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
