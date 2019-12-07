package br.com.lucasromagnoli.prbrsj.security.model;

import br.com.lucasromagnoli.prbrsj.domain.model.PrbrsjUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SystemUser extends User {

    private PrbrsjUser prbrsjUser;

    public SystemUser(PrbrsjUser prbrsjUser,
                      Collection<? extends GrantedAuthority> authorities) {
        super(prbrsjUser.getEmail(), prbrsjUser.getPassword(), authorities);
        this.prbrsjUser = prbrsjUser;
    }

    public PrbrsjUser getPrbrsjUser() {
        return prbrsjUser;
    }
}
