package pl.isa.javaers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Rate {
    //      "no": "001/A/NBP/2023",
//              "effectiveDate": "2023-01-02",
//              "mid": 2.3920
    private String no;
    private String effectiveDate;
    private float mid;


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

}
