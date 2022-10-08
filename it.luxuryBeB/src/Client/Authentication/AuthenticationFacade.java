package Client.Authentication;

import Client.ClientVisitor;
import Client.FactoryMaker;
import Client.FrameMemento;
import Client.Interface.AbstractFactory;
import Client.Interface.Handler.ActionHandler;
import Client.Interface.Memento;
import Client.Interface.Template.Button;
import Client.Interface.Template.Form;
import Client.Interface.Visitor;

import javax.swing.*;

/**
 * Classe per implementare il pattern Facade nel sottopackage Authentication
 * @author Filomena De Rosa, Sara Terlizzi
 */
public class AuthenticationFacade {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static AuthenticationFacade instance=null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static AuthenticationFacade getInstance() {
        if (instance == null) {
            instance = new AuthenticationFacade();
        }
        return instance;
    }

    /** Metodo per implementare il login
     */
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

        finestra.setVisible(true);
    }

    /** Metodo per implementare la registrazione
     */
    public void register(){
        AbstractFactory AF = FactoryMaker.getInstance().getFactory("auth");
        FrameMemento Frame=FrameMemento.getInstance();
        Frame.setMemento();
        JFrame finestra = Frame.restoreState();

        Form regi = AF.createForm("registration");
        regi.createForm();
        regi.insertForm(finestra);

        finestra.setVisible(true);
    }
}
