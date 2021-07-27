package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame{

    private JButton addButton;
    private JButton removeButton;
    private JTable contactTable;
    private JPanel rootPanel;
    private JLabel contactCountLbl;

    private ContactBusiness mContactBusiness;
    private String mName = "";
    private String mPhone = "";

    public MainForm(){

        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);
        mContactBusiness = new ContactBusiness();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2 - (getSize().width / 2), dim.height/2 - (getSize().height / 2));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setListeners();
        loadContacts();
    }

    private void loadContacts(){
        List<ContactEntity> contacList =  mContactBusiness.getList();

        String[] columNames = {"Nome", "Telefone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columNames);

        for(ContactEntity i : contacList){
            Object[] o = new Object[2];
            o[0] = i.getName();
            o[1] = i.getPhone();

            model.addRow(o);
        }

        contactCountLbl.setText(mContactBusiness.getContactCountDescription());
        contactTable.clearSelection();
        contactTable.setModel(model);
    }

    private void setListeners(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactForm();
                dispose();
            }
        });

        contactTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (contactTable.getSelectedRow() != -1) {
                    if (e.getValueIsAdjusting()) {
                        mName = contactTable.getValueAt(contactTable.getSelectedRow(), 0).toString();
                        mPhone = contactTable.getValueAt(contactTable.getSelectedRow(), 1).toString();
                    }

                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mContactBusiness.delete(mName,mPhone);
                    loadContacts();
                    mName = "";
                    mPhone = "";
                }catch (Exception exc){
                    JOptionPane.showMessageDialog(new JFrame(), exc.getMessage());
                }
            }
        });
    }
}
