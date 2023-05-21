package view;

import javax.swing.*;

import controller.CurrencyController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyView {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField fromAmountField;
    private JTextField toAmountField;
    private JButton convertButton;
    private CurrencyController controller;

    public CurrencyView() {
        // Estableciendo atributos del JFrame
        frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        fromCurrencyComboBox = new JComboBox<>(new String[] { "MXN", "EUR", "USD" });
        toCurrencyComboBox = new JComboBox<>(new String[] { "USD", "EUR", "MXN" });
        fromAmountField = new JTextField(10);
        toAmountField = new JTextField(10);
        convertButton = new JButton("Convert");

        // Action listener para convertir al hacer click en el boton
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.convertCurrency();
            }
        });
        // Agregando los components al panel
        panel.add(fromCurrencyComboBox);
        panel.add(fromAmountField);
        panel.add(toCurrencyComboBox);
        panel.add(toAmountField);
        panel.add(convertButton);

        frame.getContentPane().add(panel);
    }

    public void setController(CurrencyController controller) {
        this.controller = controller;
    }

    public void createAndShowGUI() {
        frame.pack();
        frame.setVisible(true);
    }

    public String getFromCurrency() {
        return fromCurrencyComboBox.getSelectedItem().toString();
    }

    public String getToCurrency() {
        return toCurrencyComboBox.getSelectedItem().toString();
    }

    public double getFromAmount() {
        try {
            return Double.parseDouble(fromAmountField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public double getToAmount() {
        try {
            return Double.parseDouble(toAmountField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public void setFromAmount(double amount) {
        fromAmountField.setText(String.valueOf(amount));
    }

    public void setToAmount(double amount) {
        toAmountField.setText(String.valueOf(amount));
    }
}
