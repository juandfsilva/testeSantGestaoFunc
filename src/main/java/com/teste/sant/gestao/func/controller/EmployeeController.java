package com.teste.sant.gestao.func.controller;
import com.teste.sant.gestao.func.domain.request.EmployeeRequest;
import com.teste.sant.gestao.func.domain.response.EmployeeResponse;
import com.teste.sant.gestao.func.domain.vo.EmployeeVo;
import com.teste.sant.gestao.func.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EmployeeResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse employeeResponse = service.createEmployee(mapper.map(employeeRequest, EmployeeVo.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
    }

    @PutMapping
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeVo employeeRequest){
        EmployeeResponse employeeResponse = service.updateEmployee(employeeRequest);
        return ResponseEntity.ok(employeeResponse);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
