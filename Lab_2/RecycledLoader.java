/*
    Commented out code should be deleted. 
*/
class RecycledLoader extends Loader{
    //final int ID;
    //final Cruise cruiseServing;

    RecycledLoader(int ID){
        super(ID);    
     //   this.ID = ID;
     //   this.cruiseServing = null;
    }

    RecycledLoader(int ID, Cruise cruise){
        super(ID, cruise);    
     //   this.ID = ID;
     //   this.cruiseServing = cruise;
    }
    
    boolean canServe(Cruise cruise){
        if (cruiseServing == null){
            return true;
        }
        else if(cruiseServing.getServiceCompletionTime() + 60 <= cruise.getArrivalTime()){
            return true;
        }
        else{
            return false;
        }

    }

    RecycledLoader serve(Cruise cruise){
        if (this.canServe(cruise) == true){
            return new RecycledLoader(this.ID, cruise);
        }
        else{
            return null;
        }
    }

    
    @Override
    public String toString(){
        if(this.cruiseServing == null){
            return "Loader " + this.ID + "(recycled) ";
        }   
        else {
            return "Loader " + this.ID + " (recycled) serving " + this.cruiseServing.toString();
        }
    }
}


