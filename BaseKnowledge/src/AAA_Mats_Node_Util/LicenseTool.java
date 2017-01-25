package AAA_Mats_Node_Util;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class LicenseTool {
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setSize(390, 203);
		
		JTabbedPane tabbedPane=new JTabbedPane();
		String[] tabNames = { "Gen pub and pri key", "gen license file" };  
		
		JPanel panel1=new JPanel();
		JTextArea area0=new JTextArea("input private key path");

		JTextArea area1=new JTextArea("input public key path");
		panel1.add(area0);
		panel1.add(area1);
		
		
		
		
		JPanel panel2=new JPanel();
		
		tabbedPane.addTab(tabNames[0], panel1);
		tabbedPane.addTab(tabNames[1], panel2);
		frame.add(tabbedPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
