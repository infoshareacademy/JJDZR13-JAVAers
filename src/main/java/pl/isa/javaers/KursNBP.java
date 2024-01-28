package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class KursNBP {
//    "table": "A",
//            "currency": "lew (Bułgaria)",
//            "code": "BGN",
//            "rates": [

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

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
