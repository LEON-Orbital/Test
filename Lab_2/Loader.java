class Loader{
    protected final int ID;
    protected final Cruise cruiseServing;

    Loader(int ID){
        this.ID = ID;
        this.cruiseServing = null;
    }

    Loader(int ID, Cruise cruise){
        this.ID = ID;
        this.cruiseServing = cruise;
    }
    
    boolean canServe(Cruise cruise){
        if (cruiseServing == null){
            return true;
        }
        else if(cruiseServing.getServiceCompletionTime() <= cruise.getArrivalTime()){
            return true;
        }
        else{
            return false;
        }

    }

    Loader serve(Cruise cruise){
        if (this.canServe(cruise) == true){
            return new Loader(this.ID, cruise);
        }
        else{
            return null;
        }
    }

    
    @Override
    public String toString(){
        if(this.cruiseServing == null){
            return "Loader " + this.ID;
        }   
        else {
            return "Loader " + this.ID + " serving " + this.cruiseServing.toString();
        }
    }
}





