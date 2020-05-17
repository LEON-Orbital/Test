import java.util.Scanner;
import java.util.ArrayList;
import java.util.Optional;

public class Main {

    /**
     * Main method that takes in records as input and
     * and prints grade for any queries afterwards.
     */
    public static void main(String[] args) {
    
        int numOfRecords;                   
        Roster roster = new Roster("AY1920");
        
        Scanner sc = new Scanner(System.in);
        numOfRecords = sc.nextInt();

        for (int i = 0; i < numOfRecords; i++) {
            String studentName = sc.next(); 
            String modCode = sc.next();
            String assName = sc.next();
            String grade = sc.next(); 
        

        roster.get(studentName).ifPresentOrElse(
                s -> s.get(modCode).ifPresentOrElse(
                    m -> m.put(new Assessment(assName, grade)), 
                        () -> new Module(modCode).put(new Assessment(assName, grade))),
                () -> roster.put(new Student(studentName).put(new Module(modCode).put(new Assessment(assName, grade)))));
        
        }


        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            String studentName = sc.next();
            list.add(studentName);
            
            String modCode = sc.next();
            list.add(modCode);
            
            String assName = sc.next();
            list.add(assName);
        }

        int index = 0;

        for (int i = 1; i <= (list.size() / 3); i++) {
            try {               

                System.out.println(roster.getGrade(list.get(index), list.get(index + 1), list.get(index + 2)));
            } catch (NoSuchRecordException ex) {
                System.out.println("NoSuchRecordException: No such record: " +
                                    list.get(index) + " " +
                                    list.get(index + 1) + " " + 
                                    list.get(index + 2));
            } finally {
                index += 3;
            }
        }  
    }
}












