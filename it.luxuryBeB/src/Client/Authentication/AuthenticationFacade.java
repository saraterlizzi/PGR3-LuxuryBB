package Client.Authentication;

import Client.ClientVisitor;
import Client.FactoryMaker;
import Client.FrameMemento;
import Client.Interface.AbstractFactory;
import Client.Interface.Memento;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;
import Client.Interface.Visitor;

import javax.swing.*;

public class AuthenticationFacade {
    private static AuthenticationFacade instance=null;


    public static AuthenticationFacade getInstance() {
        if (instance == null) {
            instance = new AuthenticationFacade();
        }
        return instance;
    }

    public void login(){
        AbstractFactory AF = FactoryMaker.getInstance().getFactory("auth");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Form login = AF.createForm("login");
        login.createForm();
        login.insertForm(finestra);
        Button registration = AF.createButton("registration");
        registration.createButton();
        registration.insertButton(finestra);
    }
    public void register(){
        AbstractFactory AF = FactoryMaker.getInstance().getFactory("auth");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Form regi = AF.createForm("registration");
        regi.createForm();
        regi.insertForm(finestra);
    }

}
