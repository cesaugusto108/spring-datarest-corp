package augusto108.ces.datarestcorp.service;

import augusto108.ces.datarestcorp.model.Authority;
import augusto108.ces.datarestcorp.model.HREmployee;
import augusto108.ces.datarestcorp.repository.HREmployeeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HREmployeeServiceImpl implements HREmployeeService {
    private final HREmployeeDAO dao;

    @Override
    public HREmployee findHREmployeeByHRUsername(String username) {
        return dao.findHREmployeeByHRUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HREmployee hrEmployee = dao.findHREmployeeByHRUsername(username);

        if (Objects.isNull(hrEmployee)) throw new UsernameNotFoundException("Invalid username or password");

        Collection<Authority> authorities = hrEmployee.getAuthorities();

        return new User(hrEmployee.getHrUsername(), hrEmployee.getPassword(), mapAuthoritiesToPermissions(authorities));
    }

    private Collection<? extends GrantedAuthority> mapAuthoritiesToPermissions(Collection<Authority> authorities) {
        return authorities
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getDescription())).collect(Collectors.toList());
    }
}
