package com.chessgame.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

    public Home() {
        initComponents();
    }

    private void initComponents() {
        // Create main panel with GridBagLayout to center components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(165, 211, 108)); // Light green background

        // Button panel for Start, Instructions, and Exit buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make panel transparent
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Create identical-sized boxes for buttons
        buttonPanel.add(createButtonBox("START", 28));
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(createButtonBox("INSTRUCTIONS", 28));
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(createButtonBox("EXIT", 28));

        // Add button panel to the main panel
        mainPanel.add(buttonPanel, new GridBagConstraints());

        // Frame setup
        setTitle("Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        add(mainPanel);
    }


    private JPanel createButtonBox(String text, int fontSize) {
        JPanel box = new JPanel();
        box.setPreferredSize(new Dimension(300, 80)); // Fixed size for all boxes
        box.setLayout(new BorderLayout());
        box.setOpaque(false);

        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        button.setBackground(new Color(186, 210, 166));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setPreferredSize(new Dimension(300, 80)); // Matches the box size

        // Add button to the box
        box.add(button, BorderLayout.CENTER);

        // Add action listeners
        if (text.equals("START")) {
            button.addActionListener(evt -> onStartButtonClicked());
        } else if (text.equals("INSTRUCTIONS")) {
            button.addActionListener(evt -> onInstructionsButtonClicked());
        } else if (text.equals("EXIT")) {
            button.addActionListener(evt -> onExitButtonClicked());
        }

        return box;
    }


    private void onStartButtonClicked() {
        new Frame().setVisible(true);
        dispose();
    }


    private void onInstructionsButtonClicked() {
        new Help().setVisible(true);
        dispose();
    }


    private void onExitButtonClicked() {
        System.exit(0);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home().setVisible(true));
    }
}
