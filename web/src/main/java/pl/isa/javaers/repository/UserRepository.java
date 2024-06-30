package pl.isa.javaers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.isa.javaers.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findByUsername(String username);

}