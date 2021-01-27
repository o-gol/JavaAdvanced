public class Person {
    String name;
    String surname;
    Integer age;

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.age = age;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname=" + surname + '\'' +
                ", salary=" + age +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
