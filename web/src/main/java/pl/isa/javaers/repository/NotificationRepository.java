package pl.isa.javaers.repository;

import org.springframework.stereotype.Repository;
import pl.isa.javaers.model.Notification;

import java.util.List;
@Repository
public interface NotificationRepository {

    List<Notification> getAllNotifications();
    void create(Notification notification);

    void delete(Notification notification);
    Notification findNotificationdById(String id);
    void update(Notification notification);

}
