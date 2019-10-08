package hu.elte.alkfejl.expensetracker.security;

import hu.elte.alkfejl.expensetracker.entities.User;
import hu.elte.alkfejl.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> oUser = userRepository.findByUsername(username);
        if (!oUser.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        User user = oUser.get();
        authenticatedUser.setUser(user);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
