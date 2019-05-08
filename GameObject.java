package gameobjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import vector.Vector;

public abstract class GameObject {

	private Image img;
	private Rectangle rect;
//	private Vector velocity = new Vector(0,0);
	
	
	
	
//CONSTRUCTORS CONSTRUCTORS CONSTRUCTORS CONSTRUCTORS CONSTRUCTORS CONSTRUCTORS CONSTRUCTORS CONSTRUCTORS CONSTRUCTORS 
	
	public GameObject(int x, int y, int width, int height, String s) {
		rect = new Rectangle(x,y,width,height);
		Image i = ImageOpener.openPNG(s);
		img = i.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
	}
	
	public GameObject(int x, int y, int width, int height, Image i) {
		rect = new Rectangle(x,y,width,height);
		img = i.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
	}
	
	public GameObject(int x, int y, Image i) {
		rect = new Rectangle(x,y,i.getWidth(null),i.getHeight(null));
		img = i;
	}
	
	public GameObject(int x, int y, String s) {
		Image i = ImageOpener.openPNG(s);
		rect = new Rectangle(x,y,i.getWidth(null),i.getHeight(null));
		img = i;
	}
	
	public GameObject(Rectangle r, String s) {
		rect = r;
		Image i = ImageOpener.openPNG(s);
		img = i.getScaledInstance(rect.width, rect.height, BufferedImage.SCALE_SMOOTH);
	}
	
	public GameObject(Rectangle r, Image i) {
		rect = r;
		img = i.getScaledInstance(rect.width, rect.height, BufferedImage.SCALE_SMOOTH);
	}
	
	
//GETTERS SETTERS GETTERS SETTERS GETTERS SETTERS GETTERS SETTERS GETTERS SETTERS GETTERS SETTERS GETTERS SETTERS 
	
	public Rectangle getRect() {
		return rect;
	}
	
//	public Vector getVelocity() {
//		return velocity;
//	}
	
//	public void setVelocity(Vector v) {
//		velocity = v;
//	}
	
	public void setY(int y) {
		rect.y = y;
	}
	
	public void setX(int x) {
		rect.x = x;
	}
	
	public int getY() {
		return rect.y;
	}
	
	public int getX() {
		return rect.x;
	}
	
	public int getCenterX() {
		return rect.width/2;
	}
	
	public int getCenterY() {
		return rect.height/2;
	}
	
	public void setImage(Image i) {
		img = i;
	}
	
	public Image getImage() {
		return img;
	}
	
	
	
	
	
//----------------------------------------------------------------------------------------------------------------------
//PUBLIC FUNCTIONS PUBLIC FUNCTIONS PUBLIC FUNCTIONS PUBLIC FUNCTIONS PUBLIC FUNCTIONS PUBLIC FUNCTIONS PUBLIC FUNCTIONS
//----------------------------------------------------------------------------------------------------------------------

//imageStuff imageStuff imageStuff imageStuff imageStuff imageStuff imageStuff imageStuff imageStuff imageStuff imageStuff imageStuff
	
	public void draw(Graphics g) {
		g.drawImage(img, rect.x, rect.y, null);
	}
	
	public void rotate(int degrees) {
		double centerX = (rect.getWidth())/2;
		double centerY = (rect.getHeight())/2;
		
		double rad = Math.toRadians(degrees);
		
		AffineTransform tx = AffineTransform.getRotateInstance(rad, centerX, centerY);
		AffineTransformOp txop = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		img = txop.filter((BufferedImage)img, null);
		
	}
	
	public void rotate(double rad) {
		double centerX = (rect.getWidth())/2;
		double centerY = (rect.getHeight())/2;
		
		AffineTransform tx = AffineTransform.getRotateInstance(rad, centerX, centerY);
		AffineTransformOp txop = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		
		img = txop.filter((BufferedImage)img, null);
		
	}
	
	
	
	
//moving moving moving moving moving moving moving moving moving moving moving moving moving moving moving moving moving moving 
	
//	public void move() {
//		int x = (int)Math.round(velocity.getXComponent());
//		int y = (int)Math.round(velocity.getYComponent());
//		move(x,y);
//	}
	
//	public void accelerateBy(Vector v) {
//		velocity.addVector(v);
//	}
	
	
	public void move(int x, int y) {
		moveHor(x);
		moveVer(y);
	}
	
	private void moveVer(int y) {
		rect.y += y;
	}

	private void moveHor(int x) {
		rect.x += x; 
	}
	
	public void moveTo(int x, int y) {
		setX(x); setY(y);
	}
	
	
	
	
//interactions interactions interactions interactions interactions interactions interactions interactions interactions interactions interactions interactions	
	
	public boolean collides(GameObject go) {
		Rectangle other = go.getRect();
		if (other.intersects(rect)) {
			return true;
		}
		return false;
	}
	
	public Rectangle getCenterRect() {
		int halfW = rect.width/2, halfH = rect.height/2;
		int x = rect.x + halfW/2, y = rect.y + halfH/2;
		
		return new Rectangle(x,y,halfW,halfH);
	}
	
	
	
	
	
	
	
}
