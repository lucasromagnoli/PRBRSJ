package br.com.lucasromagnoli.prbrsj.domain.repository;

import br.com.lucasromagnoli.prbrsj.domain.model.PrbrsjUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<PrbrsjUser, Long> {

    public Optional<PrbrsjUser> findByEmail(String email);
}
