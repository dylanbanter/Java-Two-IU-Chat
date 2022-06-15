import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegistration implements ActionListener {

    JFrame MainFrame;
    JLabel Title = new JLabel("IU Chat");
    JButton register = new JButton("Register");
    JButton logIn = new JButton("LogIn");
    ImageIcon img = new ImageIcon("C:\\Users\\jesus\\IdeaProjects\\IUChat\\src\\iu-logo.gif");
    Color rediu = new Color(169, 50, 38);

    public LoginRegistration(){
        createWindow();
        setLocation();
        addComponents();
        addActionEvent();
    }

    public void createWindow(){

        MainFrame = new JFrame();
        MainFrame.setTitle("IU Chat");
        MainFrame.setBounds(600,250, 300,300);
        MainFrame.getContentPane().setBackground(new Color(249, 235, 234));
        MainFrame.getContentPane().setLayout(null);
        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setResizable(false);
        MainFrame.setIconImage(img.getImage());

    }
    public void setLocation(){
        Title.setBounds(80,20,150,50);
        Title.setForeground(rediu);
        Title.setFont(new Font("Verdana",Font.BOLD,34));
        register.setBounds(100,100,100,40);
        register.setForeground(rediu);
        register.setBorder(new LineBorder(rediu,4,true));
        logIn.setBounds(100,150,100,40);
        logIn.setForeground(rediu);
        logIn.setBorder(new LineBorder(rediu,4,true));
    }
    public void addComponents(){
        MainFrame.add(Title);
        MainFrame.add(register);
        MainFrame.add(logIn);
    }
    public void addActionEvent(){
        logIn.addActionListener(this);
        register.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==logIn){
            new LogIn();
            MainFrame.dispose();
        }
        if(e.getSource()==register){
            new Register();
            MainFrame.dispose();
        }
    }
}
