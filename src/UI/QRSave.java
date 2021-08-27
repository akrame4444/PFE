package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class QRSave extends JFrame {

	private JPanel contentPane;
	private Image image;

	/**
	 * Launch the application.
	 */
	public static void qro(String[] args, String path) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QRSave frame = new QRSave(path);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QRSave(String path) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    BufferedImage img;
		try {
			img = ImageIO.read(new File(path));
			ImageIcon icon = new ImageIcon(img);
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(30, 11, 501, 391);
			contentPane.add(lblNewLabel);
			lblNewLabel.setIcon(icon);
			image=icon.getImage();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage bImage = null;
				
				 
	             try {
	            	 JFrame parentFrame = new JFrame();
					bImage = (BufferedImage) image;
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setDialogTitle("Specify a file to save");  
					int userSelection = fileChooser.showSaveDialog(parentFrame);

					if (userSelection == JFileChooser.APPROVE_OPTION) {
					    File fileToSave = fileChooser.getSelectedFile();
			             ImageIO.write(bImage, "gif", new File(fileToSave.getAbsolutePath()+".gif")); 

					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	 
				
			}
		});
		btnNewButton.setBounds(212, 439, 125, 23);
		contentPane.add(btnNewButton);
	}

}
