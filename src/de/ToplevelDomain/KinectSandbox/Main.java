package de.ToplevelDomain.KinectSandbox;

import java.awt.EventQueue;

public class Main {

	public Main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		Main main = new Main();

	}

}
