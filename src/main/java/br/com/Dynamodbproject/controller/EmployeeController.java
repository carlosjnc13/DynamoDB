package br.com.Dynamodbproject.controller;

import br.com.Dynamodbproject.entity.Employee;
import br.com.Dynamodbproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping
    public Employee getById(@RequestParam(value = "employeeId")String employeeId){
        return employeeRepository.getById(employeeId);
    }

    @PatchMapping
    public Employee update(@RequestParam(value = "employeeId")String employeeId,
                           @RequestBody Employee employee){
        return employeeRepository.update(employeeId,employee);
    }

    @DeleteMapping
    public void delete(String employeeId){
        employeeRepository.delete(employeeId);
    }


}
