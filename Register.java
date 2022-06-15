import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class Register implements ActionListener {

    JFrame RegisterFrame;
    JLabel Title = new JLabel("Register");
    JLabel UserN = new JLabel("User Name: ");
    JTextField UN = new JTextField();
    JPasswordField P = new JPasswordField();
    JLabel Password = new JLabel("Password:");
    JButton register = new JButton("Register");
    JButton back = new JButton("Back");
    ImageIcon img = new ImageIcon("C:\\Users\\jesus\\IdeaProjects\\IUChat\\src\\iu-logo.gif");
    Color rediu = new Color(169, 50, 38);
    File file = new File("C:\\Users\\jesus\\IdeaProjects\\IUChat\\src\\UserInfo.csv");
    ArrayList<String> names = new ArrayList<>();

    Register() {
        createWindow();
        setLocation();
        addComponents();
        addActionEvent();
        readFile();
    }

    public void createWindow(){
        RegisterFrame = new JFrame();
        RegisterFrame.setTitle("IU Chat");
        RegisterFrame.setBounds(600,250, 300,300);
        RegisterFrame.getContentPane().setBackground(new Color(249, 235, 234));
        RegisterFrame.getContentPane().setLayout(null);
        RegisterFrame.setVisible(true);
        RegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RegisterFrame.setResizable(false);
        RegisterFrame.setIconImage(img.getImage());

    }
    public void setLocation(){
        Title.setBounds(80,20,200,50);
        Title.setForeground(rediu);
        Title.setFont(new Font("Verdana",Font.BOLD,34));
        UserN.setBounds(40,80,100,50);
        UN.setBounds(110,100,150,20);
        Password.setBounds(40,125,100,50);
        P.setBounds(110,140,150,20);
        register.setBounds(50,200,100,40);
        register.setForeground(rediu);
        register.setBorder(new LineBorder(rediu,4,true));
        back.setBounds(160,200,100,40);
        back.setForeground(rediu);
        back.setBorder(new LineBorder(rediu,4,true));
    }
    public void addComponents(){
        RegisterFrame.add(Title);
        RegisterFrame.add(register);
        RegisterFrame.add(back);
        RegisterFrame.add(UserN);
        RegisterFrame.add(Password);
        RegisterFrame.add(UN);
        RegisterFrame.add (P);
    }
    public void writeToFile(String username, String password) {
        String un = username.toLowerCase();
        if (un.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(RegisterFrame, "Please fill in all the required fields.");
        }
        else if (names.contains(un)) {
            JOptionPane.showMessageDialog(RegisterFrame, "User Name already exist");
        }
        else {
            try {
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(username + "," + password);
                pw.flush();
                pw.close();
                JOptionPane.showMessageDialog(RegisterFrame, "Success");
                readFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void readFile()  {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String [] userName=line.split(",");
                names.add(userName[0]);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
        public void addActionEvent(){
        back.addActionListener(this);
        register.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            new LoginRegistration();
            RegisterFrame.dispose();
        }
        if(e.getSource()==register){
                writeToFile(UN.getText(), String.valueOf(P.getPassword()));
                UN.setText("");
                P.setText("");
            }

        }
    }



