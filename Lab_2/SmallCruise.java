class SmallCruise extends Cruise {
    private static final int LOADING_TIME = 30;
    private static final int LOADER_REQ = 1;

    SmallCruise(String id, int time) { 
        super(id, time, SmallCruise.LOADER_REQ, SmallCruise.LOADING_TIME);
    }
}



