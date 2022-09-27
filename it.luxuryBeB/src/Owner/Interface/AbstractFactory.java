package Owner.Interface;

import Owner.Interface.Template.Button;
import Owner.Interface.Template.Form;
import Owner.Interface.Template.Text;

public interface AbstractFactory {
    public static AbstractFactory getInstance() {
        return null;
    }

    public Form createForm(String type);
    public Button createButton(String type);
    public Text createText(String type);
}
