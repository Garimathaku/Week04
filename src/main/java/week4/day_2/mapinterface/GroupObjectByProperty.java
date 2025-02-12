package week4.day_2.mapinterface;

import java.util.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { 
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Generic class to group employees by department
class EmployeeGrouper<K, V> {
    public Map<K, List<V>> groupByProperty(List<V> items, java.util.function.Function<V, K> classifier) {
        Map<K, List<V>> groupedMap = new HashMap<>();

        for (V item : items) {
            groupedMap.computeIfAbsent(classifier.apply(item), k -> new ArrayList<>()).add(item);
        }

        return groupedMap;
    }
}

public class GroupObjectByProperty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter the number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.println("Enter employee department: ");
            String department = scanner.nextLine();
            employees.add(new Employee(name, department));
        }

        scanner.close();

        EmployeeGrouper<String, Employee> grouper = new EmployeeGrouper<>();
        Map<String, List<Employee>> groupedEmployees = grouper.groupByProperty(employees, Employee::getDepartment);

        System.out.println("Grouped Employees by Department: " + groupedEmployees);
    }
}

