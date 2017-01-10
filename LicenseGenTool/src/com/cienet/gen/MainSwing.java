package com.cienet.gen;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class MainSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Generate license");
		frame.setResizable(false);
		frame.setLocation(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 300);
		FlowLayout frame_Layout = new FlowLayout(FlowLayout.CENTER);
		frame.setLayout(frame_Layout);

		// 添加输入的mac地址
		JLabel label_Mac_Address = new JLabel("Mac Address:");
		JTextArea text_Mac_Address = new JTextArea(1, 30);
		frame.add(label_Mac_Address);
		frame.add(text_Mac_Address);

		// 添加到期时间
		JLabel label_Expiration_Date = new JLabel("Expiration Date");
		JTextArea text_Expiration_Date = new JTextArea(1, 30);
		frame.add(label_Expiration_Date);
		frame.add(text_Expiration_Date);

		// 添加输出的路径
		JTextArea output_path = new JTextArea(5, 40);
		Button btn_output = new Button("export path");
		btn_output.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				String selectPath = null;
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// 设置只能选择目录
				int returnVal = chooser.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					selectPath = chooser.getSelectedFile().getPath();
					output_path.setText(selectPath);
					// chooser.hide();
				}
			}

		});
		frame.add(output_path);
		frame.add(btn_output);

		// 添加生成license.txt的按钮
		Button mButton = new Button("Generate");
		mButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					GenerateLicenseFile.generateLicense(text_Mac_Address.getText(), text_Expiration_Date.getText(),
							output_path.getText());
					text_Mac_Address.setText("");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "failed to generate license file.", "alert",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		frame.add(mButton);

		frame.setVisible(true);

	}
}
