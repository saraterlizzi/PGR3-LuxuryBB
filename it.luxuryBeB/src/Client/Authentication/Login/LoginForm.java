package Client.Authentication.Login;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.ClientProxy;
import Client.Interface.Template.Form;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;
import java.awt.*;

public class LoginForm implements Form {
    private static JTextField email=null;
    private static JPasswordField password=null;
    private JButton login=null;
    private JLabel em, ps, lg= null;
    private JLayeredPane layer = null;
    private JLabel rettangolo;



    @Override
    public void createForm() {
        email = new JTextField();
        password = new JPasswordField();
        login = new JButton("Login");
        em = new JLabel("E-mail:");
        ps = new JLabel("Password:");
        lg = new JLabel("Area Login");
        layer = new JLayeredPane();
        rettangolo = new JLabel();
        layer.setPreferredSize(new Dimension(200,200));
        layer.setBounds(0,0,300,300);

        email.setBounds(50, 100, 200, 30);
        password.setBounds(50, 160, 200, 30);
        login.setBounds(50, 200, 200, 30);
        em.setBounds(50, 70, 240, 30);
        ps.setBounds(50, 130, 240, 30);
        lg.setBounds(50, 40, 230, 30);
        rettangolo.setBackground(Color.CYAN);
        rettangolo.setBounds(0,0,500,500);

        login.setActionCommand("Authentication-Form-Login");
        login.addActionListener(AuthenticationConcreteHandler.getInstance());

        layer.add(rettangolo, Integer.valueOf(1));
        layer.add(email,Integer.valueOf(2));
        layer.add(password,Integer.valueOf(2));
        layer.add(login, Integer.valueOf(2));
        layer.add(em, Integer.valueOf(2));
        layer.add(ps,Integer.valueOf(2));
        layer.add(lg,Integer.valueOf(2));
    }

    public static void comunicate(){
        String mail = email.getText();
        String passw = new String(password.getPassword());
        if (mail.equals("")){
            mail="null";
        }
        if(passw.equals("")){
            passw="null";
        }
        StringBuilder serverrequest = new StringBuilder("AUTHENTICATION,LOGIN,user,email,"+mail+",password,"+passw);
        ClientProxy server = ClientProxy.getInstance();
        server.write(serverrequest.toString());
    }



    @Override
    public void insertForm(JFrame finestra) {
       finestra.add(layer);
       finestra.setSize(new Dimension(350,400));
    }
}

