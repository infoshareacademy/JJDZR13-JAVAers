package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Rate {
//      "no": "001/A/NBP/2023",
//              "effectiveDate": "2023-01-02",
//              "mid": 2.3920
    private String no;
    private String effectiveDate;
    private String mid;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public String getMid() {
        return mid;
    }
}
