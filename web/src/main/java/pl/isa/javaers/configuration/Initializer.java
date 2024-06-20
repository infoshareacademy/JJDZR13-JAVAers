package pl.isa.javaers.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
//@Slf4j
public class Initializer {
    @PostConstruct
    public void init() {
//        log.info("Initializing application...");
        System.out.println("Initializing application...");
    }
}
