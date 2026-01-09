import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab05_8 extends JFrame {

    private JTextArea textArea;
    private File currentFile;

    public Lab05_8() {

        setTitle("Chonnipa-Pookkesorn 68160001 n01");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== TextArea =====
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // ===== Menu Bar =====
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        JMenuItem itemNew = new JMenuItem("New");
        JMenuItem itemOpen = new JMenuItem("Open");
        JMenuItem itemSave = new JMenuItem("Save");
        JMenuItem itemSaveAs = new JMenuItem("Save As");
        JMenuItem itemExit = new JMenuItem("Exit");

        menuFile.add(itemNew);
        menuFile.add(itemOpen);
        menuFile.add(itemSave);
        menuFile.add(itemSaveAs);
        menuFile.addSeparator();
        menuFile.add(itemExit);

        menuBar.add(menuFile);
        setJMenuBar(menuBar);

        // ===== New =====
        itemNew.addActionListener(e -> {
            textArea.setText("");
            currentFile = null;
        });

        // ===== Open =====
        itemOpen.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = chooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {
                    textArea.setText("");
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Open file error");
                }
            }
        });

        // ===== Save =====
        itemSave.addActionListener(e -> {
            if (currentFile == null) {
                saveAs();
            } else {
                saveFile(currentFile);
            }
        });

        // ===== Save As =====
        itemSaveAs.addActionListener(e -> saveAs());

        // ===== Exit =====
        itemExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    // ===== Save As Method =====
    private void saveAs() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            saveFile(currentFile);
        }
    }

    // ===== Save File Method =====
    private void saveFile(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(textArea.getText());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Save file error");
        }
    }

    public static void main(String[] args) {
        new Lab05_8();
    }
}
