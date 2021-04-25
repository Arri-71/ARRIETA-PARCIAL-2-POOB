package entities;

import java.time.LocalDate;

public class Summary {
    private int activeProjects;
    private LocalDate date;
    private int openActivities;
    private int closedActivities;

    public Summary(int activeProjects, LocalDate date, int openActivities, int closedActivities) {
        this.activeProjects = activeProjects;
        this.date = date;
        this.openActivities = openActivities;
        this.closedActivities = closedActivities;
    }

    public void setActiveProjects(int activeProjects) {
        this.activeProjects = activeProjects;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOpenActivities() {
        return this.openActivities;
    }

    public void setOpenActivities(int openActivities) {
        this.openActivities = openActivities;
    }

    public int getClosedActivities() {
        return this.closedActivities;
    }

    public void setClosedActivities(int closedActivities) {
        this.closedActivities = closedActivities;
    }

    public int getActiveProjects() {
        return this.activeProjects;
    }

    public LocalDate getDate() {
        return this.date;
    }
}