import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class sendMessage {
    String sender;
    String receiver;
    String Message;
    Date date = java.util.Calendar.getInstance().getTime();

    sendMessage(String sender, String receiver, String Message) {
        this.sender = sender;
        this.receiver = receiver;
        this.Message = Message;

        try {
            FileWriter mw = new FileWriter("Messages.txt", true);
            BufferedWriter out = new BufferedWriter(mw);
            out.write(sender + "|" + receiver + "|" + Message + "|" + date);
            out.newLine();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
