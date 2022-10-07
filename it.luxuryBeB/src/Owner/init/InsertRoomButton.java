package Owner.init;

import Owner.Interface.Template.Button;
import Owner.OwnerConcreteHandler;

import javax.swing.*;

/** Classe per la creazione del bottone inerente all'inserimento delle camere
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Button
 */

public class InsertRoomButton implements Button {
    /** Attributo per il bottone di inserimento delle camere
     */
    private JButton room = null;

    /** Attributo per l'etichetta dell'area di inserimento delle camere
     */
    private JLabel area = null;

    /** Metodo per istanziare e settare le dimensioni/posizioni del bottone e dell'etichetta
     @return nulla poichè void
     */
    @Override
    public void createButton() {
        room = new JButton("Aggiungi camere");
        area = new JLabel("AREA PROPRIETARIO");

        room.setBounds(50, 200, 200, 30);
        area.setBounds(92, 160, 200, 30);

        room.setActionCommand("Owner-Button-Insert");
        room.addActionListener(OwnerConcreteHandler.getInstance());
    }

    /** Metodo per inserimento del bottone e dell'etichetta all'interno del frame
     * @param finestra (visualizzata)
     */
    @Override
    public void insertButton(JFrame finestra) {
            finestra.add(room);
            finestra.add(area);
    }
}
