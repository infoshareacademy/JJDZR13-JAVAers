package pl.isa.javaers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.isa.javaers.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static pl.isa.javaers.Main.alerts;

@SpringBootApplication
public class JAVAers {

	public static List<String> assetCodes = null;
	UserService userServiceGlobal = new UserService();

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
