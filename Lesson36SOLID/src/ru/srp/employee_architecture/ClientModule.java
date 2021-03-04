package ru.srp.employee_architecture;

public class ClientModule {
    public static void main(String[] args) {
        Employee employee=new Employee(1,"Lim","IT",true);
        hireEmployee(employee);
        printEmployeeReport(employee,FormatType.XML);
        terminateEmployee(employee);
    }
    public static void hireEmployee(Employee employee){
        new EmployeeDAO().saveEmployee(employee);
    }
    public static void terminateEmployee(Employee employee){
        new EmployeeDAO().deleteEmployee(employee);
    }

    public static void printEmployeeReport(Employee employee,FormatType formatType){
        System.out.println(new EmployeeReportFormatter(employee,formatType).getFormattedEmployee());

    }
}
