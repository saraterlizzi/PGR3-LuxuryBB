package Client.Authentication.Registration;

import Client.Interface.Template.Form;

import javax.swing.*;

public class RegistrationForm implements Form {
    private static JTextField email=null;
    private static JPasswordField password=null;
    private JButton conferma=null;
    private static JTextField nome=null;
    private static JTextField cognome=null;
    private static JTextField codicefiscale=null;

    private JLabel em, ps, cnf, nom, cgn, cf= null;


    @Override
    public void createForm() {

    }

    @Override
    public void insertForm(JFrame finestra) {

    }
}
