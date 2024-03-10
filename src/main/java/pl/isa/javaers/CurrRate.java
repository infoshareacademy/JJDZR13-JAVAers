package pl.isa.javaers;

import java.util.List;

public class CurrRate {
    //      "no": "001/A/NBP/2023",
//              "effectiveDate": "2023-01-02",
//              "mid": 2.3920
    private String no;
    private String effectiveDate;
    private float mid;
    private List<CurrRate> currRateList;

        public CurrRate() {
    }

//    public CurrRate(String no, String effectiveDate, float mid) {
//        this.no = no;
//        this.effectiveDate = effectiveDate;
//        this.mid = mid;
//    }

//    @Override
//    public String toString() {
//        return "Rate{ " +
//                "Date: " + getEffectiveDate() + '\'' +
//                "Mid rate " + getMid() + '\'';
//    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public float getMid() {
        return mid;
    }

}
