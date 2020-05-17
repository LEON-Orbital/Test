import java.util.Scanner;
import java.util.ArrayList;

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

            /** Student does not exist in roster*/
            if (roster.get(studentName) == null) {
                
                Student student = new Student(studentName);
                student.put(new Module(modCode).put(new Assessment(assName, grade)));
                roster.put(student);

            /** Mod does not exist in student*/
            } else if (roster.get(studentName).get(modCode) == null) {
                
                roster.get(studentName)
                    .put(new Module(modCode)
                        .put(new Assessment(assName, grade)));
            
            /** Assessment does not exist in mod*/
            } else {

                roster.get(studentName).get(modCode).put(new Assessment(assName, grade));
            }
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
                System.out.println(roster
                                   .get(list.get(index))
                                   .get(list.get(index + 1))
                                   .get(list.get(index + 2))
                                   .getGrade());
                
            } catch (NullPointerException ex) {
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



