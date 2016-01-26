package com.example.astronomy101;
//you need the following imports in all Java Bridge apps
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.Image;
import com.google.appinventor.components.runtime.SpeechRecognizer;
import com.google.appinventor.components.runtime.TextToSpeech;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.TinyDB;
import java.util.ArrayList;
// same header for all apps
public class MainActivity extends Form implements HandlesEventDispatching
{
	//If your app requires special permissions, add the code like the following  to your Android_Manifest.xml file:
	//Camera: You need the camera permission to use the camera component. 
	//<uses-permission android:name="android.permission.CAMERA"/>
	// this app needs no special permissions
		
	// declare all your components as variables
	private ArrayList<String> questions;
	private ArrayList<String> imageFiles;
	private ArrayList<String> titles;
	private int index=0;
	private Button startButton;
	private Button nextButton;
	private Clock gameClock1;
	private Image image1;
	private Image image2;
	private Label qLabel1;  
	private Label timeLeftLabel;
	private Label timeLeftValueLabel;
	private Label scoreLabel;
	private Label scoreValueLabel;
	private Label titleLabel;
	private Label directionsLabel;
	private Label question1;
	private Label hsLabel;
	private Label hsValueLabel;
	private SpeechRecognizer recognizer1;
	private SpeechRecognizer recognizer2;
	private SpeechRecognizer recognizer3;
	private SpeechRecognizer recognizer4;
	private SpeechRecognizer recognizer5;
	private SpeechRecognizer recognizer6;
	private SpeechRecognizer recognizer7;
	private SpeechRecognizer recognizer8;
	private TextToSpeech speak1;
	private TinyDB tinyDB1;
	private VerticalArrangement vertArrangement;
	// $define is where you'll put code for initialization, so any properties you need set or code
	// that you'd put in Screen.Initialize for App Inventor
	protected void $define()
	{
		vertArrangement = new VerticalArrangement(this);
		titleLabel = new Label(vertArrangement);
		titleLabel.Text("Astronomy 101");
		titleLabel.FontBold();
		titleLabel.FontSize(35);
		titleLabel.Height(100);
		titleLabel.Width(1000);
		image2 = new Image(vertArrangement);
		image2.Picture("solar.gif");
		image2.Height(750);
		image2.Width(1200);
		directionsLabel = new Label(vertArrangement);
		directionsLabel.Text("This educational game teaches kids about the planets in our solar system. Once you press the start button, the player will be given a planet, and they will have to guess its name by saying it. If the player guesses the planet correct, information on the planet will be read and they will be given a point. Guess wrong and the player will be given no points, but will be given the chance to move on to the next planet. There is also a timer to show how much time you have left to answer each question. Answer all the questions to beat your high score. Good luck!");
		directionsLabel.FontSize(20);
		directionsLabel.Height(500);
		directionsLabel.Width(1100);
		gameClock1 = new Clock(this);
		titles = new ArrayList<String>();
		titles.add("Planet 1");
		titles.add("Planet 2");
		titles.add("Planet 3");
		titles.add("Planet 4");
		titles.add("Planet 5");
		titles.add("Planet 6");
		titles.add("Planet 7");
		titles.add("Planet 8");
		qLabel1 = new Label(vertArrangement);
		qLabel1.Text(titles.get(0));
		qLabel1.FontBold();
		qLabel1.FontSize(35);
		qLabel1.Height(150);
		qLabel1.Width(1000);
		qLabel1.Visible(false);
		questions = new ArrayList<String>();
		questions.add("This planet has the fastest orbit around the sun.What is it?");
		questions.add("This planet is covered with greenhouse gases. What is it?");
		questions.add("This planet is known as the Green Planet. What is it?");
		questions.add("This red planet has potential for human colonization. What is it?");
		questions.add("This is the biggest planet in our solar system. What is it?");
		questions.add("This planet is known for its massive rings. What is it?");
		questions.add("This planet is known for its tilted axis. What is it?");
		questions.add("This planet is the coldest of all. What is it?");
		imageFiles = new ArrayList<String>();
		imageFiles.add("mercury.gif");
		imageFiles.add("venus.gif");
		imageFiles.add("earth.gif");
		imageFiles.add("mars.gif");
		imageFiles.add("jupiter.gif");
		imageFiles.add("saturn.gif");
		imageFiles.add("uranus.jpg");
		imageFiles.add("neptune.gif");
		question1 = new Label(vertArrangement);
		question1.Text(questions.get(0));
		question1.FontSize(20);
		question1.Height(100);
		question1.Width(12000);
		question1.Visible(false);
		tinyDB1 = new TinyDB(this);
		hsLabel= new Label(vertArrangement);
		hsLabel.Text("High Score");
		hsLabel.BackgroundColor(COLOR_BLUE);
		hsLabel.FontBold();
		hsLabel.FontSize(20);
		hsLabel.Height(75);
		hsLabel.Width(300);
		hsValueLabel= new Label(vertArrangement);
		hsValueLabel.Text(tinyDB1.GetValue("High Score",0).toString());
		hsValueLabel.FontBold();
		hsValueLabel.FontSize(20);
		hsValueLabel.Height(75);
		hsValueLabel.Width(300);
		startButton = new Button(vertArrangement);
		startButton.BackgroundColor(COLOR_MAGENTA);
		startButton.Height(120);
		startButton.Width(150);
		startButton.Text("Start");
		startButton.TextAlignment(ALIGNMENT_CENTER);
		recognizer1 = new SpeechRecognizer(this);
		recognizer2 = new SpeechRecognizer(this);
		recognizer3 = new SpeechRecognizer(this);
		recognizer4 = new SpeechRecognizer(this);
		recognizer5 = new SpeechRecognizer(this);
		recognizer6 = new SpeechRecognizer(this);
		recognizer7 = new SpeechRecognizer(this);
		recognizer8 = new SpeechRecognizer(this);
		image1 = new Image(vertArrangement);
		image1.Picture(imageFiles.get(0));
		image1.Height(1100);
		image1.Width(1200);
		image1.Visible(false);
		timeLeftLabel= new Label(vertArrangement);
		timeLeftLabel.Text("Time Left");
		timeLeftLabel.BackgroundColor(COLOR_BLUE);
		timeLeftLabel.FontBold();
		timeLeftLabel.FontSize(20);
		timeLeftLabel.Height(75);
		timeLeftLabel.Width(300);
		timeLeftLabel.Visible(false);
		timeLeftValueLabel= new Label(vertArrangement);
		timeLeftValueLabel.Text("0");
		timeLeftValueLabel.Visible(false);
		scoreLabel= new Label(vertArrangement);
		scoreLabel.Text("Score:");
		scoreLabel.BackgroundColor(COLOR_MAGENTA);
		scoreLabel.FontBold();
		scoreLabel.FontSize(20);
		scoreLabel.Height(75);
		scoreLabel.Width(300);
		scoreValueLabel= new Label(vertArrangement);
		scoreValueLabel.Text("0");
		scoreLabel.Visible(false);
		scoreValueLabel.Visible(false);
		nextButton = new Button(vertArrangement);
		nextButton.Text("Next");
		nextButton.Height(100);
		nextButton.Width(300);
		nextButton.BackgroundColor(COLOR_YELLOW);
		nextButton.FontBold();
		nextButton.FontSize(17);
		nextButton.Visible(false);
		speak1 = new TextToSpeech(this);
		int score = Integer.parseInt(scoreValueLabel.Text());
		EventDispatcher.registerEventForDelegation( this, "Button", "Click" );
		EventDispatcher.registerEventForDelegation( this, "Clock", "Timer" );
		EventDispatcher.registerEventForDelegation( this, "SpeechRecognizer", "AfterGettingText" );
		EventDispatcher.registerEventForDelegation( this, "SpeechRecognizer", "AfterGettingText" );
	}
	public boolean dispatchEvent(Component component, String componentName, String eventName, Object[] params )
	{
		if( component.equals(startButton) && eventName.equals("Click") )
		{
			timeLeftValueLabel.Text("20");
			titleLabel.Visible(false);
			directionsLabel.Visible(false);
			hsLabel.Visible(false);
			hsValueLabel.Visible(false);
			startButton.Visible(false);
			image2.Visible(false);
			question1.Visible(true);
			qLabel1.Visible(true);
			image1.Visible(true);
			timeLeftLabel.Visible(true);
			timeLeftValueLabel.Visible(true);
			scoreLabel.Visible(true);
			scoreValueLabel.Visible(true);
			nextButton.Visible(true);
			recognizer1.GetText();
			return true;
		}
		if( component.equals(gameClock1) && eventName.equals("Timer") )
		{
			int count = Integer.parseInt(timeLeftValueLabel.Text());
			count = count - 1;
			timeLeftValueLabel.Text(String.valueOf(count));
			if (count==0) {
				gameClock1.TimerEnabled(false);
				timeLeftValueLabel.Text("Times up");
					}
			return true;
		}
		if( component.equals(nextButton) && eventName.equals("Click") )
		{
			gameClock1.TimerEnabled(true);
			timeLeftValueLabel.Text("20");
				index = index + 1;
				if (index == questions.size()) {
					index=0;
				}
				if (index == titles.size()) {
					index=0;
				}
				question1.Text(questions.get(index));
				qLabel1.Text(titles.get(index));
				image1.Picture(imageFiles.get(index));
				if (qLabel1.Text().contentEquals("Planet 2")){
					recognizer2.GetText();
				}
				if (qLabel1.Text().contentEquals("Planet 3")){
					recognizer3.GetText();
				}
				if (qLabel1.Text().contentEquals("Planet 4")){
					recognizer4.GetText();
				}
				if (qLabel1.Text().contentEquals("Planet 5")){
					recognizer5.GetText();
				}
				if (qLabel1.Text().contentEquals("Planet 6")){
					recognizer6.GetText();
				}
				if (qLabel1.Text().contentEquals("Planet 7")){
					recognizer7.GetText();
				}
				if (qLabel1.Text().contentEquals("Planet 8")){
					recognizer8.GetText();
					if (Integer.parseInt(scoreValueLabel.Text())>Integer.parseInt(hsValueLabel.Text())){
						tinyDB1.StoreValue("High Score", scoreValueLabel.Text());
			    }
					nextButton.Visible(false);
				}
				return true;
		}
		if( component.equals(recognizer1) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
			    if(result.contentEquals("mercury")){
			    	qLabel1.Text("Mercury");
			    	score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Sun-scorched Mercury is only slightly larger than Earth's moon. Like the moon, Mercury has very little atmosphere to stop impacts and it is covered with craters. Mercury's dayside is super-heated by the sun, but at night temperatures drop hundreds of degrees below freezing. Ice may even exist in craters.");
			    }
			    else{
		        	qLabel1.Text("Mercury");
		        	speak1.Speak("Incorrect, moving on");
		        }
			    if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("mercury")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	speak1.Speak("times up, moving on");
		        }
		        return true;
		}
		if( component.equals(recognizer2) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
		        if (result.contentEquals("Venus")){
		        	qLabel1.Text("Venus");
					score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Venus is the hottest and second planet in the solar system. Although Venus is not the planet closest to the sun, its dense atmosphere traps heat in a runaway version of the greenhouse effect that warms Earth. As a result, temperatures on Venus reach 870 degrees Fahrenheit (465 degrees Celsius), more than hot enough to melt led.");
		        }
		        else{
		        	qLabel1.Text("Venus");
		        	speak1.Speak("Incorrect, moving on");
		        }
		        if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("Venus")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	qLabel1.Text("Venus");
		        	speak1.Speak("times up, moving on");
		        }
				return true;
		}
		if( component.equals(recognizer3) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
		        if (result.contentEquals("earth")){
		        	qLabel1.Text("Earth");
					score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Earth is the third planet from the Sun and is the largest of the terrestrial planets. The Earth is the only planet in our solar system not to be named after a Greek or Roman deity. The Earth was formed approximately 4.54 billion years ago and is the only known planet to support life.");
		        }
		        else{
		        	qLabel1.Text("Earth");
		        	speak1.Speak("Incorrect, moving on");
		        }
		        if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("earth")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	qLabel1.Text("Earth");
		        	speak1.Speak("times up, moving on");
		        }
				return true;
		}
		if( component.equals(recognizer4) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
		        if (result.contentEquals("Mars")){
		        	qLabel1.Text("Mars");
					score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Mars is the fourth planet from our sun and is very cold. The average temperature on Mars is minus 80 degrees Fahrenheit -- way below freezing!Mars is rocky with canyons, volcanoes and craters all over it. Red dust covers almost all of Mars. It has clouds and wind, just as Earth does. Sometimes the wind blows the red dust into a dust storm.");
		        }
		        else{
		        	qLabel1.Text("Mars");
		        	speak1.Speak("Incorrect, moving on");
		        }
		        if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("Mars")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	qLabel1.Text("Mars");
		        	speak1.Speak("times up, moving on");
		        }
		        return true;
		}
		if( component.equals(recognizer5) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
		        if (result.contentEquals("Jupiter")){
		        	qLabel1.Text("Jupiter");
					score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Jupiter is the fifth planet and a giant gas planet. Its atmosphere is made up of mostly hydrogen gas and helium gas, just like the sun. The planet's surface is covered in thick red, brown, yellow and white clouds.One of Jupiter's most famous features is the Great Red Spot. It is a giant spinning storm, resembling a hurricane.Jupiter is a very windy planet. Winds range from 192 mph to more than 400 mph.");
		        }
		        else{
		        	qLabel1.Text("Jupiter");
		        	speak1.Speak("Incorrect, moving on");
		        }
		        if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("Jupiter")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	qLabel1.Text("Jupiter");
		        	speak1.Speak("times up, moving on");
		        }
		        return true;
		}
		if( component.equals(recognizer6) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
		        if (result.contentEquals("Saturn")){
		        	qLabel1.Text("Saturn");
					score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Saturn, the sixth planet, is a gas giant made up mostly of hydrogen and helium. Saturn is bigenough to hold more than 760 Earths, and is more massive than any other planet except Jupiter, roughly 95 times Earth's mass.Saturn's rings are believed to be debris left over from comets, asteroids or shattered moons. Although they extend thousands of miles from the planet, the main rings are typically only about 30 feet thick.");
		        }
		        else{
		        	qLabel1.Text("Saturn");
		        	speak1.Speak("Incorrect, moving on");
		        }
		        if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("Saturn")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	qLabel1.Text("Saturn");
		        	speak1.Speak("times up, moving on");
		        }
		        return true;
		}
		if( component.equals(recognizer7) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
		        if (result.contentEquals("Uranus")){
		        	qLabel1.Text("Uranus");
					score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Uranus is the seventh planet from the sun and the first to be discovered by scientists.Uranusis blue-green in color, the result of methane in its mostly hydrogen-helium atmosphere. The planet is often dubbed an ice giant, since 80 percent or more of its mass is made up of a fluid mix of water, methane, and ammonia ices. Its unusual axis might be due to a collision with a planet-size body, or several small bodies, soon after it was formed");
		        }
		        else{
		        	qLabel1.Text("Uranus");
		        	speak1.Speak("Incorrect, moving on");
		        }
		        if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("Uranus")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	qLabel1.Text("Uranus");
		        	speak1.Speak("times up, moving on");
		        }
		        return true;
		}
		if( component.equals(recognizer8) && eventName.equals("AfterGettingText") )
		{
			    String result = (String) params[0];
			    int score = Integer.parseInt(scoreValueLabel.Text());
		        if (result.contentEquals("Neptune")){
		        	qLabel1.Text("Neptune");
					score = score+1;
					scoreValueLabel.Text(String.valueOf(score));
					speak1.Speak("Correct!....Neptune, the eighth planet, was the first planet to get its existence predicted by mathematical calculations before it was actually seen through a telescope. Neptune's cloud cover has an especially vivid blue tint that is partly due to an as-yet-unidentified compound and the result of the absorption of red light by methane in the planets mostly hydrogen-helium atmosphere. Neptune's winds can reach up to 1,500 miles per hour, the fastest detected yet in the solar system.");
		        }
		        else{
		        	qLabel1.Text("Neptune");
		        	speak1.Speak("Incorrect, moving on");
		        }
		        if (timeLeftValueLabel.Text().contentEquals("Times up") && result.contentEquals("Neptune")){
		        	score=score-1;
		        	scoreValueLabel.Text(String.valueOf(score));
		        	qLabel1.Text("Neptune");
		        	speak1.Speak("times up, moving on");
		        }
				return true;
		}
		return false;
	}
}