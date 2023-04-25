package augusto108.ces.datarestcorp.repository;

import augusto108.ces.datarestcorp.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "collaborators", collectionResourceRel = "collaborators", itemResourceRel = "collaborator")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("from Employee e where registration like concat('%', :registration, '%')")
    Page<Employee> findEmployeeByRegistration(@Param("registration") String registration, Pageable pageable);

    @Query("from Employee e where description like concat('%', :description, '%')")
    Page<Employee> findEmployeeByDescription(@Param("description") String description, Pageable pageable);

    @Query(
            "from Employee e where " +
                    "name.firstName like concat('%', :name, '%') or " +
                    "name.lastName like concat('%', :name, '%') order by name.firstName asc"
    )
    Page<Employee> findEmployeeByName(@Param("name") String name, Pageable pageable);

    @Query(
            "from Employee e where " +
                    "description like concat('%', :search, '%') or " +
                    "registration like concat('%', :search, '%') or " +
                    "name.firstName like concat('%', :search, '%') or " +
                    "name.lastName like concat('%', :search, '%') order by name.firstName asc"
    )
    Page<Employee> findEmployees(@Param("search") String search, Pageable pageable);
}
