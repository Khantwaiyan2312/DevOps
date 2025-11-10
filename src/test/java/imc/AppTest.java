package imc;

import org.junit.jupiter.api.Test;
import com.napier.sem.App;
import com.napier.sem.Employee;
import com.napier.sem.Department;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AppTest {
static App app = new App();
    @Test
    void connect() {
    }

    @Test
    void printSalaries() {
        ArrayList<Employee> employees = new ArrayList<>();

        // Create dummy department
        Department dept = new Department("D001", "Engineering", null);

        // Create employee using constructor
        Employee emp = new Employee("E001", "Kevin Chalmers", dept, null);
        emp.setSalary(55000);

        // Add employee to the list
        employees.add(emp);

        // Call the method
        app.printSalaries(employees);
    }
}