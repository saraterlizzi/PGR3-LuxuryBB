package Owner.init;

import Owner.Interface.Template.Button;
import Owner.OwnerConcreteHandler;

import javax.swing.*;

/** Classe per la creazione del bottone inerente alla modifica dello stato delle camere
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Button
 */

public class ModifyStateButton implements Button {
    /** Attributo per il bottone di modifica dello stato delle camere
     */
    private JButton Modify = null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del bottone
     */
    @Override
    public void createButton() {
        Modify = new JButton("Modifica stato");
        Modify.setBounds(50, 280, 200, 30);

        Modify.setActionCommand("Owner-Button-Modify");
        Modify.addActionListener(OwnerConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del bottone all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertButton(JFrame finestra) {
    finestra.add(Modify);
    }
}
