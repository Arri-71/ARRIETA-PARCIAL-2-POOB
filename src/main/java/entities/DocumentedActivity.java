package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DocumentedActivity extends Activity {

    private NormalActivity activity;
    private List<Question> questions;

    public DocumentedActivity(String name, String state, Iteration iteration, NormalActivity activity) {
        super(name, state, iteration);
        this.activity = activity;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    @Override
    public Duration getDuration() throws SabanaResearchException {
        Duration duration= Duration.ofDays(0);
        if(this.activity!=null){
            duration=this.activity.getDuration();
        }
        else if(this.questions.size()!=0){
            for (int i = 0; i <this.questions.size() ; i++) {
                Question q=this.questions.get(i);
                duration= q.getDedication();
            }
        }
        else {
            if (this.activity==null){
                throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY_WITHOUT_NORMAL_QUESTION);
            }
            if (this.questions.size()==0){
                throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_DOCUMENTED_ACTIVITY);
            }
        }
        return duration;
    }
    @Override
    public boolean isActive() {
        return super.isActive();
    }



}