import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadMessages {
    File file = new File("Messages.txt");
    ReadMessages(){
    }
    String[][] ReadMess()  {
        String line;
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((br.readLine()) != null) {
                i++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String[][] Messages = new String[i][4];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int z = 0;
            while ((line = br.readLine()) != null) {
                String [] components=line.split("\\|");
                Messages[z][0]=(components[0]);
                Messages[z][1]=(components[1]);
                Messages[z][2]=(components[2]);
                Messages[z][3]=(components[3]);
                z++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Messages;
    }

}
