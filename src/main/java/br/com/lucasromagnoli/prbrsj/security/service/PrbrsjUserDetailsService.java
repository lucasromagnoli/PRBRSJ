package br.com.lucasromagnoli.prbrsj.security.service;

import br.com.lucasromagnoli.prbrsj.domain.model.PrbrsjUser;
import br.com.lucasromagnoli.prbrsj.domain.repository.UserRepository;
import br.com.lucasromagnoli.prbrsj.domain.support.PrbrsjPropertiesSupport;
import br.com.lucasromagnoli.prbrsj.security.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private UserRepository userRepository;

    @Autowired
    private PrbrsjPropertiesSupport prbrsjPropertiesSupport;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<PrbrsjUser> userOptional = userRepository.findByEmail(email);

        PrbrsjUser prbrsjUser = userOptional.orElseThrow(() -> new UsernameNotFoundException(
                prbrsjPropertiesSupport.getProperty("auth.fail.to.authenticate.user.and.password")));
        return new SystemUser(prbrsjUser, getRoles(prbrsjUser));
    }

    private Collection<? extends GrantedAuthority> getRoles(PrbrsjUser prbrsjUser) {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        prbrsjUser.getRoles().forEach(r -> roles.add(new SimpleGrantedAuthority(r.getDescription().toUpperCase())));

        return roles;
    }
}
