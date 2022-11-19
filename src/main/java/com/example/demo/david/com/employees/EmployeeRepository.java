package com.example.demo.david.com.employees;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//orm
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{


    List<Employee> findByEmailId(String emailID);
}
