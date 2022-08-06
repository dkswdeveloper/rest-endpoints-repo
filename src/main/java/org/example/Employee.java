package org.example;

public class Employee {

    private int empid;
    private String name;

    public Employee(int empid, String name) {
        this.empid = empid;
        this.name = name;
    }

    public Employee() {
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", name='" + name + '\'' +
                '}';
    }
}
