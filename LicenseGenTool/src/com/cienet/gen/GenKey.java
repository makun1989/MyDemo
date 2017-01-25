package com.cienet.gen;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import starschema.slm4j.Main;

public class GenKey {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tool to generate pub and private key.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(800, 300);
		frame.setSize(400, 300);
		frame.setVisible(true);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
		frame.setLayout(flowLayout);

		// gen public key.
		JLabel label_pub_path = new JLabel("pub path:");
		JTextArea text_pub_path = new JTextArea(1, 20);
		Button btn_select_pub_path = new Button("select");
		frame.add(label_pub_path);
		frame.add(text_pub_path);
		frame.add(btn_select_pub_path);
		btn_select_pub_path.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = chooser.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					text_pub_path.setText(path);
				}
			}
		});

		// get private key.
		JLabel label_pri_path = new JLabel("pri path:");
		JTextArea text_pri_path = new JTextArea(1, 20);
		Button btn_select_pri_path = new Button("select");
		frame.add(label_pri_path);
		frame.add(text_pri_path);
		frame.add(btn_select_pri_path);
		btn_select_pri_path.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = chooser.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					text_pri_path.setText(path);
				}
			}
		});

		Button btn_gen_key = new Button("Click to generate public and private key");
		btn_gen_key.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] parameters = new String[] { "sign", "-license", "temp", "-public",
						text_pub_path.getText() + "/key.pub", "-private", text_pri_path.getText() + "/key.pkf", "-sign",
						"temp" };
				try {
					new File("temp").createNewFile();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "failed to generate temp file.", "alert",
							JOptionPane.ERROR_MESSAGE);
				}
				Main.main(parameters);
				new File("temp").delete();
			}
		});
		frame.add(btn_gen_key);

	}
}
