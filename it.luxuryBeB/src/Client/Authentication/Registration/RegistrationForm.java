package Client.Authentication.Registration;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.ClientProxy;
import Client.ClientVisitor;
import Client.Interface.Template.Form;

import javax.swing.*;

/** Classe per la creazione del form inerente alla registrazione del Client
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Form
 */
public class RegistrationForm implements Form {
    /** Attributo statico per il form di inserimento dell'email
     */
    private static JTextField email=null;

    /** Attributo statico per il form di inserimento della password
     */
    private static JPasswordField password=null;

    /** Attributo per il bottone di registrazione
     */
    private JButton conferma=null;

    /** Attributo statico per il form di inserimento del nome
     */
    private static JTextField nome=null;

    /** Attributo statico per il form di inserimento del cognome
     */
    private static JTextField cognome=null;

    /** Attributo statico per il form di inserimento del codice fiscale
     */
    private static JTextField codicefiscale=null;

    /** Attributi per le etichette poste sopra i form di inserimento
     */
    private JLabel em, ps, nom, cgn, cf, rg= null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del form
     */
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

        conferma.setActionCommand("Authentication-Form-Registration");
        conferma.addActionListener(AuthenticationConcreteHandler.getInstance());
    }

    /** Metodo per la comunicazione dei dati immessi al database
     */
    public static void comunicate(){
        String ml = "email,"+email.getText();
        String user = ml+",password,"+new String(password.getPassword());
        String information = "nome,"+nome.getText()+",cognome,"+cognome.getText()+",codicefiscale,"+codicefiscale.getText()+","+ml;
        ClientProxy server = ClientProxy.getInstance();

        server.write("AUTHENTICATION,REGISTRATION,user,"+user);
        String risultato = server.read();
        System.out.println(risultato);
        if(risultato.equals("True")){
            server.write("AUTHENTICATION,REGISTRATION,user_informations,"+information);
            String secondo = server.read();
            System.out.println(secondo);
            if(secondo.equals("True")){
                ClientVisitor.getInstance().VisitAuthentication("login");
                JOptionPane.showMessageDialog(new JFrame(), "Registrazione effettuata con successo.","Operazione effettuata", JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(new JFrame(), "Error, registrazione fallita.","ATTENZIONE",JOptionPane.WARNING_MESSAGE);
            ClientVisitor.getInstance().VisitAuthentication("login");
        }
    }

    /** Metodo per inserimento del form all'interno del frame
     * @param finestra (visualizzata)
     */
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
