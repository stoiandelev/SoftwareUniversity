package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Employee employee) {
        if (this.capacity > this.employees.size()) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(r -> r.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        Employee result = null;
        for (Employee employee : employees) {
            if (result == null || result.getAge() < employee.getAge()) {
                result = employee;
            }
        }
        return result;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
    public int getCount() {
        return employees.size();
    }
    //Employees working at Bakery {bakeryName}:
    //{Employee1}

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery "); sb.append(this.name);sb.append(':');
        sb.append(System.lineSeparator());
        //Employee: Stephen, 40 (Bulgaria)
        for (Employee employee : employees) {
            sb.append("Employee: ");
            sb.append(employee.getName());sb.append(',');sb.append(" ");
            sb.append((employee.getAge()));sb.append(" ");
            sb.append('(');sb.append(employee.getCountry());sb.append(')');
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
