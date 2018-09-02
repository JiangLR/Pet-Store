package cn.edu.zucc.pet_service.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author JiangLR
 * @Time 2018-09-02 16:15
 */
public class gui_test {
    public static void main(String[] args) {
        JFrame f = new JFrame("title");
        f.setSize(400, 300);
        f.setLocation(400, 400);
        f.setLayout(new FlowLayout());

        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("file");
        JMenuItem mi = new JMenuItem("exit");

        m.add(mi);
        mb.add(m);

        f.setJMenuBar(mb);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);

        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
