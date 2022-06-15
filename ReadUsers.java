import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadUsers {
    File file = new File("C:\\Users\\jesus\\IdeaProjects\\IUChat\\src\\UserInfo.csv");
    ReadUsers(){
    }

    String[] ReadUsersA()  {
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

        String[]names = new String[i];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int z = 0;
            while ((line = br.readLine()) != null) {
                String [] userName=line.split(",");
                names[z]=(userName[0]);
                z++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return names;
    }
}

