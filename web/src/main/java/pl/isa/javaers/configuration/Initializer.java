package pl.isa.javaers.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Component
//@Slf4j
public class Initializer {
    @PostConstruct
    public void init() {
//        log.info("Initializing application...");
        System.out.println("Initializing application...");

        try {
            Files.copy(Path.of("web/src/main/resources/alerty.hard.json"),
                    Path.of("web/src/main/resources/alerty.json"),
                    REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
