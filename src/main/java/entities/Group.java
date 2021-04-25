package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private int id;
    private LocalDate createdAt;
    private String area;
    private List<Project> projects;
    private ArrayList<Student> members;
    private Student leader;
    private ArrayList<Course> requirements;

    public Group(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    public void addProject(Project plan) {
        this.projects.add(plan);
    }

    public void addMember(Student member) {
        this.members.add(member);
    }

    public void addRequirement(Course requirement) {
        this.requirements.add(requirement);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ArrayList<Student> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Student> members) {
        this.members = members;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public ArrayList<Course> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<Course> requirements) {
        this.requirements = requirements;
    }

        public int countActiveProjects() {
            return(int) this.projects.stream().map(Project::isActive).filter(b -> b).count();
        }

}

