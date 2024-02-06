package pl.isa.javaers;
//Class for storing currencies, crypto-currencies and other assets supported by this Application
public class Asset {
    public String ShortName;
    private String FullName;

    public Asset(String shortName, String fullName) {
        ShortName = shortName;
        FullName = fullName;
    }
}