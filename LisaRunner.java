import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.*;
import javax.swing.*;

public class LisaRunner {
	
	private JTextField textbox = new JTextField();
	private Lisa lisa= new Lisa();
	private Image bubble;
	private Image imgs;
	private Image notebook;
	private String message1="";
	private String message2="";
	private String message3="";
	private String lengthChecker="";
	private String thesis1 = "";
	private String thesis2 = "";
	private String thesis3 = "";
	private String thesis4 = "";
	private String thesis5 = "";
	private String thesis0 = "";
	private String thesis15="";
	private String thesis25="";
	private String thesis35="";
	private String thesis45="";
	private String thesis55="";
	
	int x=0;
	protected  Image getImage(String fn) {
		Image img = null;
		try {
			
			img = ImageIO.read(this.getClass().getResource(fn));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}


	public static void main (String[] args) {
	
		new LisaRunner().start();
		
		
	}

	private void start() {
		imgs=getImage("lisahouse.png");
		bubble=getImage("bubble1.png");
		notebook=getImage("notebook.png");
		JFrame frame = new JFrame("Lisa");
		JFrame frame2= new JFrame("Thesis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {	
				super.paintComponents(g);
				g.drawImage(imgs, 0,0,790,600,null);
				g.drawImage(bubble,0,20,900,600,null);
				lisa.draw(g,500,0);
				Font myFont = new Font ("Lucida Handwriting", 1, 17);
				g.setFont(myFont); 
				g.drawString(message1,275,200);
				g.drawString(message2, 275, 220);
				g.drawString(message3, 275, 240);
				
			}
		};
		
		JPanel panel2= new JPanel() {
			@Override
			public void paintComponent (Graphics g) {
				g.drawImage(notebook, 0, 0, 790, 600, null);
				Font a = new Font ("TimesRoman", Font.BOLD, 30);
				g.setFont(a);
				g.drawString(thesis0,105,50);
				Font b = new Font ("TimesRoman", Font.PLAIN, 20);
				g.setFont(b);
				g.drawString(thesis1, 105, 80);
				g.drawString(thesis15, 105, 105);
				g.drawString(thesis2, 105, 130);
				g.drawString(thesis25,105,155);
				g.drawString(thesis3, 105, 175);
				g.drawString(thesis35, 105, 200);
				g.drawString(thesis4, 105, 225);
				g.drawString(thesis45, 105, 250);
				g.drawString(thesis5, 105, 275);
				g.drawString(thesis55, 105, 300);
				
			}
		};
		
		textbox.setLocation(10,540);
		textbox.setSize(580,30);
		panel.add(textbox);
		panel.setPreferredSize(new Dimension(790,600));
		panel2.setPreferredSize(new Dimension(790,600));
		frame.setResizable(false);
		frame2.setResizable(true);
		panel.setVisible(true);
		panel2.setVisible(true);
		panel.setLayout(null);
		panel2.setLayout(null);
		frame.add(panel);
		frame2.add(panel2);
		frame.pack();
		frame2.pack();
		frame.setVisible(true);
		frame2.setVisible(false);
		message1 =(lisa.askQuestion());
		panel.repaint();
		panel2.repaint();

		
		textbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textbox.getText();
				lisa.saveResponse(text);
				lengthChecker= lisa.askQuestion();
				if (lengthChecker.length()==19) {
					message1= lengthChecker;
				}
				else if(lengthChecker.length()==46) {
					message1=lengthChecker.substring(0,17);
					message2=lengthChecker.substring(17,35);
					message3=lengthChecker.substring(35,46);
				}
				else if(lengthChecker.length()==50) {
					message1=lengthChecker.substring(0,21);
					message2=lengthChecker.substring(21,39);
					message3=lengthChecker.substring(39,50);
				}
				else if (lengthChecker.length()==49) {
					message1=lengthChecker.substring(0,17);
					message2=lengthChecker.substring(17,34);
					message3=lengthChecker.substring(34,49);
				}
				else {
				x= lengthChecker.indexOf("*");
				thesis0= lengthChecker.substring(0,x);
				lengthChecker=lengthChecker.substring(x+1);
				x= lengthChecker.indexOf("*");
				thesis1= lengthChecker.substring(0,x);
				if(thesis1.length()>75) {
					thesis15=thesis1.substring(76);
					thesis1=thesis1.substring(0,76);
				}
				lengthChecker=lengthChecker.substring(x+1);
				x= lengthChecker.indexOf("*");
				thesis2= lengthChecker.substring(0,x);
				lengthChecker=lengthChecker.substring(x+1);
				x= lengthChecker.indexOf("*");
				thesis3= lengthChecker.substring(0,x);
				lengthChecker=lengthChecker.substring(x+1);
				x= lengthChecker.indexOf("*");
				thesis4= lengthChecker.substring(0,x);
				lengthChecker=lengthChecker.substring(x+1);
				x= lengthChecker.indexOf("*");
				thesis5= lengthChecker.substring(0,x);
				lengthChecker=lengthChecker.substring(x+1);
				
                   frame2.setVisible(true);
                   frame.dispose();
				}
				panel.repaint();
				panel2.repaint();
				textbox.setText("");
			}
			
		});
	}

		
}

