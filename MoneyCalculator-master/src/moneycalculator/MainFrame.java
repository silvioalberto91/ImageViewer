package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.control.Command;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;
import moneycalculator.ui.swing.SwingMoneyDialog;
import moneycalculator.ui.swing.SwingMoneyDisplay;

public class MainFrame extends JFrame {

    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private Map<String, Command> commands = new HashMap<>();

    public MainFrame() {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setTitle("Money Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(moneyDisplay());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void add(Command command) {
        commands.put(command.name(), command);
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
    

    private Component moneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        dialog.setBackground(Color.BLUE);
        moneyDialog = dialog;
        return dialog;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        display.setBackground(Color.white);
        moneyDisplay = display;
        return display;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.add(calculateButton());
        return panel;
    }

    private Component calculateButton() {
        JButton button = new JButton("Calcolare");
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Calculate").execute();
            }
        };
    }
    
}
