package pl.isa.javaers.service;

import org.springframework.stereotype.Service;
import pl.isa.javaers.Alert;
import pl.isa.javaers.model.Notification;
import pl.isa.javaers.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final Alerts alerts;
//    private RateService rateService;
//
//    public List<Rate> readRatesFromJSON(UserRateHistoryData userRateHistoryData) {
//        return rateService.readRatesFromJSON(userRateHistoryData);
//    }

    public NotificationService(NotificationRepository notificationRepository, Alerts alerts){
        this.notificationRepository = notificationRepository;

        this.alerts = alerts;
    }


    public List<Notification> getAllNotifications() {
        return notificationRepository.getAllNotifications();
            }

    public void createNotification(Notification notification) {
        Long id = UUID.randomUUID().timestamp();
        notification.setDateTimeCreated(LocalDateTime.now());
        notification.setNotificationId(id);
        notificationRepository.create(notification);
    }

    public void deleteNotification(Notification notification) {
        notificationRepository.delete(notification);
    }

    public List<Notification> getAllLaunchedNotifications() {
        return  notificationRepository.getAllNotifications().stream()
                .filter(Notification::isNotifyLaunched)
                .sorted(Comparator.comparing(Notification::getDateTimeUpdated).reversed())
                .toList();
    }
    public void launchNotification(String uID){
//        for(Notification notification : notificationRepository.getAllNotifications()) {
//            if (notification.getCurrency1Code().equals(alerts.getUserAlerts(uId).stream().filter())
//
        List<Alert> tmpAlerts = alerts.getUserAlerts(uID);

        Notification notificationLaunched = notificationRepository.findNotificationdById(uID); // implement checked notification alert boolean;
        if (notificationLaunched != null) {
            notificationLaunched.setNotifyLaunched(true);
            notificationLaunched.setDateTimeCreated(LocalDateTime.now());
            notificationRepository.update(notificationLaunched);
        }
    }
}
