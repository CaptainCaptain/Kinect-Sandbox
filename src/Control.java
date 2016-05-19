import edu.ufl.digitalworlds.j4k.J4KSDK;



public class Control {

	private GUI gui;
	private DepthView grid;
	private Kinect kin;
	private InfaredView cali;
	private boolean calibration;

	public Control(GUI pGui){
		this.gui = pGui;
		this.kin = new Kinect(this);
		this.grid = new DepthView();
		this.cali = new InfaredView();
		calibration = false;
	}

	public void start(){
//		grid.execute();
		kin.setDepthResolution(640, 480);
		kin.setColorResolution(640, 480);
		kin.start(J4KSDK.DEPTH | J4KSDK.INFRARED | J4KSDK.XYZ);
		kin.setElevationAngle(0);
		grid.setWidth(kin.getDepthWidth());
		grid.setHeight(kin.getDepthHeight());
		cali.setWidth(kin.getColorWidth());
		cali.setHeight(kin.getColorHeight());
	}

	public void fillArray(){

	}
	public void calibration() {
//		grid.setActive(false);
		cali.setWidth(kin.getInfraredWidth());
		cali.setHeight(kin.getInfraredHeight());
		cali.execute();
		calibration = true;
	}

	public void sendDepth(float[] depth){
		grid.drawDepth(depth);
	}
	
	public void sendInfared(short[] infrared){
		if (calibration) {
			cali.setInfrared(kin.getInfraredFrame());
		}
	}

	public void sendColor(){
		if (calibration) {
		}
	}
	
}
