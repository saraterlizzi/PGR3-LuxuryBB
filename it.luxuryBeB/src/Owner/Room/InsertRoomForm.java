package Owner.Room;

import Owner.Interface.Template.Form;
import Owner.OwnerConcreteHandler;
import Owner.OwnerProxy;
import Owner.OwnerVisitor;

import javax.swing.*;

/** Classe per la creazione del form inerente all'inserimento delle camere
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Form
 */

public class InsertRoomForm implements Form {
    /** Attributo statico per il form di inserimento del numero della camera
     */
    private static JTextField numero = null;

    /** Attributo statico per il form di inserimento della tipologia della camera
     */
    private static JTextField tipologia = null;

    /** Attributo statico per il form di inserimento del prezzo della camera
     */
    private static JTextField prezzo = null;

    /** Attributo statico per il form di inserimento dei posti della camera
     */
    private static JTextField posti = null;

    /** Attributo per il bottone di inserimento
     */
    private JButton inserimento = null;

    /** Attributi per le etichette poste sopra i form di inserimento
     */
    private JLabel num, tip, prz, pst, ins = null;

    /** Metodo per la comunicazione dei dati immessi al database
     @return nulla poichè void
     */
    public static void comunicate() {
        String richiesta = "OWNER,INSERTROOM,Room,tipologia,"+tipologia.getText()+",posti,"+posti.getText()+",numero,"+numero.getText()+",prezzo,"+prezzo.getText()+",stato,1";
        OwnerProxy server = OwnerProxy.getInstance();
        server.write(richiesta);
        if(server.read().equals("True")){
            OwnerVisitor.getInstance().VisitInit();
            JOptionPane.showMessageDialog(new JFrame(), "Inserimento camera effettuata con successo.","Operazione effettuata", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Error, inserimento fallito.","ATTENZIONE",JOptionPane.WARNING_MESSAGE);
            OwnerVisitor.getInstance().VisitInit();
        }
    }

    /** Metodo per istanziare e settare le dimensioni/posizioni del form
     @return nulla poichè void
     */
    @Override
    public void createForm() {
        numero = new JTextField();
        tipologia = new JTextField();
        prezzo = new JTextField();
        posti =new JTextField();
        inserimento = new JButton("Conferma");
        num = new JLabel("Numero camera:");
        tip = new JLabel("Tipologia:");
        prz = new JLabel("Prezzo:");
        pst =new JLabel("Posti letto:");
        ins = new JLabel("Inserimento nuova camera:");

       numero.setBounds(50, 100, 200, 30);
       tipologia.setBounds(50, 160, 200, 30);
       prezzo.setBounds(50, 220, 200, 30);
       posti.setBounds(50, 280, 200, 30);
       inserimento.setBounds(50, 320, 200, 30);
       num.setBounds(50, 70, 240, 30);
       tip.setBounds(50, 130, 240, 30);
       prz.setBounds(50, 190, 240, 30);
       pst.setBounds(50, 250, 240, 30);
       ins.setBounds(50, 50, 200, 30);
       
       inserimento.setActionCommand("Owner-Form-Insert");
       inserimento.addActionListener(OwnerConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del form all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertForm(JFrame finestra) {
        finestra.add(numero);
        finestra.add(tipologia);
        finestra.add(prezzo);
        finestra.add(posti);
        finestra.add(inserimento);
        finestra.add(num);
        finestra.add(tip);
        finestra.add(prz);
        finestra.add(pst);
        finestra.add(ins);
    }
}
