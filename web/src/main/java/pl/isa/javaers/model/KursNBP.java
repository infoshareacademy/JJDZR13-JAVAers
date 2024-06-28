package pl.isa.javaers.model;

import pl.isa.javaers.Rate;

import java.util.List;
import java.util.Objects;

public class KursNBP {
//     "table": "A",
//            "currency": "lew (Bułgaria)",
//            "code": "BGN",
//            "rates": [

    private String table;
    private String currency;
    private String code;
    private List<pl.isa.javaers.Rate> rates;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KursNBP kursNBP = (KursNBP) o;
        return Objects.equals(table, kursNBP.table) && Objects.equals(currency, kursNBP.currency) && Objects.equals(code, kursNBP.code) && Objects.equals(rates, kursNBP.rates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, currency, code, rates);
    }

    public KursNBP() {
    }
}
