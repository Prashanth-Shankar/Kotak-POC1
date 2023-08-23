package com.KotakEmployee2.Employee2.Repository;

import com.KotakEmployee2.Employee2.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByFirstName(String firstName);
    List<Employee> findAllByLastName(String lastName);
    List<Employee> findAllByAddress(String address);
    List<Employee> findAllByDateOfJoining(String dateOfJoining);
    List<Employee> findAllBySalary(double salary);
    List<Employee> findAllByDepartment(String department);
    List<Employee>findAllByMobileNumber(String mobno);
    List<Employee>findAllByEmailId(String emailId);

}

