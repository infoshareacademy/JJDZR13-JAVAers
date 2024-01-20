package pl.isa.javaers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/BGN.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP kursBGN = objectMapper.readValue(data, KursNBP.class);
            System.out.println(kursBGN.getCurrency());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
