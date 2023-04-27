package augusto108.ces.datarestcorp.repository;

import augusto108.ces.datarestcorp.model.HREmployee;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HREmployeeDAOImpl implements HREmployeeDAO {
    private final EntityManager entityManager;

    @Override
    public HREmployee findHREmployeeByHRUsername(String username) {
        HREmployee hrEmployee = new HREmployee();

        try {
            hrEmployee = entityManager
                    .createQuery("from HREmployee h where hrUsername = :username", HREmployee.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }

        return hrEmployee;
    }
}
