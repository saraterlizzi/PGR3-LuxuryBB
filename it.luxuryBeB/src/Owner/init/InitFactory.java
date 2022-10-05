package Owner.init;

import Owner.Interface.AbstractFactory;
import Owner.Interface.Template.Button;
import Owner.Interface.Template.Form;
import Owner.Interface.Template.Text;
import Owner.Room.InsertRoomForm;

public class InitFactory implements AbstractFactory {

    @Override
    public Form createForm(String type) {
        return switch (type){
             case "insertroom" -> new InsertRoomForm();
             default -> null;
        };
    }

    @Override
    public Button createButton(String type) {
        return switch (type){
            case "viewbookedrooms" -> new BookedButton();
            case "insertroom" -> new InsertRoomButton();
            case "back" -> new ReturnButton();
            default -> null;
        };
    }

    @Override
    public Text createText(String type) {
        return null;
    }
}
