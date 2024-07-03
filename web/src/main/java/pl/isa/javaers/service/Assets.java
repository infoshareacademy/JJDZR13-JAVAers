package pl.isa.javaers.service;

import pl.isa.javaers.Asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static pl.isa.javaers.ErrorCodes.ASSETS_WRONGCCODE;


public class Assets {
    //public static ArrayList<Asset> assets = new ArrayList<>();
    public static HashMap<String, Asset> assets = new HashMap<>();
    public static void loadAssets() {

//        assets.put("PLN", new Asset("PLN","Polski Złoty", 1f));
        assets.put("THB", new Asset("THB", "bat (Tajlandia)", 0.1096f));
        assets.put("USD", new Asset("USD","Dolar amerykański", 4.09f));
        assets.put("AUD", new Asset("AUD","Dolar Australia", 2.678f));
        assets.put("HKD", new Asset("HKD", "dolar Hongkongu", 0.5163f));
        assets.put("CAD", new Asset("CAD","Dolar kanadyjski", 2.941f));
        assets.put("NZD", new Asset("NZD","Dolar nowozelandzki", 2.4474f));
        assets.put("NZD", new Asset("NZD","Dolar nowozelandzki", 2.4474f));
        assets.put("SGD", new Asset("SGD","Dolar singapurski", 2.9712f));
        assets.put("EUR", new Asset("EUR","Euro", 4.313f));
        assets.put("HUF", new Asset("HUF","Forint (Węgry)", 0.010916f));
        assets.put("CHF", new Asset("CHF","Frank szwajcarski", 4.4813f));
        assets.put("GBP", new Asset("GBP","Funt szterling", 5.0942f));
        assets.put("UAH", new Asset("UAH","Hrywna (Ukraina)", 0.0996f));
        assets.put("JPY", new Asset("JPY","Jen (Japonia)", 0.025054f));
        assets.put("CZK", new Asset("CZK","Korona czeska", 0.1724f));
        assets.put("DKK", new Asset("DKK","Korona duńska", 0.5783f));
        assets.put("ISK", new Asset("ISK","Korona islandzka", 0.028966f));
        assets.put("NOK", new Asset("NOK","Korona norweska", 0.3782f));
        assets.put("SEK", new Asset("SEK","Korona szwedzka", 0.3791f));
        assets.put("RON", new Asset("RON","Lej rumuński", 0.8665f));
        assets.put("BGN", new Asset("BGN","Lew (Bułgaria)", 2.2052f));
        assets.put("TRY", new Asset("TRY","Lira turecka", 0.1224f));
        assets.put("ILS", new Asset("ILS","Nowy izraelski szekel", 1.0719f));
        assets.put("CLP", new Asset("CLP","Peso chilijskie", 0.004218f));
        assets.put("PHP", new Asset("PHP","Peso filipińskie", 0.0689f));
        assets.put("MXN", new Asset("MXN","Peso meksykańskie", 0.2197f));
        assets.put("ZAR", new Asset("ZAR","Rand (Republika Południowej Afryki)", 0.2215f));
        assets.put("BRL", new Asset("BRL","Real (Brazylia)", 0.7329f));
        assets.put("MYR", new Asset("MYR","Ringgit (Malezja)", 0.8543f));
        assets.put("IDR", new Asset("IDR","Rupia indonezyjska", 0.00024623f));
        assets.put("INR", new Asset("INR","Rupia indyjska", 0.048336f));
        assets.put("KRW", new Asset("KRW","Won południowokoreański", 0.002925f));
        assets.put("CNY", new Asset("CNY","Yuan renminbi (Chiny)", 0.5549f));
        assets.put("XDR", new Asset("XDR","SDR (MFW)", 5.3026f));


    }
    //check if the Asset's code is supported by the Application
    public static int checkCurrencyCode(String cCode) {
        return assets.containsKey(cCode)?0:ASSETS_WRONGCCODE;
    }

    public static List<String> listCodes() {
        List<String> list = new ArrayList<>();
        for (String code : assets.keySet()) {
            list.add(code);
        }
        return list.stream().sorted().toList();
    }

}
