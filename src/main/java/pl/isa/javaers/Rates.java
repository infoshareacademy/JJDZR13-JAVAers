package pl.isa.javaers;

import java.util.List;

public class Rates {
//    "table": "A",
//            "currency": "lew (Bułgaria)",
//            "code": "BGN",
//            "rates": [

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    @Override
    public String toString(){
        return "Rates for: " +
                getCode();
    }
    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<Rate> getRates() {
        return rates;
    }
}
