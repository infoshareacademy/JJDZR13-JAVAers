package pl.isa.javaers.model;

import org.springframework.format.annotation.DateTimeFormat;
import pl.isa.javaers.service.UserService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class UserNotification {
    private UUID notificationId;
//    private long userId;
    private final LocalDateTime today;
    private String currCode;
    private boolean higherOrLower;
    private float expectedCourse;
    private double todayCourse;

    public UserNotification(String currCode, boolean hL, float expectedCourse, double todayCourse) {
        this.notificationId = UUID.randomUUID();
        this.today = LocalDateTime.now();
        this.currCode = currCode;
        this.higherOrLower = hL;
        this.expectedCourse = expectedCourse;
        this.todayCourse = todayCourse;
    }

    public String getCurrCode() {
        return currCode;
    }

    public boolean isHigherOrLower() {
        return higherOrLower;
    }

    public float getExpectedCourse() {
        return expectedCourse;
    }

    public double getTodayCourse() {
        return todayCourse;
    }
}

