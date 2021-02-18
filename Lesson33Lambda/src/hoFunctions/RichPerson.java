package hoFunctions;

public class RichPerson {
    String name;
    String surname;
    Integer age;
    Integer salary;

    public RichPerson(String name, String surname, Integer age, Integer salary) {
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}