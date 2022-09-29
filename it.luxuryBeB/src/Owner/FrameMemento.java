package Owner;

import Client.Interface.Memento;

import javax.swing.*;

public class FrameMemento implements Memento {
    private static FrameMemento instance;
    private JFrame Frame=null;

    public static FrameMemento getInstance() {
        if (instance == null) {
            instance = new FrameMemento();
        }
        return instance;
    }

    public void  setMemento(){
        this.Frame=new JFrame("Luxury B&B");
        this.Frame.setSize(800, 740);
        this.Frame.setLayout(null);
        this.Frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Frame, "Sicuro di Chiudere?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }

    public JFrame restoreState(){
        this.Frame.getContentPane().removeAll();
        this.Frame.setVisible(true);
        return this.Frame;
    }
}