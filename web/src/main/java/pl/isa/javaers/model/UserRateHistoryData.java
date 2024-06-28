package pl.isa.javaers.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class UserRateHistoryData {
    private String userCurrencyCode;
    private LocalDate startDate;
    private LocalDate endDate;

    public UserRateHistoryData() {
    }

    public UserRateHistoryData(String userCurrencyCode, LocalDate startDate, LocalDate endDate) {
        this.userCurrencyCode = userCurrencyCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRateHistoryData that = (UserRateHistoryData) o;
        return Objects.equals(userCurrencyCode, that.userCurrencyCode) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userCurrencyCode, startDate, endDate);
    }

    public String getUserCurrencyCode() {
        return userCurrencyCode;
    }

    public void setUserCurrencyCode(String userCurrencyCode) {
        this.userCurrencyCode = userCurrencyCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "UserRateHistoryData{" +
                "userCurrencyCode='" + userCurrencyCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

}
