/*
    1. Access Modifiers Please. (For all classes)
    2. it is necessary to repeat the declaration of ID and time? 
*/
class BigCruise extends Cruise {
    private final int length;
    private final int numOfPassengers;
    private static final int PASSENGER_PER_MIN = 50;
    private static final int LOADER_PER_LENGTH = 40;


    BigCruise(String id, int time, int length, int numOfPassengers) {
        super(id, time,
              (int) Math.ceil(length / (double) BigCruise.LOADER_PER_LENGTH), 
              (int) Math.ceil(numOfPassengers / (double) BigCruise.PASSENGER_PER_MIN));
        this.length = length;
        this.numOfPassengers = numOfPassengers;
    }
}
