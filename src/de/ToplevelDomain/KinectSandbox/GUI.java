package de.ToplevelDomain.KinectSandbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTopkek = new JLabel("Placeholder");
		lblTopkek.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopkek.setFont(new Font("Segoe UI", Font.PLAIN, 33));
		contentPane.add(lblTopkek, BorderLayout.CENTER);
	}

}
