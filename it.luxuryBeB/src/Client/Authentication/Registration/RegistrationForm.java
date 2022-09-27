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

    private JLabel em, ps, nom, cgn, cf, rg= null;


    @Override
    public void createForm() {
        email = new JTextField();
        password = new JPasswordField();
        conferma = new JButton("Conferma");
        nome = new JTextField();
        cognome = new JTextField();
        codicefiscale = new JTextField();
        em = new JLabel("E-mail:");
        ps = new JLabel("Password:");
        nom = new JLabel("Nome");
        cgn = new JLabel("Cognome");
        cf = new JLabel("Codice Fiscale");
        rg = new JLabel("Area Registrazione");

        email.setBounds(50, 100, 200, 30);
        password.setBounds(50, 160, 200, 30);
        nome.setBounds(50,220,200,30);
        cognome.setBounds(50, 280,200,30);
        codicefiscale.setBounds(50,340,200,30);
        conferma.setBounds(50, 380, 200, 30);
        em.setBounds(50, 70, 240, 30);
        ps.setBounds(50, 130, 240, 30);
        nom.setBounds(50,190,240,30);
        cgn.setBounds(50,250,240,30);
        cf.setBounds(50,310,240,30);
        rg.setBounds(50, 40, 240, 30);
    }

    @Override
    public void insertForm(JFrame finestra) {
        finestra.add(email);
        finestra.add(password);
        finestra.add(conferma);
        finestra.add(nome);
        finestra.add(cognome);
        finestra.add(codicefiscale);
        finestra.add(em);
        finestra.add(ps);
        finestra.add(nom);
        finestra.add(cgn);
        finestra.add(cf);
        finestra.add(rg);
    }
}
