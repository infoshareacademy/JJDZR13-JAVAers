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
    private LocalDateTime dateTimeCreated;
    private final String description = "Spełniono warunek";

}
