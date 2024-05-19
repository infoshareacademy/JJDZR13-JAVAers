package pl.isa.javaers.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
@Getter
@Setter
@NoArgsConstructor
public class Notification {

    private long notificationId;
    private String userId;
    private LocalDateTime dateTimeCreated;
    private LocalDateTime dateTimeUpdated;
    private final String description = "Spełniono warunek";
    private boolean isNotifyLaunched;
    private String currency1Code;
//    private String currency2Code;
    private boolean isHigherOrLower;
    private float course;
}
