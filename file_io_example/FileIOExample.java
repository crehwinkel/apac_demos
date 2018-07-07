import java.util.*; //includes Scanner and ArrayList
import java.io.File;

public class FileIOExample{
    public static void main (String []args){
        ArrayList<String> invitees = new ArrayList<String>();
        try{
            File input_file = new File("dinner guests.txt");
            Scanner scan = new Scanner (input_file);
            while (scan.hasNextLine()){
                invitees.add(scan.nextLine());
            }
            scan.close();
        }
        catch(Exception e){
            System.out.println("Check your file name and try again.");
        }
        System.out.println(invitees);
    }
}  


  