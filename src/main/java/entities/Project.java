package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations;
    private ArrayList<Student> members;
    private Student leader;

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();
        this.members= members;
        this.leader= leader;

        group.addProject(this);
    }

    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }

    public Duration getDuration() throws SabanaResearchException {
        Duration duration= Duration.ofDays(0);
        if(this.iterations.size()!=0) {
            for (int i = 0; i < this.iterations.size(); i++) {
                Iteration it = this.iterations.get(i);
                duration = it.getDuration();
            }
        }
        else {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);
        }
        return duration ;
    }
    public boolean isActive() {
        boolean isActive;

        if(LocalDate.now().isAfter(this.dateEnd)){
            isActive = false;
        }
        else{
            int openActivities = this.countOpenActivities();
            isActive = openActivities > 0;
        }

        return isActive;
    }

    public int countOpenActivities(){
        return this.iterations
                .stream()
                .map(Iteration::countOpenActivities)
                .reduce(0, Integer::sum);
    }


    public List <String> summarize(ISynthesizer s) throws SabanaResearchException {
        return s.synthezise();
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<Iteration> getIterations() {
        return iterations;
    }
}
