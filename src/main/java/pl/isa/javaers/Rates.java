package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rates {
//    "table": "A",
//            "currency": "lew (Bułgaria)",
//            "code": "BGN",
//            "rates": [

    private String table;
    private String currency;
    private String code;
    private static List<Rates> rates;

    public Rates() {
    }

//    public Rates(String table, String currency, String code) {
//        this.table = table;
//        this.currency = currency;
//        this.code = code;
//    }

    @Override
    public String toString() {
        return "Rates for: " +
                getCode();
    }
@JsonIgnore
    public String getTable() {
        return table;
    }

    @JsonIgnore
    public String getCurrency() {
        return currency;
    }

    @JsonIgnore
    public String getCode() {
        return code;
    }


    public List<Rates> getRates() {

        return rates;
    }
}
