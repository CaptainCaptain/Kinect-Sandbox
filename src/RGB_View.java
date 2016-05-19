import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;


public class RGB_View extends SwingWorker<Void, Void>{

	private JFrame frame;
	private int width = 640;
	private int height = 480;
	private byte[] cam;
	private boolean active;


	public RGB_View(){
		cam = new byte[1228800];
				for (int i = 0; i < cam.length; i++) {
					cam[i]=0b0010_0101;
				}

		active = true;
		frame = new JFrame("Calibration");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI(){
		frame.setSize(640, 480);
		frame.setLocation(600, 0);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}


	@Override
	protected Void doInBackground(){
		Graphics g = frame.getGraphics();
		g.fillRect(1, 1, 200, 200);
		//		System.out.println("drawn");
		//		int line = 0;
		//		int position = 0;
		//		while(active){
		//			line = 0;
		//			int[] rgb = toIntArray(cam);
		//			System.out.println(rgb==null);
		//			for (int i = 0; i < rgb.length; i=i+4) {
		//				if (i+4%width==0){line++;position = 0;}
		////				float[] hsb = Color.RGBtoHSB(cam[i], cam[i+1], cam[i+2], null);
		////				g.setColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
		//				g.fillRect(position, line, 1, 1);
		//				position++;
		//			}
		//		}

		while(active){
		    int[] color = new int[width * height];

		    // (byte) bgra to rgb (int)
		    for (int i = 0, j = 0; i < cam.length; i = i + 4, j++) {
		        int b, gr, r;

		        b = cam[i] & 0xFF;
		        gr = cam[i + 1] & 0xFF;
		        r = cam[i + 2] & 0xFF;

		        color[j] = (r << 16) | (gr << 8) | b;
		    }

		    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		    bufferedImage.getRaster().setDataElements(0, 0, width, height, color);
		    bufferedImage.setRGB(0, 0, width, height, color, 0, width);
		    g.drawImage(bufferedImage, 0, 0, null);
		}

		return null;
	}


	public void setActive(boolean pActive){
		active = pActive;
	}
	public void setCam(byte[] pCam){
		cam = pCam;
	}
	public void setWidth(int pWidth) {
		width = pWidth;
	}
	public void setHeight(int pHeight){
		height = pHeight;
	}

}

