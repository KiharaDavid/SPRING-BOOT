package com.example.demo.david.com.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee( @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/employee/{id}/")
    public ResponseEntity<Employee>getEmployeebyId(@PathVariable(value="id") long employeeId){
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee not found for this id : :" +employeeId));
        return ResponseEntity.ok().body(employee);
    }
    @PutMapping("/employees/{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") long employeeId,
            @RequestBody Employee employeeDetails) throws EntityNotFoundException{
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee not found for this id : :" +employeeId));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        employeeRepository.save(employee);
        return ResponseEntity.ok().body(employee);

    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(value="id") long employeeId)throws EntityNotFoundException{
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new EntityNotFoundException("Employee not found for this id : :" +employeeId));

        employeeRepository.deleteById(employeeId);
        return ResponseEntity.ok().build();

    }
}

