package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Iteration {
    private String goal;
    private Project project;
    private List<Activity> activities;
    private LocalDate dateInit;
    private LocalDate dateEnd;

    public Iteration(String goal, Project project) {
        this.goal = goal;
        this.project = project;
        this.activities = new ArrayList();
        project.addIteration(this);
        this.dateInit = this.dateInit;
        this.dateEnd = this.dateEnd;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void setDateInit(LocalDate dateInit) {
        this.dateInit = dateInit;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Activity> getActivities() {
        return this.activities;
    }

    public Duration getDuration() throws SabanaResearchException{
        Duration duration = Duration.ofDays(0);
        if(this.activities.size()!=0) {
            for (int i = 0; i < this.activities.size(); i++) {
                Activity a = this.activities.get(i);
                duration = a.getDuration();
            }
        }
        else {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_ITERATION);
        }
        return duration;
    }
}


