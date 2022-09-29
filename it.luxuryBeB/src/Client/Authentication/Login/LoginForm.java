package Client.Authentication.Login;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Interface.Template.Form;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;

public class LoginForm implements Form {
    private static JTextField email=null;
    private static JPasswordField password=null;
    private JButton login=null;
    private JLabel em, ps, lg= null;

    @Override
    public void createForm() {
        email = new JTextField();
        password = new JPasswordField();
        login = new JButton("Login");
        em = new JLabel("E-mail:");
        ps = new JLabel("Password:");
        lg = new JLabel("Area Login");

        email.setBounds(50, 100, 200, 30);
        password.setBounds(50, 160, 200, 30);
        login.setBounds(50, 200, 200, 30);
        em.setBounds(50, 70, 240, 30);
        ps.setBounds(50, 130, 240, 30);
        lg.setBounds(50, 40, 230, 30);

        login.setActionCommand("Authentication-Form-Login");
        login.addActionListener(PrivateConcreteHandler.getInstance());
    }

    public static void comunicate(){

    }

    @Override
    public void insertForm(JFrame finestra) {
        finestra.add(email);
        finestra.add(password);
        finestra.add(login);
        finestra.add(em);
        finestra.add(ps);
        finestra.add(lg);
    }
}
