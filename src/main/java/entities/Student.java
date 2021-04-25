package entities;

import java.time.Duration;
import java.util.ArrayList;

public class Student {
    private int code;
    private String name;
    private String LastName;
    private String email;
    private ArrayList<Activity> assignedActivities;
    private ArrayList<Course> approved;

    public Student(int code, String name, String lastName, String email) {
        this.code = code;
        this.name = name;
        this.LastName = lastName;
        this.email = email;
        this.assignedActivities = new ArrayList();
        this.approved = new ArrayList();
    }

    public void asignActivity(Activity activity) {
        this.assignedActivities.add(activity);
    }

    public void addCourseApproved(Course course) {
        this.approved.add(course);
    }
    public Duration getActivitiesDuration() throws SabanaResearchException {

        Duration d = Duration.ZERO;

        for (Activity a: assignedActivities){
            d = d.plus(a.getDuration());
        }

        return d;
    }

    public String getName() {
        return this.name;
    }
}
