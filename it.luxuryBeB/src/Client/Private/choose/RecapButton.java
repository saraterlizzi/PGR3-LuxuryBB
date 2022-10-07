package Client.Private.choose;

import Client.Interface.Template.Button;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;

/** Classe per la creazione del bottone inerente al riepilogo di tutte le prenotazioni effettuate dal Client
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Button
 */
public class RecapButton implements Button {
    /**Attributo per il bottone di riepilogo
     */
    private JButton recap = null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del bottone
     @return nulla poichè void
     */
    @Override
    public void createButton() {
        recap = new JButton("Riepilogo");
        recap.setBounds(50, 280, 200, 30);

        recap.setActionCommand("Private-Button-View");
        recap.addActionListener(PrivateConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del bottone all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertButton(JFrame finestra) {
       finestra.add(recap);
    }
}
