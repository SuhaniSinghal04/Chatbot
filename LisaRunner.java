import java.awt.Component;
import java.awt.Dimension;
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
	private JTextArea chat = new JTextArea();
	private ImageIcon bubble;
	private Image imgs;
	
	protected  Image getImage(String fn) {
		Image img = null;
		//fn = PATH_PREFIX+fn;
		try {
			
			img = ImageIO.read(this.getClass().getResource(fn));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}


	public static void main (String[] args) {
	//	new LisaRunner().start();
		new LisaRunner().nowAskQuestions();
		
	}

	private void start() {
		imgs=getImage("house.jpg");
		JFrame frame = new JFrame("ChatBotRunner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {	
				//super.paintComponents(g);
				g.drawImage(imgs, 0,0,600,600,null);
				lisa.draw(g,300,0);
				g.drawRect(0,0, 40, 40);
				
			}
		};
		textbox.setLocation(10,540);
		textbox.setSize(580,30);
		chat.setLocation(10,50);
		chat.setSize(300,300);
		panel.add(textbox);
		panel.add(chat);
		panel.setPreferredSize(new Dimension(600,600));
		panel.setSize(600,600);
		frame.setResizable(false);
		panel.setVisible(true);
		panel.setLayout(null);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		nowAskQuestions();
		
		
		textbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textbox.getText();
			    chat.append("You: " + text + "\n");
				textbox.setText("");
			}
			
		});
	}

	private void nowAskQuestions() {
		for(int i=0;i<7;i++) {
			System.out.println(lisa.askQuestion());
			lisa.saveResponse(input);
		}
			System.out.println(lisa.askQuestion());
			/*lisa.saveResponse("health Effects of Music");
			System.out.println(lisa.askQuestion());
			lisa.saveResponse("listening to favorite music is good for health");
			System.out.println(lisa.askQuestion());
			lisa.saveResponse("music reduces stresss");
			System.out.println(lisa.askQuestion());
			lisa.saveResponse("trials revelaed that it relieves pain");
			System.out.println(lisa.askQuestion());
			lisa.saveResponse("invidiuals can respond diferently to the same piece of music ");
			System.out.println(lisa.askQuestion());
			*/
		}
	}

	

