package company;

import company.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class  Department<T extends Employee> {
    String name;
    int eployeeNumber;
    List<T> employees=new ArrayList<>();

    public  boolean addEmployee(T employee){
        return employees.add(employee);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", eployeeNumber=" + eployeeNumber +
//                ", employees=" + employees +
                '}';
    }

    public List<T> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEployeeNumber() {
        return eployeeNumber;
    }

    public void setEployeeNumber(int eployeeNumber) {
        this.eployeeNumber = eployeeNumber;
    }

    public Department(String name, int eployeeNumber) {
        this.name = name;
        this.eployeeNumber = eployeeNumber;
    }
}
