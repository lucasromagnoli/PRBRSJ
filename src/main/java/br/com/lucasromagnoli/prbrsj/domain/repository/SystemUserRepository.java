package br.com.lucasromagnoli.prbrsj.domain.repository;

import br.com.lucasromagnoli.prbrsj.domain.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {

    public Optional<SystemUser> findByEmail(String email);
}
