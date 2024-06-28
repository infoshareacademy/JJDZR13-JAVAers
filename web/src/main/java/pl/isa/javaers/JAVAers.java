package pl.isa.javaers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.isa.javaers.service.UserService;
import org.springframework.web.client.RestTemplate;
import pl.isa.javaers.service.CurrRatesList;
import pl.isa.javaers.service.RateServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static pl.isa.javaers.Main.alerts;

@SpringBootApplication
@ComponentScan(basePackages = {"pl.isa.javaers.service", "pl.isa.javaers.repository", "pl.isa.javaers.controller","pl.isa.javaers.configuration","pl.isa.javaers.dto","pl.isa.javaers.model"})
public class JAVAers {

	public static List<String> assetCodes = null;
//	UserService userServiceGlobal = new UserService();

	public static void main(String[] args) {
		SpringApplication.run(JAVAers.class, args);
		List<AlertJSON> tmpAlertJSONS = new ArrayList<>();
		Assets.loadAssets();
		DailyAlertChecker.dailyAlertCheckerFileSaver();
		//new MainMenu().runMenu();
		alerts = new Alerts();
		alerts.loadAlerts();
		pl.isa.javaers.service.Assets.loadAssets();
		assetCodes = pl.isa.javaers.service.Assets.listCodes();


	}

}
