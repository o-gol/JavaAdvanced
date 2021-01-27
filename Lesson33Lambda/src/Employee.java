
public class Employee {
    String name;
    String surname;
    Integer salary;

    public Employee(String name, String surname, Integer salary) {
        this.name = name;
        this.salary = salary;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

