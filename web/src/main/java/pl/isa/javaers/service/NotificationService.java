package pl.isa.javaers.service;

import org.springframework.stereotype.Service;
import pl.isa.javaers.model.Notification;
import pl.isa.javaers.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public Notification getNotification() {
        return notificationRepository.getNotification();
    }

    public void create(Notification notification) {
        Long id = UUID.randomUUID().timestamp();
        notification.setDateTimeCreated(LocalDateTime.now());
        notification.setNotificationId(id);
        notificationRepository.create(notification);
    }

    public void delete(Notification notification) {
        notificationRepository.delete(notification);
    }
}
