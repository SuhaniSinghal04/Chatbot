//change font
//change background image
//change location of questions
// change format for the thesis
// change the text bubble

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;

import javax.imageio.ImageIO;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.*;
import javax.swing.*;

public class LisaRunner {
	
	private JTextField textbox = new JTextField();
	private Lisa lisa= new Lisa();
	//private JTextArea chat = new JTextArea();
	private Image bubble;
	private Image imgs;
	private AttributedString message;
	
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
	
		new LisaRunner().start();
		//new LisaRunner().nowAskQuestions();
		
	}

	public void start() {
		imgs=getImage("house.png");
		bubble=getImage("bubble.png");
		JFrame frame = new JFrame("ChatBotRunner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Lucida Handwriting",Font.PLAIN, 20);
		AttributedString q = new AttributedString(lisa.askQuestion());
		q.addAttribute(TextAttribute.FONT, font);	
		message =q;
		JPanel panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {	
				//super.paintComponents(g);
//				g.drawImage(imgs, 0,0,800,500,null);
//				g.drawImage(bubble,150,20,550,450,null);
//				lisa.draw(g,550,100);
//				//g.drawString(message,250,100);
//				g.drawString(message.getIterator(),250,100);
				if(question()==true) {
					g.drawImage(getImage("paper.jpg"),0,0, 500, 800, null);
					g.drawString(message.getIterator(), 100, 200);
				}
				else {
					g.drawImage(imgs, 0,0,800,500,null);
					g.drawImage(bubble,150,20,550,450,null);
					lisa.draw(g,550,100);
					//g.drawString(message,250,100);
					g.drawString(message.getIterator(),250,100);
				}
			}
		};
	
//		textbox.setLocation(10,450);
//		textbox.setSize(790,30);
		//chat.setLocation(10,50);
		//chat.setSize(300,300);
			
//		panel.add(textbox);
		//panel.add(chat);
//		panel.setPreferredSize(new Dimension(800,500));
//		panel.setSize(600,600);
		frame.setResizable(true);
		panel.setVisible(true);
		panel.setLayout(null);
		if(question()==true) {
			panel.setPreferredSize(new Dimension(500,800));
		}
		else {
			panel.setPreferredSize(new Dimension(800,500));
			textbox.setLocation(10,450);
			textbox.setSize(790,30);
			panel.add(textbox);
		}
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	//	chat.setText(lisa.askQuestion());
		panel.repaint();
		

		/*private void nowAskQuestions() {
			for(int i=0;i<7;i++) {
				System.out.print(lisa.questionNum);
				
				chat.setText(lisa.askQuestion());
				
				lisa.saveResponse(textbox.getText());
			}
			*/
		textbox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textbox.getText();
				lisa.saveResponse(text);
				//chat.setText(lisa.askQuestion());
				Font font = new Font("Lucida Handwriting",Font.PLAIN, 20);
				AttributedString q = new AttributedString(lisa.askQuestion());
				q.addAttribute(TextAttribute.FONT, font);	
				message =q;
				//message= lisa.askQuestion();
				panel.repaint();
			  //  chat.append("You: " + text + "\n");
				textbox.setText("");
	
			}
			
		});
		
	}


	protected boolean question() {
		if(lisa.getQuestionNum() == lisa.getQuestionList().size()+1) {
			return true;
		}
		return false;
	}

/*	private void nowAskQuestions() {
		for(int i=0;i<7;i++) {
			System.out.print(lisa.questionNum);
			
			chat.setText(lisa.askQuestion());
			
			lisa.saveResponse(textbox.getText());
		}
	*/	
		
		
			//System.out.println(lisa.askQuestion());
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
	

	

