package Owner;

import Client.Interface.Memento;

import javax.swing.*;

/**
 * Classe per l'implementazione del pattern Memento per salvare il JFrame e renderlo accessibile globalmente
 a tutte le classi
 * @author Filomena De Rosa, Sara Terlizzi
 * @see Owner.Interface.Template.Memento
 */

public class FrameMemento implements Memento {
    /** Attributo statico per l'applicazione del pattern Singleton
     */
    private static FrameMemento instance;

    /** Attributo per il frame generale dell'Owner
     */
    private JFrame Frame=null;

    /** Metodo per implementare il pattern Singleton
     @return instance (l'unica istanza della classe)
     */
    public static FrameMemento getInstance() {
        if (instance == null) {
            instance = new FrameMemento();
        }
        return instance;
    }

    /** Metodo per settare e impostare il frame generale
     */
    public void  setMemento(){
        if(this.Frame==null){
            this.Frame=new JFrame("Luxury B&B");
        }
        this.Frame.setSize(1000, 740);
        this.Frame.setLayout(null);
        this.Frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(Frame, "Sicuro di Chiudere?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                    OwnerProxy.getInstance().end();
                }
            }
        });
    }

    /** Metodo per resettare il frame generale
     @return this.Frame (il frame stesso)
     */
    public JFrame restoreState(){
        this.Frame.getContentPane().removeAll();
        this.Frame.repaint();

        return this.Frame;
    }
}