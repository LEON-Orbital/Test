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
        try {
            
            return this.map.get(dudeName).get(modCode).get(assName).getGrade();
        
        } catch (NullPointerException ex) {
            
            throw new NoSuchRecordException("No such record: " +
                                             dudeName + " " +
                                             modCode + " " + 
                                             assName);
        }  
    }

}

