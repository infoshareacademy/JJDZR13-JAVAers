package pl.isa.javaers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static pl.isa.javaers.ErrorCodes.ASSETS_WRONGCCODE;


public class Assets {
    public static HashMap<String, Asset> assets = new HashMap<>();

    public static HashMap<String, Asset> loadAssets() {

        assets.put("PLN", new Asset("PLN", "Polski Złoty", 1f));
        assets.put("USD", new Asset("USD", "Dolar Amerykański", 4.2f));
        assets.put("EUR", new Asset("EUR", "Euro", 4.4f));
        assets.put("GBP", new Asset("GBP", "Funt Brytyjski", 4.65f));
        assets.put("CHF", new Asset("CHF", "Frank Szwajcarski", 4.5f));
        assets.put("SEK", new Asset("SEK", "Korona Szwedzka", 0.39f));
        assets.put("NOK", new Asset("NOK", "Korona Norweska", 0.38f));
        assets.put("DKK", new Asset("DKK", "Korona Duńska", 0.61f));
        return null;
    }

    public static HashMap<String, Asset> loadAssetCodes() {
        assets.put("PLN", new Asset("PLN", "Polski Złoty"));
        assets.put("USD", new Asset("USD", "Dolar Amerykański"));
        assets.put("EUR", new Asset("EUR", "Euro"));
        assets.put("GBP", new Asset("GBP", "Funt Brytyjski"));
        assets.put("CHF", new Asset("CHF", "Frank Szwajcarski"));
        assets.put("SEK", new Asset("SEK", "Korona Szwedzka"));
        assets.put("NOK", new Asset("NOK", "Korona Norweska"));
        assets.put("DKK", new Asset("DKK", "Korona Duńska"));
        assets.put("BGN", new Asset("BGN", "Lew Bułgarski"));
        assets.put("CZK", new Asset("CZK", "Korona Czeska"));
        assets.put("HUF", new Asset("HUF", "Forint węgierski"));
        assets.put("ISK", new Asset("ISK", "Korona islandzka"));
        assets.put("JPY", new Asset("JPY", "Jen - Japonia"));
        assets.put("RON", new Asset("RON", "Lej Rumuński"));
        assets.put("TRY", new Asset("TRY", "Lira turecka"));
        return null;
    }

    //check if the Asset's code is supported by the Application
    public static int checkCurrencyCode(String cCode) {
        //return assets.stream().findFirst(cCode);
        return assets.containsKey(cCode) ? 0 : ASSETS_WRONGCCODE;
    }

    public HashMap<String, Asset> getAllAssets() {
        HashMap<String, Asset> temporaryAssets = new HashMap();
        temporaryAssets.putAll(assets);
        return temporaryAssets;
    }
//    public List<Alert> getUserAlerts(String uID) {
//        List<Alert> tmpAlerts = new ArrayList<>();
//        tmpAlerts.addAll(alerts.stream().filter(c -> uID.equals(c.getUserID())).toList());
//        return tmpAlerts;
//    }

}
