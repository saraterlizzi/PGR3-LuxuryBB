package Owner.init;

import Owner.Interface.AbstractFactory;
import Owner.Interface.Template.Button;
import Owner.Interface.Template.Form;
import Owner.Interface.Template.Text;
import Owner.Room.InsertRoomForm;

/**
 * Classe che implementa il pattern Abstract Factory per la creazione di famiglie di oggetti all'interno del
   sottopackage Init
 * @author Filomena De Rosa, Sara Terlizzi
 * @see AbstractFactory
 */
public class InitFactory implements AbstractFactory {

    /** Metodo per l'istanziamento del form
     @param type (quale form si vuole istanziare)
     @return form (assegnato in base a quello richiesto)
     */
    @Override
    public Form createForm(String type) {
        return switch (type){
             case "insertroom" -> new InsertRoomForm();
             default -> null;
        };
    }

    /** Metodo per l'istanziamento dei bottoni
     @param type (quale bottone si vuole istanziare)
     @return button (assegnato in base a quello richiesto)
     */
    @Override
    public Button createButton(String type) {
        return switch (type){
            case "viewbookedrooms" -> new BookedButton();
            case "insertroom" -> new InsertRoomButton();
            case "back" -> new ReturnButton();
            case "modify" -> new ModifyStateButton();
            default -> null;
        };
    }

    /** Metodo per l'istanziamento del testo
     @param type (quale tipologia di testo si vuole istanziare)
     @return null
     */
    @Override
    public Text createText(String type) {
        return null;
    }
}
