package entities;

import java.time.LocalDate;

public class Log {
    private LocalDate date;
    private Student advanceDescription;
    private int advancePercentage;

    public Log(LocalDate date, Student advanceDescription, int advancePercentage) {
        this.date = date;
        this.advanceDescription = advanceDescription;
        this.advancePercentage = advancePercentage;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
