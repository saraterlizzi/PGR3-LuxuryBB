package Client.Private.choose;


import Client.Interface.Template.Button;
import Client.Private.PrivateConcreteHandler;

import javax.swing.*;

/** Classe per la creazione del bottone per tornare indietro
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Button
 */
public class ReturnButton implements Button {
    /** Attributo per il bottone per tornare indietro
     */
    private JButton returnb = new JButton("Torna indietro");

    /** Metodo per istanziare e settare le dimensioni/posizioni del bottone di ritorno
     @return nulla poichè void
     */
    @Override
    public void createButton() {
        returnb.setBounds(10, 25, 100, 30);

        returnb.setActionCommand("Private-Button-Back");
        returnb.addActionListener(PrivateConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del bottone di ritorno all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertButton(JFrame finestra) {
        finestra.add(returnb);
    }
}
