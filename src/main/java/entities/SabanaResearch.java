package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SabanaResearch {
    private List<Group> groups;
    private List<Summary> summaries;
    private List<Course> courses;
    private List<Student> students;

    public SabanaResearch(List<Group> groups) {
        this.groups = groups;
        this.summaries = new ArrayList();
        this.courses = new ArrayList();
        this.students = new ArrayList();
    }

    public int countOfGroups() {
        return this.groups.size();
    }

    public int countOfSummaries() {
        return this.summaries.size();
    }

    public int countOfStudents() {
        return this.students.size();
    }

    public int countOfCourses() {
        return this.courses.size();
    }

    public Summary createSummaryEntry() {
        LocalDate date = LocalDate.now();
        int activeProjects = this.countActiveProjects();
        int openActivities = this.countOpenActivities();
        int closedActivities = this.countClosedActivities();
        return new Summary(activeProjects, date, openActivities, closedActivities);
    }

    public int countActiveProjects() {
        int counter = 0;

        for(int i = 0; i < this.groups.size(); ++i) {
            for(int j = 0; j < ((Group)this.groups.get(j)).getProjects().size(); ++j) {
                Project p = (Project)((Group)this.groups.get(j)).getProjects().get(j);
                if (p.isActive()) {
                    ++counter;
                }
            }
        }

        return counter;
    }

    public int countOpenActivities() {
        int counter = 0;

        for(int i = 0; i < this.groups.size(); ++i) {
            for(int j = 0; j < ((Group)this.groups.get(j)).getProjects().size(); ++j) {
                Project p = (Project)((Group)this.groups.get(j)).getProjects().get(j);
                if (p.isActive()) {
                    for(int k = 0; k < p.getIterations().size(); ++k) {
                        for(int n = 0; n < ((Iteration)p.getIterations().get(k)).getActivities().size(); ++n) {
                            Activity a = (Activity)((Iteration)p.getIterations().get(k)).getActivities().get(n);
                            if (a.isActive()) {
                                ++counter;
                            }
                        }
                    }
                }
            }
        }

        return counter;
    }

    public int countClosedActivities() {
        int counter = 0;

        for(int i = 0; i < this.groups.size(); ++i) {
            for(int j = 0; j < ((Group)this.groups.get(j)).getProjects().size(); ++j) {
                Project p = (Project)((Group)this.groups.get(j)).getProjects().get(j);
                if (p.isActive()) {
                    for(int k = 0; k < p.getIterations().size(); ++k) {
                        for(int n = 0; n < ((Iteration)p.getIterations().get(k)).getActivities().size(); ++n) {
                            Activity a = (Activity)((Iteration)p.getIterations().get(k)).getActivities().get(n);
                            if (!a.isActive()) {
                                ++counter;
                            }
                        }
                    }
                }
            }
        }

        return counter;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Summary> getSummaries() {
        return this.summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}