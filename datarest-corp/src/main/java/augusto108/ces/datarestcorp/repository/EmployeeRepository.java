package augusto108.ces.datarestcorp.repository;

import augusto108.ces.datarestcorp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "collaborators", collectionResourceRel = "collaborators", itemResourceRel = "collaborator")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("from Employee e where registration like concat('%', :registration, '%')")
    List<Employee> findEmployeeByRegistration(@Param("registration") String registration);
}
