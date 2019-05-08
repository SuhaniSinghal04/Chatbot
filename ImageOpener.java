package gameobjects;

import java.awt.Image;

import javax.imageio.ImageIO;

//import java.lang.Object.ImageOpener;

public final class ImageOpener  {

	private static String folder = "/res/sprites/";
	
	//RANDOM SYSOUT TESTER
	public static void main(String[] arg) {
		System.out.println();
		double d = Math.toDegrees(Math.asin((2.0)/(1.0)));
		System.out.println(d);
	}
	
	
	public static Image openPNG(String s) {
		try {
			//String s1 = folder+s+".png";
			//System.out.println(s1);
			//System.out.println(o.getClass().getResource("/res/cardImages/"+s));
			Image i = ImageIO.read(ImageOpener.class.getResource(folder+s+".png"));
			System.out.println("Card "+s+ " Opened");
			return i;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Image open(Object o, String s) {
		try {
			//String s1 = folder+s+".png";
			//System.out.println(s1);
			//System.out.println(o.getClass().getResource("/res/cardImages/"+s));
			Image i = ImageIO.read(o.getClass().getResource(folder+s+".png"));
			System.out.println("Card "+s+ " Opened");
			return i;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
