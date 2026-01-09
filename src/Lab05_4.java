import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Lab05_4 {

    public static void main(String[] args) {

        // สร้าง Frame
        JFrame frame = new JFrame("Progam with JTextArea");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // สร้าง TextArea
        JTextArea textArea = new JTextArea(8, 30);
        textArea.setLineWrap(true);       // ตัดบรรทัดอัตโนมัติ
        textArea.setWrapStyleWord(true);  // ตัดตามคำ

        // ใส่ ScrollBar ให้ TextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // สร้างปุ่ม
        JButton button = new JButton("Show message");
        JButton Savebutton = new JButton("Save");

        // เมื่อกดปุ่ม
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                JOptionPane.showMessageDialog(frame, text,
                        "Your message: ", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        Savebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    FileWriter writer = new FileWriter("D:\\message.txt");
                    writer.write(textArea.getText());
                    writer.close();

                    JOptionPane.showMessageDialog(frame,"Finish save","Save", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex){
                    JOptionPane.showMessageDialog(frame,"Cant save", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(Savebutton);


        // จัด Layout
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        // แสดงหน้าจอ
        frame.setVisible(true);
    }
}

