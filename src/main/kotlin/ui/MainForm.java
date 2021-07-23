package ui;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame{
    private JPanel mainPanel;
    private JButton addButton;
    private JButton removeButton;
    private JTable contactTable;

    public MainForm() {

        setContentPane(mainPanel);
        setSize(500,250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - (mainPanel.getWidth() / 2), dim.height/2 - (mainPanel.getHeight() / 2));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
