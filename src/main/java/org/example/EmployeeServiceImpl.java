package org.example;

import jakarta.validation.Valid;

import java.util.*;

public class EmployeeServiceImpl {

    private static Map<Integer, Employee> map = new HashMap<>();
    static
    {
        map.put(1, new Employee(1, "Arpit"));
        map.put(2, new Employee(2, "Sanjay"));
        map.put(3, new Employee(3, "Sanskar"));
    }
    public Employee getEmployee(int id)
    {
        return map.get(id);
    }
    public Employee addEmployee(Employee emp)
    {
        Integer max = Collections.max(map.keySet());
        emp.setEmpid(max + 1);
        map.put(max+1, emp);
        return emp;
    }
    public List<Employee> getAll()
    {
        return new ArrayList<>(map.values());
    }
}
