import java.util.Scanner;

class Main6{

    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        Cruise[] ships = new Cruise[n];

        for(int i = 1; i <= n; i++){    // for loop to get user input to create arrayof cruises
            String id = s.next();
            
            if( id.charAt(0) ==  'S'){
                ships[i-1] = new SmallCruise(id, s.nextInt());
            }
            else{      //  (id.charAt(0) == "B")
                ships[i-1] = new BigCruise(id, s.nextInt(), s.nextInt(), s.nextInt());    
            }
        }
    
        int total_num_loader = 0;
        for(Cruise cruise : ships){    // find maximum number of loaders required
            total_num_loader += cruise.getNumOfLoadersRequired();
        }

        Loader[] loader_list = new Loader[total_num_loader];

        for(int j = 0; j < total_num_loader; j++){   // create array with all the loaders
            if ((j+1) % 3 == 0){
                loader_list[j] = new RecycledLoader(j+1);
            }
            else{
                loader_list[j] = new Loader(j+1);
            }
        }

        for (Cruise cruise : ships){
            
            int load_counter = 0;
            
            for (int k = 0; k < total_num_loader; k++){
                if (loader_list[k].serve(cruise) == null){
                    continue;
                }
                else if(load_counter == cruise.getNumOfLoadersRequired()){
                    break;
                }
                else{
                    loader_list[k] = loader_list[k].serve(cruise);
                    System.out.println(loader_list[k].toString());
                    load_counter += 1;
                }
            }
        }
    }
}


