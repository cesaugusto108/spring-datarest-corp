package augusto108.ces.datarestcorp.repository;

import augusto108.ces.datarestcorp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
