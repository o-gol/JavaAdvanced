package ru.srp.employee_architecture;

public class EmployeeDAO {
    void saveEmployee(Employee employee){
        System.out.printf("We save %s\n", employee.name);
    }
    void deleteEmployee(Employee employee){
        System.out.printf("We delete %s\n", employee.name);
    }

}
