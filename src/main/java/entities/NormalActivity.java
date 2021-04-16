package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends Activity {

    private List<Step> steps;

    public NormalActivity(String name, String state, Iteration iteration) {
        super(name, state, iteration);
        this.steps = new ArrayList<Step>();
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }

    @Override
    public Duration getDuration() throws SabanaResearchException{
        Duration duration=Duration.ofDays(0);
        if(this.steps.size()!=0){
            for (int i = 0; i <this.steps.size(); i++) {
                Step s=this.steps.get(i);
                duration=s.getDuration();
            }
        }
        else {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_NORMAL_ACTIVITY);
        }
        return duration;
    }
}