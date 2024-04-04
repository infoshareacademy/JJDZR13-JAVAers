package pl.isa.javaers.model;

import java.util.Objects;

public class Rate {
    //      "no": "001/A/NBP/2023",
//              "effectiveDate": "2023-01-02",
//              "mid": 2.3920

    private String no;
    private String effectiveDate;
    private float mid;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public float getMid() {
        return mid;
    }

    public Rate(String no, String effectiveDate, float mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public Rate() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Float.compare(mid, rate.mid) == 0 && Objects.equals(no, rate.no) && Objects.equals(effectiveDate, rate.effectiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, effectiveDate, mid);
    }
}
