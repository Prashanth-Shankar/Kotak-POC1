package com.KotakEmployee2.Employee2.Service;

import com.KotakEmployee2.Employee2.DTO.EmployeeRequest;
import com.KotakEmployee2.Employee2.Entity.Employee;
import com.KotakEmployee2.Employee2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee(0,employeeRequest.getFirstName(),employeeRequest.getLastName(), employeeRequest.getMobileNumber(), employeeRequest.getEmailId(), employeeRequest.getDateOfJoining(),employeeRequest.getAddress(),employeeRequest.getDepartment(), employeeRequest.getSalary());
        return repository.save(employee);
    }

    public List<Employee> saveEmployees(List<Employee> employees){
        return repository.saveAll(employees);
    }
    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Employee> getEmployeeByFirstName(String firstName){
        return repository.findAllByFirstName(firstName);
    }

    public List<Employee> getEmployeeByLastName(String lastName){
        return repository.findAllByLastName(lastName);
    }

    public List<Employee> getEmployeeByDepartment(String department){
        return repository.findAllByDepartment(department);
    }

    public List<Employee> getEmployeeByDateOfJoining(String dateOfJoining){
        return repository.findAllByDateOfJoining(dateOfJoining);
    }

    public List<Employee> getEmployeeBySalary(double salary){
        return repository.findAllBySalary(salary);
    }

    public List<Employee> getEmployeeByAddress(String address){
        return repository.findAllByAddress(address);
    }

    public List<Employee> getEmployeeByEmailId(String emailId){
        return repository.findAllByEmailId(emailId);
    }

    public List<Employee> getEmployeeByMobileNumber(String mobno){
        return repository.findAllByMobileNumber(mobno);
    }

    public List<Employee> findEmployeeWithAscSorting(String field){
        return repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public List<Employee> findEmployeeWithDescSorting(String field){
        return repository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    public Employee updateEmployee(Employee employee){
        return repository.save(employee);
    }

    public void deleteEmployee(int id){
        repository.deleteById(id);
    }

    public Page<Employee> findEmployeeWithPagination(int offset, int size){
        return repository.findAll(PageRequest.of(offset,size));
    }

    public Page<Employee> findEmployeeWithPaginationAndSort(int offset, int size, String field){
        return repository.findAll(PageRequest.of(offset,size).withSort(Sort.by(field)));
    }
}
