import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Lisa {
	private ArrayList<String>catchphrases;
	private ArrayList<String>responses;
	private ArrayList<String> questionList;
	private ArrayList<String> thesisList;
	private static int questionNum;
	private String question;
	public final static String PATH_PREFIX = "res/images/";
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


public Lisa() {
	catchphrases = new ArrayList<String>();
	catchphrases.add("If anyone wants me, I'll be in my room!");
	catchphrases.add("I feel like a (second name)");
	responses= new ArrayList<String>();
	//responses.add("health Effects of Music");
	//responses.add("listening to favorite music is good for health");
	//responses.add("music reduces stress");
	//responses.add("trials revealed that it relieves pain");
	//responses.add("individuals can respond differenty to the same piece of music");
	
	thesisList= new ArrayList<String>();
	questionNum=0;
	question= "";
	questionList= new ArrayList<String>();
	questionList.add("What is your topic?");
	questionList.add("What is your main conclusion about this topic?");
	questionList.add("What is the main argument for your conclusion?");
    questionList.add("What is another good argument for your conclusion?");
	questionList.add("What is the main argument against your conlusion?");
    imgs=getImage("lisa.png");
}


public String askQuestion() {
	if(questionNum<questionList.size()) {
	question= questionList.get(questionNum);
	questionNum++;
	
	return question;
	}
	 makeThesis();
	 questionNum++;
	 return getThesisList();
}

public void makeThesis() {
	thesisList.add("Even though "+ responses.get(4)+ ","+ responses.get(1)+"because "+ responses.get(2)+ " and "+ responses.get(3) );
	thesisList.add(responses.get(1)+ " because "+ responses.get(2)+ " and "+ responses.get(3)+ ".");
	thesisList.add("Whereas "+responses.get(4)+ ", "+ responses.get(1)+ " given that "+ responses.get(2)+ ".");
	thesisList.add("Since "+ responses.get(2)+ " and "+ responses.get(3)+ ", "+ responses.get(1)+".");
	thesisList.add(responses.get(1)+" even though "+ responses.get(4)+ ".");

}



public void draw(Graphics g, int x, int y) {
	g.drawImage(imgs, x, y,200,400,null);
}

public void saveResponse(String s) {
	responses.add(s);
}

public ArrayList<String> getCatchphrasesList() {
	return catchphrases;
}

public ArrayList<String> getResponseList() {
	return responses;
}

public ArrayList<String> getQuestionList(){
	return questionList;
}
 
public int getQuestionNum() {
	return questionNum;
}

public String getThesisList(){
	String answer = "Here are some possible thesis options:  \n";
	for(int i=0; i<thesisList.size();i++) {
		answer+= (i+1) + ".) " + thesisList.get(i)+"\n";
	}
return answer;	
}


	
}



