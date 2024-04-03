package pl.isa.javaers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class CurrRate {
    //      "no": "001/A/NBP/2023",
//              "effectiveDate": "2023-01-02",
//              "mid": 2.3920
    @JsonProperty
    private String no;
    @JsonProperty
    private String effectiveDate;
    @JsonProperty
    private float mid;
    private List<CurrRate> currRateList;

        public CurrRate() {
    }

    public CurrRate(String no, String effectiveDate, float mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Rate{ " +
                "Date: " + getEffectiveDate() + '\'' +
                "Mid rate " + getMid() + '\'';
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public float getMid() {
        return mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrRate currRate = (CurrRate) o;
        return Float.compare(mid, currRate.mid) == 0 && Objects.equals(no, currRate.no) && Objects.equals(effectiveDate, currRate.effectiveDate) && Objects.equals(currRateList, currRate.currRateList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, effectiveDate, mid, currRateList);
    }
}
