package Client.Interface.Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ActionHandler implements ActionListener {
    protected ActionHandler successor;
    public void setSuccessor(ActionHandler successor){
        this.successor = successor;
    }
}
