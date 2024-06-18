package pl.isa.javaers.dto;

import pl.isa.javaers.model.CurrRates;

import java.util.List;

public class CurrentTableDTO {
    private String table;
    private String no;
    private String effectiveDate;

    List<CurrRates> rates;

    public CurrentTableDTO() {
    }

    public CurrentTableDTO(String table, String no, String effectiveDate, List<CurrRates> rates) {
        this.table = table;
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }



    public List<CurrRates> getRates() {
        return rates;
    }

    public void setRates(List<CurrRates> rates) {
        this.rates = rates;
    }
}
