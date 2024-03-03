package pl.isa.javaers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import static pl.isa.javaers.ErrorCodes.ASSETS_WRONGCCODE;


public class Assets {
    //public static ArrayList<Asset> assets = new ArrayList<>();
    public static HashMap<String,Asset> assets = new HashMap<>();
    public static void loadAssets() {

        assets.put("PLN",new Asset("PLN","Polski Złoty", 1f));
        assets.put("USD",new Asset("USD","Dolar Amerykański", 4.2f));
        assets.put("EUR",new Asset("EUR","Euro", 4.4f));
        assets.put("GBP", new Asset("GBP", "Funt Brytyjski", 4.65f));
        assets.put("CHF", new Asset("CHF", "Frank Szwajcarski", 4.5f));
        assets.put("SEK", new Asset("SEK","Korona Szwedzka", 0.39f));
        assets.put("NOK", new Asset("NOK","Korona Norweska", 0.38f));
        assets.put("DKK", new Asset("DKK","Korona Duńska", 0.61f));
    }
    //check if the Asset's code is supported by the Application
    public static int checkCurrencyCode(String cCode) {
        //return assets.stream().findFirst(cCode);
        return assets.containsKey(cCode)?0:ASSETS_WRONGCCODE;
    }


}
