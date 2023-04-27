package augusto108.ces.datarestcorp.repository;

import augusto108.ces.datarestcorp.model.HREmployee;

public interface HREmployeeDAO {
    HREmployee findHREmployeeByHRUsername(String username);
}
