package company;

import company.employees.Accountant;
import company.employees.ITSpecialist;
import company.employees.Manager;

public class Program {
    public static void main(String[] args) {
        Company company=new Company();

        Department<Accountant> accounting= new Department<>("accounting",5);
        Department<Manager> managers= new Department<>("managers",2);
        Department<ITSpecialist> it= new Department<>("it",10);
        //Department<String> stringDepartment=new Department<>("",12);

        Accountant accountant=new Accountant("Jack",1000.0f);
        ITSpecialist itSpecialist=new ITSpecialist("Lily",2000.0f);
        Manager manager=new Manager("Mike",4000.0f);

        accounting.addEmployee(accountant);
        it.addEmployee(itSpecialist);
        managers.addEmployee(manager);
        company.addItSpecialist(it.employees);

        company.addDepartment(accounting);
        company.addDepartment(it);
        company.addDepartment(managers);
//        System.out.println(company);
        company.addItSpecialist(company.getEmployees());
        company.print(company.getEmployees());
        company.print(company.getDepartments());
    }
}
