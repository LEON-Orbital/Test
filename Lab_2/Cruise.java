/*
    Attribute names should be in lowerCamelCase and be clear to the reader. 
    For example, loadersRequured and serviceTime. 

    Python way for naming attributes is different from that in Java, do take note!
*/
class Cruise{
    
    private final String id;
    private final int time;
    private final int loaders_req;
    private final int service_time;
    private final int arrivalHour;
    private final int arrivalMin;

    Cruise(String id, int time, int loaders_req, int service_time){
        this.id = id;
        this.time = time;
        this.arrivalHour = time/100;
        this.arrivalMin = time % 100;
        this.loaders_req = loaders_req;
        this.service_time = service_time;
    }

    int getArrivalTime(){
        return (arrivalHour * 60) + (arrivalMin);
    }
    int getNumOfLoadersRequired(){
        return loaders_req; 
    }
    int getServiceCompletionTime(){
        return this.getArrivalTime() + this.service_time;
    }

    @Override
    public String toString(){
        return this.id + "@" + String.format("%04d", this.time);
    }
}















