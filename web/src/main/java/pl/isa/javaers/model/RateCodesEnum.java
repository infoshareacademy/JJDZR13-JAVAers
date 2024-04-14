package pl.isa.javaers.model;

public enum RateCodesEnum {
    BGN("BGN"),
    CHF("CHF"),
    CZK("CZK"),
    DKK("DKK"),
    EUR("EUR"),
    GBP("GBP"),
    HUF("HUF"),
    ISK("ISK"),
    JPY("JPY"),
    NOK("NOK"),
    RON("RON"),
    SEK("SEK"),
    TRY("TRY"),
    USD("USD");


    private final String value;
    RateCodesEnum(String value) {this.value = value;
    }

    public String getValue() {
        return value;
    }
}
