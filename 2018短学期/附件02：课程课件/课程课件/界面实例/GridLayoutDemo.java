package cn.edu.zucc.booklib.LayoutDemo;

import javax.swing.*;

import java.awt.*;

public class GridLayoutDemo extends JFrame {

	public GridLayoutDemo() {
		setLayout(new GridLayout(0, 2)); // 设置为网格布局，未指定行数
		setFont(new Font("Helvetica", Font.PLAIN, 14));
		getContentPane().add(new JButton("Button 1"));
		getContentPane().add(new JButton("Button 2"));
		getContentPane().add(new JButton("Button 3"));
		getContentPane().add(new JButton("Button 4"));
		getContentPane().add(new JButton("Button 5"));

	}

	public static void main(String args[]) {

		GridLayoutDemo f = new GridLayoutDemo();
		f.setTitle("GridWindow Application");
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null); // 让窗体居中显示

	}

}
