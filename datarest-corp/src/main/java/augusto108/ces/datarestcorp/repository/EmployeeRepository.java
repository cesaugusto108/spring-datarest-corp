package augusto108.ces.datarestcorp.repository;

import augusto108.ces.datarestcorp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "collaborators", collectionResourceRel = "collaborators", itemResourceRel = "collaborator")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
