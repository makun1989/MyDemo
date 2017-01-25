package com.cienet.gen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyActionListener implements ActionListener {
	JTextArea textArea;
	JFrame parent;
	int chooserType;
	public MyActionListener(JTextArea textArea,JFrame frame,int chooserType){
		this.textArea=textArea;
		this.parent=frame;
		this.chooserType=chooserType;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(chooserType);
		int returnVal = chooser.showOpenDialog(parent);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String selectPath = chooser.getSelectedFile().getPath();
			textArea.setText(selectPath);
		}
	
	}
}
