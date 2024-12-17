package com.chessgame.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Help extends JFrame {


    public Help() {
        initComponents();
    }


    private void initComponents() {
        // Main panel setup
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new BorderLayout());

        // Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel backLabel = new JLabel("Back");
        backLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        backLabel.setForeground(Color.WHITE);
        backLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                onBackLabelClicked();
            }
        });

        JLabel titleLabel = new JLabel("INSTRUCTIONS");
        titleLabel.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        titlePanel.add(backLabel);
        titlePanel.add(Box.createHorizontalStrut(30));
        titlePanel.add(titleLabel);

        // Content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        addContent(contentPanel);

        // Add panels to main frame
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(contentPanel), BorderLayout.CENTER);

        // Frame setup
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Help");
        setSize(1050, 550);
        setLocationRelativeTo(null);
        add(mainPanel);
    }


    private void addContent(JPanel contentPanel) {
        contentPanel.add(createLabel("   At the start, each player controls sixteen pieces: one king, one queen, two rooks, two bishops, two knights, and eight pawns.", 18));
        contentPanel.add(createLabel("   The player who moves first controls white pieces, and the other controls black pieces. ", 18));
        contentPanel.add(createLabel("   The object of the game is to checkmate the opponent's king, whereby the king is under immediate attack and", 18));
        contentPanel.add(createLabel("   there is no way for it to escape.", 18));
        contentPanel.add(createLabel("   There are also several ways a game can end in a draw.", 18));

        contentPanel.add(Box.createVerticalStrut(20));

        contentPanel.add(createLabel("   CHESS RULES", 24, true));
        contentPanel.add(createLabel("   Click on the \"Start\" button to start the game", 20));
        contentPanel.add(createLabel("   Click on any piece to see the possible locations to move them.", 20));
        contentPanel.add(createLabel("   Press left arrow key to undo the moves", 20));
        contentPanel.add(createLabel("   Click on the \"Exit\" button or close icon to leave the game", 20));
    }


    private JLabel createLabel(String text, int fontSize) {
        return createLabel(text, fontSize, false);
    }


    private JLabel createLabel(String text, int fontSize, boolean bold) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", bold ? Font.BOLD : Font.PLAIN, fontSize));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }


    private void onBackLabelClicked() {
        new Home().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Help().setVisible(true));
    }
}
