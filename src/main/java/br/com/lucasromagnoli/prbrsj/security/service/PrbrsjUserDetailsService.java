package br.com.lucasromagnoli.prbrsj.security.service;

import br.com.lucasromagnoli.prbrsj.domain.model.SystemUser;
import br.com.lucasromagnoli.prbrsj.domain.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("PrbrsjUserDetailsService")
public class PrbrsjUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<SystemUser> userOptional = systemUserRepository.findByEmail(email);
        // TODO: Colocar a mensagem em .properties
        SystemUser user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
        return new User(email, user.getPassword(), getRoles(user));
    }

    private Collection<? extends GrantedAuthority> getRoles(SystemUser user) {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        user.getRoles().forEach(r -> roles.add(new SimpleGrantedAuthority(r.getDescription().toUpperCase())));

        return roles;
    }
}
