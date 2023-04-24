package augusto108.ces.datarestcorp.service;

import augusto108.ces.datarestcorp.model.Employee;
import augusto108.ces.datarestcorp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findEmployeeByRegistration(String registration) {
        return repository.findEmployeeByRegistration(registration);
    }
}
