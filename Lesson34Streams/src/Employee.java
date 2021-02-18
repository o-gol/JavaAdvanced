import java.util.Objects;

public class Employee {
    Integer id;
    String name;
    String surname;
    String deartment;
    Integer salary;

    public Employee(Integer id, String name, String surname, Integer salary, String deartment) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.deartment=deartment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDeartment() {
        return deartment;
    }

    public void setDeartment(String deartment) {
        this.deartment = deartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(deartment, employee.deartment) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, deartment, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", deartment='" + deartment + '\'' +
                ", salary=" + salary +
                '}';
    }

}

