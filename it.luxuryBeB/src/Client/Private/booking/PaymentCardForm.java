package Client.Private.booking;

import Client.Authentication.AuthenticationConcreteHandler;
import Client.ClientProxy;
import Client.ClientVisitor;
import Client.Interface.Template.Form;
import Client.Private.PrivateConcreteHandler;
import Client.Private.RoomMemento;

import javax.swing.*;

/** Classe per la creazione del form inerente alla prenotazione
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Form
 */
public class PaymentCardForm implements Form {
    /** Attributo statico per il form di inserimento dell'intestatario
     */
    private static JTextField intestatario = null;

    /** Attributo statico per il form di inserimento del numero della carta
     */
    private static JTextField numerocarta = null;

    /** Attributo statico per il form di inserimento della scadenza della carta
     */
    private static JTextField scadenza = null;

    /** Attributo statico per il form di inserimento del codice a tre cifre della carta
     */
    private static JTextField codicesegreto = null;

    /** Attributo per il bottone di pagamento
     */
    private JButton pagamento = null;

    /** Attributi per le etichette poste sopra i form di inserimento
     */
    private JLabel inte, num, scad, cvv, pag = null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del form
     @return nulla poichè void
     */
    @Override
    public void createForm() {
        intestatario = new JTextField();
        numerocarta = new JTextField();
        scadenza = new JTextField();
        codicesegreto = new JTextField();
        pagamento = new JButton("Paga");
        inte = new JLabel("Intestatario carta:");
        num = new JLabel("Numero carta:");
        scad = new JLabel("Scadenza carta:");
        cvv = new JLabel("CVV:");
        pag = new JLabel("Area Pagamenti");

        intestatario.setBounds(50, 100, 200, 30);
        numerocarta.setBounds(50, 160, 200, 30);
        scadenza.setBounds(50, 220, 90, 30);
        codicesegreto.setBounds(160, 220, 90,30);
        pagamento.setBounds(50, 260, 200, 30);
        inte.setBounds(50, 70, 240, 30);
        num.setBounds(50, 130, 240, 30);
        scad.setBounds(50,190,240,30);
        cvv.setBounds(160,190,240,30);
        pag.setBounds(50,40, 230, 30 );

        pagamento.setActionCommand("Private-Form-Payment");
        pagamento.addActionListener(PrivateConcreteHandler.getInstance());
    }

    /** Metodo per la comunicazione dei dati immessi al database
     @return nulla poichè void
     */
    public static void comunicate(){
        ClientProxy.getInstance().write("BOOKING,PAYMENT,"+ RoomMemento.getInstance().restoreState());
        String result = ClientProxy.getInstance().read();
        if(result.equals("True")){
            JOptionPane.showMessageDialog(new JFrame(), "Prenotazione effettuata con successo.","Operazione effettuata", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Error, prenotazione fallita.","ATTENZIONE",JOptionPane.WARNING_MESSAGE);

        }
        ClientVisitor.getInstance().VisitPrivate("init");
    }


    /** Metodo per inserimento del form all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertForm(JFrame finestra) {
        finestra.add(intestatario);
        finestra.add(numerocarta);
        finestra.add(scadenza);
        finestra.add(codicesegreto);
        finestra.add(pagamento);
        finestra.add(inte);
        finestra.add(num);
        finestra.add(scad);
        finestra.add(cvv);
        finestra.add(pag);
    }
}
