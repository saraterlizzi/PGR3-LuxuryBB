import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimoSwing {
    public static void main (String args[]){
        JFrame finestra=new JFrame();
       JButton bottone=new JButton("click");
       final JTextField testo=new JTextField();
       JLabel t=new JLabel();
       t.setBounds(50,80,150,20);
       testo.setBounds(50,50,150,20);
       bottone.setBounds(130,100,100,40);
       bottone.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            String contenuto=testo.getText();
            t.setText(contenuto);
           }
       });


       finestra.add(bottone);
       finestra.add(testo);
       finestra.add(t);
       finestra.setSize(400,500);
       finestra.setLayout(null);
       finestra.setVisible(true);
       finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
