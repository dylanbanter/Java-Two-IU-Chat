import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User implements ActionListener {
    JFrame UserFrame;
    JButton Messages = new JButton("Messages");
    JButton SendMessage = new JButton("Send Message");
    JButton Send = new JButton("Send");
    JButton Back = new JButton("Back");
    JLabel Select = new JLabel("Send message to:");
    JTextArea UserMessage = new JTextArea();
    JTextArea Message = new JTextArea();
    JComboBox <String> Users = new JComboBox<>(new ReadUsers().ReadUsersA());
    ImageIcon img = new ImageIcon("C:\\Users\\jesus\\IdeaProjects\\IUChat\\src\\iu-logo.gif");
    Color rediu = new Color(169, 50, 38);
    String user;

    public User(String user){
        createWindow(user);
        setLocation();
        addComponents();
        addActionEvent();
    }

    public void createWindow(String user){
        this.user = user;
        UserFrame = new JFrame();
        Message.setBounds(30,90,150,75);
        UserMessage.setBounds(10,5,285,200);
        UserMessage.setFont(new Font("Verdana",Font.BOLD,10));
        UserMessage.setVisible(false);
        Users.setBounds(190,60,90,25);
        Users.setVisible(false);
        JLabel Title = new JLabel("Welcome "+user);
        Select.setBounds(30,45,300,50);
        Select.setFont(new Font("Verdana",Font.BOLD,15));
        Select.setForeground(rediu);
        Select.setVisible(false);
        Title.setBounds(45,5,300,50);
        Title.setForeground(rediu);
        Title.setFont(new Font("Verdana",Font.BOLD,25));
        UserFrame.add(Message);
        Message.setVisible(false);
        UserFrame.add(UserMessage);
        UserFrame.add(Users);
        UserFrame.add(Select);
        UserFrame.add(Title);
        UserFrame.setTitle("IU Chat");
        UserFrame.setBounds(600,250, 300,300);
        UserFrame.getContentPane().setBackground(new Color(249, 235, 234));
        UserFrame.getContentPane().setLayout(null);
        UserFrame.setVisible(true);
        UserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserFrame.setResizable(false);
        UserFrame.setIconImage(img.getImage());

    }
    public void setLocation(){

        Messages.setBounds(100,100,100,40);
        Messages.setForeground(rediu);
        Messages.setBorder(new LineBorder(rediu,4,true));
        SendMessage.setBounds(100,150,100,40);
        SendMessage.setForeground(rediu);
        SendMessage.setBorder(new LineBorder(rediu,4,true));
        Send.setBounds(150,180,100,40);
        Send.setForeground(rediu);
        Send.setBorder(new LineBorder(rediu,4,true));
        Back.setBounds(45,180,100,40);
        Back.setForeground(rediu);
        Back.setBorder(new LineBorder(rediu,4,true));
    }
    public void addComponents(){
        UserFrame.add(Messages);
        UserFrame.add(SendMessage);
        UserFrame.add(Send);
        Send.setVisible(false);
        UserFrame.add(Back);
        Back.setVisible(false);
    }
    public void addActionEvent(){
        SendMessage.addActionListener(this);
        Messages.addActionListener(this);
        Send.addActionListener(this);
        Back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== SendMessage){
           SendMessage.setVisible(false);
           Messages.setVisible(false);
           Select.setVisible(true);
           Users.setVisible(true);
           Send.setVisible(true);
           Back.setVisible(true);
           Message.setVisible(true);
        }
        if(e.getSource()== Messages){
            String[][] RM = new ReadMessages().ReadMess();
            int x = 0;
            for (String[] strings : RM) {
                if (strings[1].equals(user)) {
                    x++;
                }
            }
            String[][] UserMessages = new String[x][4];
            int z =0;
            for (String[] strings : RM) {
                if (strings[1].equals(user)) {
                    UserMessages[z][0] = strings[0];
                    UserMessages[z][2] = strings[2];
                    UserMessages[z][3] = strings[3];
                    z++;
                }
            }
            StringBuilder txt = new StringBuilder();
            for (String[] userMessage : UserMessages) {
                txt.append("Message from: ").append(userMessage[0]).append("\n").append("Message: ").append(userMessage[2]).append("\n").append("Date: ").append(userMessage[3]).append("\n").append("----------------------").append("\n");
            }
            UserMessage.setText(txt.toString());
            UserMessage.setVisible(true);
            SendMessage.setVisible(false);
            Messages.setVisible(false);
            Back.setVisible(true);
            Back.setBounds(100,215,100,40);
        }
        if(e.getSource()==Send){
            new sendMessage(user,String.valueOf(Users.getSelectedItem()),Message.getText());
           JOptionPane.showMessageDialog(null,"Message send successfully.");
           Message.setText("");
        }
        if(e.getSource()==Back){
            SendMessage.setVisible(true);
            Messages.setVisible(true);
            Select.setVisible(false);
            Users.setVisible(false);
            Send.setVisible(false);
            Back.setVisible(false);
            Message.setVisible(false);
            UserMessage.setVisible(false);
            Back.setBounds(45,180,100,40);
        }
    }
}

