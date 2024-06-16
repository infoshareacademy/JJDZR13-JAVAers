package pl.isa.javaers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import pl.isa.javaers.service.RateServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static pl.isa.javaers.Main.alerts;

@SpringBootApplication
public class JAVAers {

	public static void main(String[] args) {
		SpringApplication.run(JAVAers.class, args);
		List<Alert> tmpAlerts = new ArrayList<>();
		Assets.loadAssets();
		DailyAlertChecker.dailyAlertCheckerFileSaver();
		//new MainMenu().runMenu();
		alerts = new Alerts();
		alerts.loadAlerts();

	}

}
