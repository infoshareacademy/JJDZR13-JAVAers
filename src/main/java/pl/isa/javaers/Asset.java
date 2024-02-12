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

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        Value = value;
    }

    public Asset(String shortName, String fullName){
        ShortName = shortName;
        FullName = fullName;
    }
}