package com.KotakEmployee2.Employee2.Controller;

import com.KotakEmployee2.Employee2.DTO.EmployeeRequest;
import com.KotakEmployee2.Employee2.Entity.Employee;
import com.KotakEmployee2.Employee2.Repository.EmployeeRepository;
import com.KotakEmployee2.Employee2.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(path = "/employee/add", consumes = "application/json")
    /*public ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        return new ResponseEntity<>(service.saveEmployee(employeeRequest).HttpStatus.CREATED);
    }*/
    public ResponseEntity<String> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        // Save the employee using the service
        Employee savedEmployee = service.saveEmployee(employeeRequest);

        // Create a ResponseEntity with the appropriate HTTP status
        ResponseEntity<String> responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Employee created successfully with ID: " + savedEmployee.getId());

        return responseEntity;
    }

    @PostMapping(path ="/employees/addmore", consumes = "application/json")
    public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees){
        return ResponseEntity.ok(service.saveEmployees(employees));
    }
    @GetMapping(path = "/employees")
    public ResponseEntity<Map<String, Object>> getALlEMployees(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        try{
            List<Employee> employees = new ArrayList<>();
            Pageable paging = PageRequest.of(page,size);

            Page<Employee> pageEmps = employeeRepository.findAll(paging);
            employees = pageEmps.getContent();

            Map<String,Object> response = new HashMap<>();
            response.put("employees", employees);
            response.put("currentPage", pageEmps.getNumber());
            response.put("totalItems", pageEmps.getTotalElements());
            response.put("totalPages", pageEmps.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/employees/byId/{id}", consumes = "application/json")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping(value = "/employees/byFirstName/{firstName}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeByFirstName(@PathVariable String firstName){
        return ResponseEntity.ok(service.getEmployeeByFirstName(firstName));
    }

    @GetMapping(value = "/employees/byLastName/{lastName}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeByLastName(@PathVariable String lastName){
        return ResponseEntity.ok(service.getEmployeeByLastName(lastName));
    }

    @GetMapping(value = "/employees/byAddress/{address}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeByAddress(@PathVariable String address){
        return ResponseEntity.ok(service.getEmployeeByAddress(address));
    }

    @GetMapping(value = "/employees/byDOJ/{dateOfJoining}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeByDateOfJoining(@PathVariable String dateOfJoining){
        return ResponseEntity.ok(service.getEmployeeByDateOfJoining(dateOfJoining));
    }

    @GetMapping(value = "/employees/byDepartment/{department}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeBydepartment(@PathVariable String department){
        return ResponseEntity.ok(service.getEmployeeByDepartment(department));
    }

    @GetMapping(value = "/employees/bySalary/{salary}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeBySalary(@PathVariable double salary){
        return ResponseEntity.ok(service.getEmployeeBySalary(salary));
    }

    @GetMapping(value = "/employees/{emailId}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeByEmailID(@PathVariable String emailId){
        return ResponseEntity.ok(service.getEmployeeByEmailId(emailId));
    }

    @GetMapping(value = "/employees/{mobno}", consumes = "application/json")
    public ResponseEntity<List<Employee>> findEmployeeByMobileNumber(@PathVariable String mobno){
        return ResponseEntity.ok(service.getEmployeeByMobileNumber(mobno));
    }

    @GetMapping(value = "/employees/sortAsc/{field}", consumes = "application/json")
    public ResponseEntity<List<Employee>> getEmployeeAscSorting(@PathVariable String field){
        return ResponseEntity.ok(service.findEmployeeWithAscSorting(field));
    }

    @GetMapping(value = "/employees/sortDesc/{field}", consumes = "application/json")
    public ResponseEntity<List<Employee>> getEmployeeDescSorting(@PathVariable String field){
        return ResponseEntity.ok(service.findEmployeeWithDescSorting(field));
    }

    @PutMapping(value = "/employees/{id}", consumes = "application/json")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return ResponseEntity.ok(service.updateEmployee(employee));
    }

    @DeleteMapping(value = "employees/{id}", consumes = "application/json")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
        return new ResponseEntity<String>("Employee with id "+id+" deleted.", HttpStatus.OK);
    }

    @GetMapping(value = "pagination/{offset}/{size}", consumes = "application/json")
    public ResponseEntity<Page<Employee>> findEmployeeWithPagination(@PathVariable int offset, @PathVariable int size){
        return ResponseEntity.ok(service.findEmployeeWithPagination(offset,size));
    }

    @GetMapping(path = "paginationAndSort/{offset}/{size}/{field}", consumes = "application/json")
    public ResponseEntity<Page<Employee>> findEmployeeWithPaginationAndSort(@PathVariable int offset,
                                                            @PathVariable int size, @PathVariable String field){
        return ResponseEntity.ok(service.findEmployeeWithPaginationAndSort(offset, size, field));
    }


}
