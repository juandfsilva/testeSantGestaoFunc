package com.teste.sant.gestao.func.service.impl;

import com.teste.sant.gestao.func.domain.entity.Employee;
import com.teste.sant.gestao.func.domain.enumeration.ExceptionMessage;
import com.teste.sant.gestao.func.domain.exception.DefaultException;
import com.teste.sant.gestao.func.domain.response.EmployeeResponse;
import com.teste.sant.gestao.func.domain.vo.EmployeeVo;
import com.teste.sant.gestao.func.repository.EmployeeRepository;
import com.teste.sant.gestao.func.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employees = repository.findAll();
        return toListResponse(employees);
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeVo employeeVo) {
        try{
            Employee employee = repository.save(mapper.map(employeeVo, Employee.class));
            return mapper.map(employeeVo, EmployeeResponse.class);
        }catch (Exception e){
            throw new DefaultException(HttpStatus.BAD_REQUEST, ExceptionMessage.BAD_REQUEST);
        }
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeVo employeeVo) {
        Optional<Employee> employee = repository.findById(employeeVo.getId());
        if(employee.isEmpty()){
            throw new DefaultException(HttpStatus.NOT_FOUND,ExceptionMessage.NOT_FOUND);
        }
        return mapper.map(repository.save(mapper.map(employeeVo, Employee.class)), EmployeeResponse.class);
    }

    @Transactional
    @Override
    public void deleteEmployee(Long id){
        Optional<Employee> employee = repository.findById(id);
        if(employee.isPresent()){
            repository.deleteById(id);
        }else{
            throw new DefaultException(HttpStatus.NOT_FOUND,ExceptionMessage.NOT_FOUND);
        }
    }

    @Override
    public EmployeeResponse getById(Long id) {
        return mapper.map(repository.findById(id).get(), EmployeeResponse.class);
    }

    private List<EmployeeResponse> toListResponse(List<Employee> employees) {
        List<EmployeeResponse> employeeResponseList = new ArrayList<EmployeeResponse>(employees.size());
        for(Employee emp : employees){
            employeeResponseList.add(mapper.map(emp, EmployeeResponse.class));
        }
        return employeeResponseList;
    }

}
