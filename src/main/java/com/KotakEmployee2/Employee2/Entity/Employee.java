package com.KotakEmployee2.Employee2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee_Table",uniqueConstraints = { @UniqueConstraint(columnNames = { "emailId", "mobileNumber" })})
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private String dateOfJoining;
    private String address;
    private String department;
    private double salary;

    /*public Employee(int id, String firstName, String lastName, long mobileNumber, String emailId, String dateOfJoining, String address, String department, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.dateOfJoining = dateOfJoining;
        this.address = address;
        this.department = department;
        this.salary = salary;
    }*/

    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String fname){
        this.firstName = fname;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lname){
        this.lastName = lname;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public void setMobileNumber(String mobno){
        this.mobileNumber = mobno;
    }

    public String getEmailId(){
        return emailId;
    }
    public void setEmailId(String mailId){
        this.emailId = mailId;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDateOfJoining(){
        return dateOfJoining;
    }
    public void setDateOfJoining(String dOJ){
        this.dateOfJoining = dOJ;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
}
