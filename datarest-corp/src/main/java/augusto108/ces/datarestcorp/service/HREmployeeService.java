package augusto108.ces.datarestcorp.service;

import augusto108.ces.datarestcorp.model.HREmployee;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface HREmployeeService extends UserDetailsService {
    HREmployee findHREmployeeByHRUsername(String username);
}
