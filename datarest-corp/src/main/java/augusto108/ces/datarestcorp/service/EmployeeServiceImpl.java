package augusto108.ces.datarestcorp.service;

import augusto108.ces.datarestcorp.model.Employee;
import augusto108.ces.datarestcorp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public Page<Employee> findEmployeeByRegistration(String registration, int page, int size) {
        return repository.findEmployeeByRegistration(registration, PageRequest.of(page, size));
    }

    @Override
    public Page<Employee> findEmployeeByDescription(String description, int page, int size) {
        return repository.findEmployeeByDescription(description, PageRequest.of(page, size));
    }

    @Override
    public Page<Employee> findEmployees(String search, int page, int size) {
        return repository.findEmployees(search, PageRequest.of(page, size));
    }
}
