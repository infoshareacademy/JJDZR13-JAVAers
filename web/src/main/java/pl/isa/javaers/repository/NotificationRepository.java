package pl.isa.javaers.repository;

import pl.isa.javaers.model.Notification;

import java.util.List;

public interface NotificationRepository {

    Notification getNotification();

    void create(Notification notification);

    void delete(Notification notification);

}
