package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    private JTextField nameTxtField;
    private JTextField numberTxtField;
    private JPanel contactPanel;
    private JButton cancelButton;
    private JButton saveButton;

    public ContactForm(){

        setContentPane(contactPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - (getSize().width / 2), dim.height/2 - (getSize().height / 2));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setListeners();
    }

    private void setListeners(){
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new MainForm();
                    dispose();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
