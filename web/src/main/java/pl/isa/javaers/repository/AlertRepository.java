package pl.isa.javaers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.isa.javaers.model.Alert;

import java.util.UUID;
@Repository
public interface AlertRepository extends JpaRepository<Alert, UUID> {
}
