package pl.isa.javaers;

import java.util.ArrayList;


public class Assets {
    public static ArrayList<Asset> assets = new ArrayList<>();

    public static void loadAssets() {

        assets.add(new Asset("PLN","Polski Złoty"));
        assets.add(new Asset("USD","Dolar Amerykański"));
        assets.add(new Asset("EUR","Euro"));
    }
    //check if the Asset's code is supported by the Application
    public static int checkCurrencyCode(String cCode) {
        //return assets.stream().findFirst(cCode);
        return(assets.indexOf(cCode));
    }


}
