package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import SQL.SQLManager;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Dialog.ModalExclusionType;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 * @param string 
	 */
	public static void sain(String[] args, String path, String Email, String Owner) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(path,Email, Owner);
					frame.setVisible(true);
					frame.setSize(1200,600);
					frame.setLocationRelativeTo(null);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param Email 
	 */
	public Home(String path , String Email, String Owner) {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		System.out.println("home= "+ Owner);
		setBounds(100, 100, 1138, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//String data[][] = {{"Owner","Description","Type"},
		//		   {"Deepak","PGDCA","History"},
		//		   {"Ranjan","M.SC.","Biology"},
		//		   {"Radha","BCA","Computer"}};
		
		String data[][] = SQLManager.FileUploader();
		
	    String col[] = {"file name","Description","owner","Type"};
        DefaultTableModel model = new DefaultTableModel(data,col);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(844, 11, 130, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(194, 32, 999, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextField username = new JTextField("");
		username.setBounds(26, 65, 130, 40);
		contentPane.add(username);
		
		JButton btnNewButton_2_1 = new JButton("Log off");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogReg frm = new LogReg(null);
				frm.poompe(null);
				dispose();
			}
			
		});
		btnNewButton_2_1.setBounds(26, 369, 130, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Show QR");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QRSave QRsaveFrame = new QRSave(path);
				QRsaveFrame.qro(null, path);
			}
		});
		btnNewButton_2_2.setBounds(26, 403, 130, 23);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Edit infos");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoFrame f = new InfoFrame(null, true);
				f.foo(null, true);
			}
		});
		btnNewButton_2_3.setBounds(26, 433, 130, 23);
		contentPane.add(btnNewButton_2_3);
		
		JButton btnNewButton_2_3_1 = new JButton("Edit attributs");
		btnNewButton_2_3_1.setBounds(26, 467, 130, 23);
		contentPane.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_2_3_1_1 = new JButton("My files");
		btnNewButton_2_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyFiles frm = new MyFiles(path,Email, Owner);
				frm.sain(null, path,Email, Owner);
				dispose();
				
			}
		});
		btnNewButton_2_3_1_1.setBounds(26, 501, 130, 23);
		contentPane.add(btnNewButton_2_3_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 65, 1139, 459);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
	username.setText(Owner);
	
	JButton btnNewButton_1 = new JButton("Open file");
	btnNewButton_1.setBounds(26, 326, 130, 32);
	contentPane.add(btnNewButton_1);
	
	JButton btnNewButton_2 = new JButton("Add file");
	btnNewButton_2.setBounds(10, 292, 130, 23);
	contentPane.add(btnNewButton_2);
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String info = data [table.getSelectedRow()][0];
			String ext = SQLManager.getext(info);
			System.out.println(ext);
			switch (ext) {
			case "txt": {
				System.out.println("tada");
				System.out.println("ext is = "+ext);
				TextViewer frm = new TextViewer("test test");
				frm.barad("test test");
				System.out.println("is no text");
				
			}
			default:
				System.out.println("oh no ");
				SQLManager.readPicture(info);
				ImgViewer frm = new ImgViewer("C:\\Users\\AKRAME\\Desktop\\pfe\\temp");
				frm.Blyat("C:\\Users\\AKRAME\\Desktop\\pfe\\temp");
			}
			//if(ext == "txt") {
				//System.out.println("oh no ");
				//SQLManager.readPicture(info);
				//ImgViewer frm = new ImgViewer("D:\\peepeepoopoo\\PFE\\ppnyar.png");
				//frm.Blyat("D:\\peepeepoopoo\\PFE\\ppnyar.png");
				//System.out.println("is tetxt");
			//}
			//else {
				
				//System.out.println("ext is = "+ext);
				//TextViewer frm = new TextViewer("test test");
				//frm.barad("test test");
				//System.out.println("is no text");
			//}
		}
	});
	}
}
