package augusto108.ces.datarestcorp.service;

import augusto108.ces.datarestcorp.model.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    Page<Employee> findEmployeeByRegistration(String registration, int page, int size);

    Page<Employee> findEmployeeByDescription(String description, int page, int size);

    Page<Employee> findEmployees(String search, int page, int size);
}
