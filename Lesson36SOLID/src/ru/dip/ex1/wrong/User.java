package ru.dip.ex1.wrong;

public class User {
    private int id;
    private String underName;
    private String pswrd;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", underName='" + underName + '\'' +
                ", pswrd='" + pswrd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnderName() {
        return underName;
    }

    public void setUnderName(String underName) {
        this.underName = underName;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }
}
