package pl.isa.javaers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Assets.loadAssets();
        Alert alarm = new Alert();
        ArrayList<Asset> assets = new ArrayList<>();

        //assets.add(0, new Asset("PLN","Polski Złoty"));

        try {
            byte[] data = Files.readAllBytes(Paths.get("src/main/resources/KursyNBP/BGN.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            KursNBP kursBGN = objectMapper.readValue(data, KursNBP.class);
            System.out.println(kursBGN.getCurrency());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        alarm.create("aID","uID","USD",4.3f,true);
        System.out.println(alarm.toString());
    }
}
