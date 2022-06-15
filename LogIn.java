import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class LogIn implements ActionListener {

    JFrame LogInFrame;
    JLabel Title = new JLabel("LogIn");
    JLabel UserN = new JLabel("User Name: ");
    JTextField UN = new JTextField();
    JPasswordField P = new JPasswordField();
    JLabel Password = new JLabel("Password:");
    JButton logIn = new JButton("LogIn");
    JButton back = new JButton("Back");
    ImageIcon img = new ImageIcon("C:\\Users\\jesus\\IdeaProjects\\IUChat\\src\\iu-logo.gif");
    Color rediu = new Color(169, 50, 38);
    File file = new File("C:\\Users\\jesus\\IdeaProjects\\IUChat\\src\\UserInfo.csv");
    Map<String, String> UP = new HashMap<>();

    LogIn() {
        createWindow();
        setLocation();
        addComponents();
        addActionEvent();
        readFile();
    }

    public void createWindow() {

        LogInFrame = new JFrame();
        LogInFrame.setTitle("IU Chat");
        LogInFrame.setBounds(600, 250, 300, 300);
        LogInFrame.getContentPane().setBackground(new Color(249, 235, 234));
        LogInFrame.getContentPane().setLayout(null);
        LogInFrame.setVisible(true);
        LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LogInFrame.setResizable(false);
        LogInFrame.setIconImage(img.getImage());

    }

    public void setLocation() {
        Title.setBounds(80, 20, 200, 50);
        Title.setForeground(rediu);
        Title.setFont(new Font("Verdana", Font.BOLD, 34));
        UserN.setBounds(40, 80, 100, 50);
        UN.setBounds(110, 100, 150, 20);
        Password.setBounds(40, 125, 100, 50);
        P.setBounds(110, 140, 150, 20);
        logIn.setBounds(50, 200, 100, 40);
        logIn.setForeground(rediu);
        logIn.setBorder(new LineBorder(rediu, 4, true));
        back.setBounds(160, 200, 100, 40);
        back.setForeground(rediu);
        back.setBorder(new LineBorder(rediu, 4, true));
    }

    public void addComponents() {
        LogInFrame.add(Title);
        LogInFrame.add(logIn);
        LogInFrame.add(back);
        LogInFrame.add(UserN);
        LogInFrame.add(Password);
        LogInFrame.add(UN);
        LogInFrame.add(P);
    }

    public void readFile() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] userName = line.split(",");
                UP.put(userName[0], userName[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addActionEvent() {
        back.addActionListener(this);
        logIn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new LoginRegistration();
            LogInFrame.dispose();
        }
        if (e.getSource() == logIn) {
            String username = UN.getText();
            String password = String.valueOf(P.getPassword());
            if (username.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(LogInFrame,
                        "No username or password entered.");
            } else {

                if (UP.get(username) != null &&
                        UP.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(LogInFrame,
                            "Login is successful!");
                    new User(username);
                    LogInFrame.dispose();

                } else {
                    JOptionPane.showMessageDialog(LogInFrame,
                            "Username or password does not match. Please try again.");
                }
            }

        }
    }
}

