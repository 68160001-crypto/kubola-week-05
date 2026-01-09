import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab05_6 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Save File with JFileChooser");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Area
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // ===== Menu Bar =====
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // ===== Save Menu Action =====
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try (PrintWriter writer = new PrintWriter(file)) {
                        writer.write(textArea.getText());
                        JOptionPane.showMessageDialog(frame,
                                "Save file successfully.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Error. Unable to save file.");
                    }
                }
            }
        });

        // ===== Exit Menu Action =====
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add menu items
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        // Set MenuBar
        frame.setJMenuBar(menuBar);

        // Layout
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
