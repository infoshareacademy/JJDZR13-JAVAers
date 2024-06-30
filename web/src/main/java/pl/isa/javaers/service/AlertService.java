package pl.isa.javaers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.isa.javaers.dto.AlertDTO;
import pl.isa.javaers.model.Alert;
import pl.isa.javaers.repository.AlertRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public Alert saveAlert(Alert alert) {
        return alertRepository.save(alert);
    }
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public Alert getAlertById(UUID uuid) {
        return alertRepository.findById(uuid).orElse(null);
    }

    public List<Alert> getUserAlerts(Long userId) {
        return alertRepository.findAll().stream().filter(a -> Objects.equals(a.getUser().getId(), userId)).toList();
    }
    public List<AlertDTO> getUserAlertsDTO(Long userId){
        return alertRepository.findAll()
                .stream()
                .filter(a -> Objects.equals(a.getUser().getId(), userId))
                .map(Alert::toDTO)
                .toList();
    }

    public void deleteAlert(UUID uuid) {
        alertRepository.deleteById(uuid);
    }
}
