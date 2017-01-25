package com.cienet.gen;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.cienet.gen.listener.MyActionListener;

public class MainSwing {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Generate license");
		frame.setResizable(false);
		frame.setLocation(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 200);
		FlowLayout frame_Layout = new FlowLayout(FlowLayout.LEFT);
		frame.setLayout(frame_Layout);

		// 添加输入的mac地址
		JLabel label_Mac_Address = new JLabel("Mac Address:");
		JTextArea text_Mac_Address = new JTextArea(1, 30);
		Button btn_get_Computer_mac = new Button("get Mac address.");
		frame.add(label_Mac_Address);
		frame.add(text_Mac_Address);
		frame.add(btn_get_Computer_mac);
		btn_get_Computer_mac.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String macAddress = ComputerInfo.getMacAddress();
				text_Mac_Address.setText(macAddress);
			}
		});

		// 添加到期时间
		JLabel label_Expiration_Date = new JLabel("Expiration Date");
		JTextArea text_Expiration_Date = new JTextArea(1, 30);
		Button btn_get_time_now = new Button("get now time.");
		frame.add(label_Expiration_Date);
		frame.add(text_Expiration_Date);
		frame.add(btn_get_time_now);
		btn_get_time_now.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				text_Expiration_Date.setText(format.format(new Date()));
			}
		});

		// gen public key.
		JLabel label_pub_path = new JLabel("the pubic key file:");
		JTextArea text_pub_path = new JTextArea(1, 30);
		Button btn_select_pub_path = new Button("select");
		frame.add(label_pub_path);
		frame.add(text_pub_path);
		frame.add(btn_select_pub_path);
		btn_select_pub_path.addActionListener(new MyActionListener(text_pub_path, frame,JFileChooser.FILES_ONLY));

		// get private key.
		JLabel label_pri_path = new JLabel("the private key file:");
		JTextArea text_pri_path = new JTextArea(1, 30);
		Button btn_select_pri_path = new Button("select");
		frame.add(label_pri_path);
		frame.add(text_pri_path);
		frame.add(btn_select_pri_path);
		btn_select_pri_path.addActionListener(new MyActionListener(text_pri_path, frame,JFileChooser.FILES_ONLY));

		// 添加输出的路径
		JTextArea output_path = new JTextArea(3, 50);
		Button btn_output = new Button("export path");
		btn_output.addActionListener(new MyActionListener(output_path, frame,JFileChooser.DIRECTORIES_ONLY));
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

