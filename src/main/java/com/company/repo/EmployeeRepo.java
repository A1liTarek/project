package com.company.repo;

import com.company.model.Department;
import com.company.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findByNameContaining(String name);
    @Query("SELECT e FROM Employee e where e.overTime=(SELECT MAX (e.overTime)FROM Employee e)")
    Optional<Employee>findHighOverTime();


}
