package Client.Authentication.Login;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.Authentication.UserMemento;
import Client.ClientProxy;
import Client.ClientVisitor;
import Client.Interface.Template.Form;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;
import java.awt.*;

/** Classe per la creazione del form inerente al login del Client
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Form
 */
public class LoginForm implements Form {

    /** Attributo statico per il form di inserimento dell'email
     */
    private static JTextField email=null;

    /** Attributo statico per il form di inserimento della password
     */
    private static JPasswordField password=null;

    /** Attributo per il bottone di login
     */
    private JButton login=null;

    /** Attributi per le etichette poste sopra i form di inserimento
     */
    private JLabel em, ps, lg= null;
    private JLayeredPane layer = null;
    private JLabel rettangolo;

    /** Metodo per istanziare e settare le dimensioni/posizioni del form
     */
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

    /** Metodo per la comunicazione dei dati immessi al database
     */
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

        String risultato = server.read();
        if(risultato.equals("True")){
            UserMemento.getInstance().setMemento(mail,passw,null);
            ClientVisitor.getInstance().VisitPrivate("init");
        } else{
            JOptionPane.showMessageDialog(new JFrame(), "error, login fallito","attenzione",JOptionPane.WARNING_MESSAGE);
        }
    }

    /** Metodo per inserimento del form all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertForm(JFrame finestra) {
       finestra.add(layer);
       finestra.setSize(new Dimension(350,400));
    }
}

