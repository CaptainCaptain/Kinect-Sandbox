import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

class Grid extends SwingWorker<Void, Integer>{

	private JFrame frame;
	private int width;
	private boolean active;
	private short[] depth;

	public Grid(){
		frame = new JFrame("Kektus");
		depth = new short[307200];
		active = true;
		for (int i = 0; i < depth.length; i++) {
			depth[i]=25000;
		}
		width=640;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI(){

		GraphicsDevice[] gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
		if (gd.length>0) {

			frame.setLocation(gd[1].getDefaultConfiguration().getBounds().x, gd[1].getDefaultConfiguration().getBounds().y);
			frame.setSize(640, 480);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setUndecorated(true);

			frame.setVisible(true);	

		}
	}

	@Override
	protected Void doInBackground() {
		Graphics g = frame.getGraphics();
		int idx;
		while(active){
			for (int i = 0; i < 480; i++) {
				for (int j = 8; j < width; j++) {
					idx = i*width+j;
					if(depth[idx]<10000){
						g.setColor(Color.BLUE);
					}else if(depth[idx]<15000){
						g.setColor(Color.GREEN);
					}else if (depth[idx]<20000) {
						g.setColor(Color.YELLOW);
					} else if (depth[idx]<25000) {
						g.setColor(Color.RED);
					}
					g.fillRect(j-8, i, 1, 1);
				}
			}
		}
		frame.dispose();
		return null;
	}

	public void setDepth(short[] pDepth){
		depth = pDepth;		
	}

	public void setWidth(int pWidth){
		width = pWidth;
	}

	public void setActive(boolean pActive){
		active = pActive;
	}
}
