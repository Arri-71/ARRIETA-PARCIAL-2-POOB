package entities;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StudentSynthesizer implements ISynthesizer{

    public List <Student> students;
    public ArrayList<String> resume;

    @Override
    public List <String> synthezise() throws SabanaResearchException {

        Duration duration;
        String n;

        for (Student s : students){
            duration=s.getActivitiesDuration();
            n=s.getName();
            resume.add("Estudiante: "+n+ ", Duración: "+ duration);

        }

        return resume;

    }
}
