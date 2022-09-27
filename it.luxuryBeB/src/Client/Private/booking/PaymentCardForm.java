package Client.Private.booking;

import Client.Interface.Template.Form;

import javax.swing.*;

public class PaymentCardForm implements Form {
    private static JTextField intestatario = null;
    private static JTextField numerocarta = null;
    private static JTextField scadenza = null;
    private static JTextField codicesegreto = null;
    private JButton pagamento = null;
    private JLabel inte, num, scad, cvv, pag = null;

    @Override
    public void createForm() {
        intestatario = new JTextField();
        numerocarta = new JTextField();
        scadenza = new JTextField();
        codicesegreto = new JTextField();
        pagamento = new JButton("Paga");
        inte = new JLabel("Intestatario carta:");
        num = new JLabel("Numero carta:");
        scad = new JLabel("Scadenza carta:");
        cvv = new JLabel("CVV:");
        pag = new JLabel("Area Pagamenti");

        intestatario.setBounds(50, 100, 200, 30);
        numerocarta.setBounds(50, 160, 200, 30);
        scadenza.setBounds(50, 220, 90, 30);
        codicesegreto.setBounds(160, 220, 90,30);
        pagamento.setBounds(50, 260, 200, 30);
        inte.setBounds(50, 70, 240, 30);
        num.setBounds(50, 130, 240, 30);
        scad.setBounds(50,190,240,30);
        cvv.setBounds(160,190,240,30);
        pag.setBounds(50,40, 230, 30 );
    }

    @Override
    public void insertForm(JFrame finestra) {
        finestra.add(intestatario);
        finestra.add(numerocarta);
        finestra.add(scadenza);
        finestra.add(codicesegreto);
        finestra.add(pagamento);
        finestra.add(inte);
        finestra.add(num);
        finestra.add(scad);
        finestra.add(cvv);
        finestra.add(pag);
    }
}
