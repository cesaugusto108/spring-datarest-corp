package augusto108.ces.datarestcorp.service;

import augusto108.ces.datarestcorp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployeeByRegistration(String registration);

    List<Employee> findEmployeeByDescription(String description);
}
