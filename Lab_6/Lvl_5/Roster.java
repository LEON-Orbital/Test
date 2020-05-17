import java.util.Optional;

public class Roster extends KeyableMap<String,String,Student> {

    public Roster(String rosterName) {
        super(rosterName);
    }

    @Override
    public Roster put(Student dude) {
        this.map.put(dude.getKey(), dude);
        return (Roster) this;
    }

    /**
     * Method to get the grade of a particular assessment
     * of a particular module 
     * of a particular student.
     */
    public String getGrade(String dudeName, String modCode, String assName) 
            throws NoSuchRecordException {
            
            return this.get(dudeName).flatMap(d -> d.get(modCode))
                                     .flatMap(m -> m.get(assName))
                                     .map(a -> a.getGrade())
                                     .orElseThrow(() -> new NoSuchRecordException(
                                                 "No such record: " +
                                                 dudeName + " " +
                                                 modCode + " " +
                                                 assName));
        
    }  
}


