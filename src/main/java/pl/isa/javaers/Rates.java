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
    private static List<CurrRate> rates;

    public Rates() {
    }

    @Override
    public String toString() {
        return "Rates{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                '}';
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


    public List<CurrRate> getRates() {

        return rates;
    }
}
