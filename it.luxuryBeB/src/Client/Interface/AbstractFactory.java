package Client.Interface;

import Client.Interface.Template.Button;
import Client.Interface.Template.Form;
import Client.Interface.Template.Text;

public interface AbstractFactory {
    public static AbstractFactory getInstance() {
        return null;
    }

    public Form createForm(String type);
    public Button createButton(String type);
    public Text createText(String type);
}
