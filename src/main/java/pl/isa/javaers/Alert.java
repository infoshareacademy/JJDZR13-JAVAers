package pl.isa.javaers;

import static pl.isa.javaers.ErrorCodes.*;

public class Alert {
    private String alertID;             //unique alert identifier
    private String userID;              //unique User identifier
    private String currCode;            //three letters currency code ie. PLN, USD, GBP
    private float course;               // value ie. 16,5643 (four places after comma)
    private boolean higherOrLower;      //True for higher False for lower than course

    //
    public int create(String aID, String uID, String cCode, float course, boolean hL) {
        int errCode = 0;            //error code, 0 - means no error

        if(0 != User.checkID(uID)) return(USER_WRONGID);
        if(0 != Assets.checkCurrencyCode(cCode)) return(ASSETS_WRONGCCODE);

        return(errCode);
    }
}
