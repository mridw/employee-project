package org.azalio.em_project.services;
import org.azalio.em_project.dto.Employee;

import java.util.List;

public interface EmService {
    String createEmployee(Employee employee);

    List<Employee> readAllEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);

    Employee readEmployee(Long id);
}
