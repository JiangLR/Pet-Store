package cn.edu.zucc.pet_service.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author JiangLR
 * @Time 2018-09-02 14:48
 */
public class gui_test {
    public static void main(String[] args) {
        JFrame f = new JFrame("Title");
        f.setSize(400, 300);
        f.setLayout(new FlowLayout());
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        JTextField tf = new JTextField(20);
        JButton bt = new JButton("数据转移");
        JTextArea ta = new JTextArea(10, 20);

        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = tf.getText().trim();
                ta.append(str + '\n');
                tf.setText("");
            }
        });


        f.add(tf);
        f.add(bt);
        f.add(ta);
        f.setVisible(true);
    }
}
