package pl.isa.javaers;
//Class for storing currencies, crypto-currencies and other assets supported by this Application
public class Asset {
    public String ShortName;
    private String FullName;
    private float Value;

    public Asset(String shortName, String fullName, float val) {
        ShortName = shortName;
        FullName = fullName;
        Value = val;
    }
}