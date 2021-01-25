package company;

import company.employees.Employee;
import company.employees.ITSpecialist;

import java.util.ArrayList;
import java.util.List;

public class Company {

    List<Department> departments=new ArrayList<>();
    List<Employee> employees=new ArrayList<>();

    public <T extends Employee> void addDepartment(Department<T> department){
        departments.add(department);
        List<T> employeeList=department.getEmployees();
        giveRise(employeeList);
        this.employees.addAll(employeeList);

    }

    private  void giveRise(List<? extends Employee> employees){
        for (Employee e :
                employees) {
            e.setSalary(e.getSalary()*1.2f);
        }

    }

    public void print(List<?> list){
        System.out.println("size "+list.size());
        System.out.println(list);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addItSpecialist(List<? super ITSpecialist> list){
        list.add(new ITSpecialist("Jack",3000.0f));
    }

    @Override
    public String toString() {
        return "Company{" +
                "departments=" + departments +
                ", employees=" + employees +
                '}';
    }
}

