package thebabycareproject;

import com.jfoenix.controls.JFXButton;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Label;
import static thebabycareproject.QuizMultipleChoicesController.quesMultipleChoice;
import static thebabycareproject.QuizFillInTheBlanksController.quesFillInTheBlanks;
import static thebabycareproject.QuizSelectController.quesSelect;
import static thebabycareproject.QuizWriteAnswerController.quesWriteAnswer;

/**
 * Controls QuizFillInTheBlanks, QuizMultipleChoices, QuizSelect, QuizWriteAnswer.
 * Creates questions for every type and subtype of quiz and stores the correct and user-provided answers,
 * maintains the fxmls for every quiz.
 * Generates random color for ' next ' button and vbox1 of every quiz and set and change the text color
 * of the question and the ' next ' button.
 * Provides function of ' go back ' or quit option for every quiz.
 * Clears the static and shared variables if quiz is completed or quitted.
 * @author 2018331059(Sabiha) ( Mentioned in the methods )
 * @author 2018331022(Owishi) ( Mentioned in the methods )
 * 
        FXML Paths(or subtype) of the types of Quiz Mentioned in the buttons of ' quiz fxml ' : 
Types of quiz = names of the button , varieties of questions. 
Subtypes of quiz = how is the quiz is being answered(choosing or writing etc). 
Shortcuts of the subtype:  Multiple Choice = m 
            Fill in the blanks = f 
            Select = s 
            Write Answer = w 

Paths of the types:  Alphabet &amp; Number - m  f 
        Math &amp; Geometry - m  f  w  s 
        Science - m 
        General Knowledge - m  w 
        Color &amp; Animal - m  f  s 
        Riddle - w 
        Random - m  f  w  s 
* For any type of question set like quesSelect or quesWriteAnswer (2d arrayList started with 'ques') 2nd String is 
* always the correct answer(String immediate after the question)
****/
public class QuizHandle {
    GoAndLoad gl = new GoAndLoad();
    static String type,nextpage,outOfScore;
    static String color="White";
    static int limit,i=0;
    static boolean load = false;
    static ArrayList<ArrayList<String> > correctAnswerList =  new ArrayList< >();
    static ArrayList<String> givenAnswer = new ArrayList< >();
    
    ArrayList<String> l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;      
    String[] s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15;
    QuizHandle(){
    }
    /**
     * Constructor
     * @param type type of quiz
     * outOfScore = total score for certain type of quiz
     * @author 2018331022(Owishi)
     */
    QuizHandle(String type){
        QuizHandle.type = type;
        if("random".equals(type))QuizHandle.outOfScore = " out of 30";
        else QuizHandle.outOfScore = " out of 15";
    }
    
    /**
     * Controlling method for QuizMultipleChoicesController, loads certain questions for certain type of quiz
     * @author 2018331022(Owishi)
     */
    void callMultipleChoices(){
        if(null != QuizHandle.type)
            switch (QuizHandle.type) {
            case "alphaNum":
                limit = 9;// limit porjotno pouchale next page e jabe
                QuizHandle.nextpage = "quizFillInTheBlanks";//erpor jetay jabe
                alphaNumMultipleChoices();//ekhon jetay ase
                break;
            case "mathGeo":
                limit = 4;
                QuizHandle.nextpage = "quizFillInTheBlanks";
                mathGeoMultipleChoices();
                break;
            case "science":
                limit = 15;
                QuizHandle.nextpage = "quizResult";
                scienceMultipleChoices();
                break;
            case "generalKnowledge":
                limit = 9;
                QuizHandle.nextpage = "quizWriteAnswer";
                gkMultipleChoices();
                break;
            case "colorAnimal":
                limit = 4;
                QuizHandle.nextpage = "quizFillInTheBlanks";
                colorAnimalMultipleChoices();    
                break;
            case "random":
                limit = 5;
                QuizHandle.nextpage = "quizFillInTheBlanks";
                randomMultipleChoices();    
                break;
            default:
                break;
        }
    }
    
    /**
     * Creates question and answer for type Alphabet &amp; Number, subtype m
     * @author 2018331059(Sabiha)
     */
    void alphaNumMultipleChoices(){
        s1 = new String[] {"What is the 2nd letter of English alphabet?","B","A","C","D"};
        s2 = new String[] {"Count backwards - 100, 99, 98, _","97","95","96","101"};
        s3 = new String[] {"How many letters does the English alphabet have?","26","25","24","20"};
        s4 = new String[] {"What is the lowercase letter of 'Q'?","q","v","s","r"};
        s5 = new String[] {"What comes after 9?","10","11","8","7"};
        s6 = new String[] {"Fill in the missing letter-> L, M, N, _ , P","O","K","Q","S"};
        s7 = new String[] {"What is the last letter of English alphabet?","Z","A","K","D"};
        s8 = new String[] {"2 X 2 = ?","4","6","9","5"};
        s9 = new String[] {"What is the uppercase letter of 'a'?","A","Q","R","M"};        
        
        l1 = new ArrayList<>(Arrays.asList(s1));
        l2 = new ArrayList<>(Arrays.asList(s2));
        l3 = new ArrayList<>(Arrays.asList(s3));
        l4 = new ArrayList<>(Arrays.asList(s4));
        l5 = new ArrayList<>(Arrays.asList(s5));
        l6 = new ArrayList<>(Arrays.asList(s6));
        l7 = new ArrayList<>(Arrays.asList(s7));
        l8 = new ArrayList<>(Arrays.asList(s8));
        l9 = new ArrayList<>(Arrays.asList(s9));
        
        quesMultipleChoice.add(l1);
        quesMultipleChoice.add(l2);
        quesMultipleChoice.add(l3);
        quesMultipleChoice.add(l4);
        quesMultipleChoice.add(l5);
        quesMultipleChoice.add(l6);
        quesMultipleChoice.add(l7);
        quesMultipleChoice.add(l8);
        quesMultipleChoice.add(l9);       
    }
    
    /**
     * Creates question and answer for type Math &amp; Geometry, subtype m
     * @author 2018331059(Sabiha)
     */
    void mathGeoMultipleChoices(){
        s1 = new String[] {"15 X 16 = ?","240","200","220","250"};
        s2 = new String[] {"Which of the statements is true?","12 X 15 = 180","1223 + 12233 = 12456",
            "9 is divisable by 12","777 - 89 = 678"};
        s3 = new String[] {"I am a flat shape. I have 3 corners. I have 3 sides.\nWho am I?",
            "Triangle","Rectangle","Square","Circle"};   
        s4 = new String[] {"( 10 + 3 ) X 3 = ?","39","69","29","33"};
        
        l1 = new ArrayList<>(Arrays.asList(s1));
        l2 = new ArrayList<>(Arrays.asList(s2));
        l3 = new ArrayList<>(Arrays.asList(s3));
        l4 = new ArrayList<>(Arrays.asList(s4));
        
        quesMultipleChoice.add(l1);
        quesMultipleChoice.add(l2);
        quesMultipleChoice.add(l3);
        quesMultipleChoice.add(l4);
    }
    
    /**
     * Creates question and answer for type Science, subtype m
     * @author 2018331059(Sabiha)
     */
    void scienceMultipleChoices(){
        s1 = new String[] {"Which part of the bird lets it fly high in the sky?","Wings","Beak","Feet","Claws"};
        s2 = new String[] {"What is closest planet to sun?","Mercury","Mars","Saturn","Venus"};
        s3 = new String[] {"Select the false","Average human body can survive without water for a few weeks",
            "Water is made of two elements","The solid state of water is known as ice",
            "Water covers more than 70% of the world's surface"};
        s4 = new String[] {"What is the only metal that is liquid in room temparature?","Mercury","Sodium","Gold","Plutinum"};
        s5 = new String[] {"What planet do we live on?","Earth","Saturn","Mars","The Sun"};
        s6 = new String[] {"What is the biggest organ of human body?","Skin","Brain","Liver","Kidney"};
        s7 = new String[] {"Largest planet in the solar system-","Jupiter","Saturn","Venus","Mars"};
        s8 = new String[] {"Which item is nonliving?","Rock","Cat","Snail","Tree"};
        s9 = new String[] {"Which star shines during the day?","The Sun","Moon","Mars","Big Dipper"};
        s10 = new String[] {"What is the second most common gas found in the air we breathe?","Oxygen","Nitrogen",
            "Carbon dioxide","Helium"};
        s11 = new String[] {"Which one of these is NOT a mineral?","Lithium","Quartz","Diamond","Calcite"};
        s12 = new String[] {"How old is the Earth approximately?","4.5 billion years ","50,000 years","300 million years","no one knows"};
        s13 = new String[] {"What could you change the shape of by pushing?","sand castle","glass cup","rock","metal toy car"};
        s14 = new String[] {"What is closest planet to earth?","Neptune","Mars","Saturn","Marcury"};
        s15 = new String[] {"How long does it take Earth to revolve around the Sun?","1 year","1 month","1 week","1 day"};
        
        l1 = new ArrayList<>(Arrays.asList(s1));
        l2 = new ArrayList<>(Arrays.asList(s2));
        l3 = new ArrayList<>(Arrays.asList(s3));
        l4 = new ArrayList<>(Arrays.asList(s4));
        l5 = new ArrayList<>(Arrays.asList(s5));
        l6 = new ArrayList<>(Arrays.asList(s6));
        l7 = new ArrayList<>(Arrays.asList(s7));
        l8 = new ArrayList<>(Arrays.asList(s8));
        l9 = new ArrayList<>(Arrays.asList(s9));
        l10 = new ArrayList<>(Arrays.asList(s10));
        l11 = new ArrayList<>(Arrays.asList(s11));
        l12 = new ArrayList<>(Arrays.asList(s12));
        l13 = new ArrayList<>(Arrays.asList(s13));
        l14 = new ArrayList<>(Arrays.asList(s14));
        l15 = new ArrayList<>(Arrays.asList(s15));        
        
        quesMultipleChoice.add(l1);
        quesMultipleChoice.add(l2);
        quesMultipleChoice.add(l3);
        quesMultipleChoice.add(l4);
        quesMultipleChoice.add(l5);
        quesMultipleChoice.add(l6);
        quesMultipleChoice.add(l7);
        quesMultipleChoice.add(l8);
        quesMultipleChoice.add(l9);
        quesMultipleChoice.add(l10);
        quesMultipleChoice.add(l11);
        quesMultipleChoice.add(l12);
        quesMultipleChoice.add(l13);
        quesMultipleChoice.add(l14);
        quesMultipleChoice.add(l15);
    }
    
    /**
     * Creates question and answer for type General Knowledge, subtype m
     * @author 2018331059(Sabiha)
     */
     void gkMultipleChoices(){
        s1 = new String[] {"How many continents are there in the world?","7","8","9","10"};
        s2 = new String[] {"How many months do we have in a year?","12","13","14","11"};
        s3 = new String[] {"How many days are there in a year?","365","366","367","364"};
        s4 = new String[] {"How many days are there in leap a year?","366","367","364","365"};
        s5 = new String[] {"Which animal is known as the ‘Ship of the Desert?’","Camel","Ostrich",
            "Elephant","Eagle"};
        s6 = new String[] {"How many days do we have in a week?","7","8","9","10"};
        s7 = new String[] {"How many colors are there in a rainbow?","7","8","9","10"};//////////////////////////////
        s8 = new String[] {"In which direction does the sun rise?","East","West","South","North"};
        s9 = new String[] {"Which is the largest mammal?","Blue Whale","Shark","Rhinoceros","Elephant"};        
        
        l1 = new ArrayList<>(Arrays.asList(s1));
        l2 = new ArrayList<>(Arrays.asList(s2));
        l3 = new ArrayList<>(Arrays.asList(s3));
        l4 = new ArrayList<>(Arrays.asList(s4));
        l5 = new ArrayList<>(Arrays.asList(s5));
        l6 = new ArrayList<>(Arrays.asList(s6));
        l7 = new ArrayList<>(Arrays.asList(s7));
        l8 = new ArrayList<>(Arrays.asList(s8));
        l9 = new ArrayList<>(Arrays.asList(s9));
        
        quesMultipleChoice.add(l1);
        quesMultipleChoice.add(l2);
        quesMultipleChoice.add(l3);
        quesMultipleChoice.add(l4);
        quesMultipleChoice.add(l5);
        quesMultipleChoice.add(l6);
        quesMultipleChoice.add(l7);
        quesMultipleChoice.add(l8);
        quesMultipleChoice.add(l9);       
    }
     
    /**
      * Creates question and answer for type Color &amp; Animal, subtype m
      * @author 2018331059(Sabiha)
     */
    void colorAnimalMultipleChoices(){
        s1 = new String[] {"Which one is the slowest mammal in the world?","Sloth","Panda","Mouse ","Pig"};
        s2 = new String[] {"What is the color of healthy grass?","Green","Gray","Red","Blue"};
        s3 = new String[] {"Select the truth","Bees have 2 pairs of wings","A spider has 9 legs",
            "Bat is a bird","Cats spend an average of 6 to 7 hours a day sleeping"};
        s4 = new String[] {"Yellow color + Blue color = ?","Green",
            "Orange","Black","Dark Blue"};
        
        l1 = new ArrayList<>(Arrays.asList(s1));
        l2 = new ArrayList<>(Arrays.asList(s2));
        l3 = new ArrayList<>(Arrays.asList(s3));
        l4 = new ArrayList<>(Arrays.asList(s4));
       
        quesMultipleChoice.add(l1);
        quesMultipleChoice.add(l2);
        quesMultipleChoice.add(l3);   
        quesMultipleChoice.add(l4); 
    }
     
    /**
      *  Creates question and answer for type Random, subtype m
      * @author 2018331022(Owishi)
     */
    void randomMultipleChoices(){
         alphaNumMultipleChoices();
         mathGeoMultipleChoices();
         scienceMultipleChoices();
         gkMultipleChoices();
         colorAnimalMultipleChoices();       
    }
     
    /**
      * Controlling method for QuizFillInTheBlanksController, loads certain questions for certain type of quiz
      * @author 2018331022(Owishi)
     */
    void callFillInTheBlanks(){
        if(null != QuizHandle.type)switch (QuizHandle.type) {
            case "alphaNum":
                limit = 2;
                QuizHandle.nextpage = "quizResult";//shesh
                QuizController.on=false;
                alphaNumFillInTheBlanks();
                break;
            case "mathGeo":
                limit = 2;
                QuizHandle.nextpage = "quizWriteAnswer";
                mathGeoFillInTheBlanks();
                break;
            case "colorAnimal":
                limit = 1;
                QuizHandle.nextpage = "quizSelect";
                colorAnimalFillInTheBlanks();
                break;
            case "random":
                limit = 5;
                QuizHandle.nextpage = "quizWriteAnswer";
                randomFillInTheBlanks();
                break;
            default:
                break;
        }
    }
    
    /**
     * Creates question and answer for type Alphabet &amp; Number, subtype f
     * @author 2018331059(Sabiha)
     */
    void alphaNumFillInTheBlanks(){
        s9 = new String[] {"What are these?","horse","cow","rabbit"};//fill in the blanks
        s10 = new String[] {"What are these?","tomato","egg","apple"};//fill in the blanks

        l9 = new ArrayList<>(Arrays.asList(s9));
        l10 = new ArrayList<>(Arrays.asList(s10));
        
        quesFillInTheBlanks.add(l9);
        quesFillInTheBlanks.add(l10);
    }   
    
    /**
     * Creates question and answer for type Math &amp; Geometry, subtype f
     * @author 2018331059(Sabiha)
     */
    void mathGeoFillInTheBlanks(){
        s4 = new String[] {"Name their shapes.","cube","cylinder","cone"};
        s5= new String[] {"Name their shapes.","hexagon","octagon","ellipse"};

        l4 = new ArrayList<>(Arrays.asList(s4));
        l5 = new ArrayList<>(Arrays.asList(s5));
        
        quesFillInTheBlanks.add(l4);
        quesFillInTheBlanks.add(l5);
    }
    
    /**
     * Creates question and answer for type Color &amp; Animal, subtype f
     * @author 2018331059(Sabiha) 
     */
    void colorAnimalFillInTheBlanks(){
        s5 = new String[] {"Name these animals.","rhinoceros","turtle","crab"};
        
        l5 = new ArrayList<>(Arrays.asList(s5));
       
        quesFillInTheBlanks.add(l5);    
    }
    
    /**
     * Creates question and answer for type Random, subtype f
     * @author 2018331022(Owishi)
     */
    void randomFillInTheBlanks(){
        alphaNumFillInTheBlanks();
        mathGeoFillInTheBlanks();
        colorAnimalFillInTheBlanks();
    }
    
    /**
      * Controlling method for QuizWriteAnswerController, loads certain questions for certain type of quiz
      * @author 2018331022(Owishi)
      */
    void callWriteAnswer(){
        if(null != QuizHandle.type)switch (QuizHandle.type) {
            case "mathGeo":
                limit = 3;
                QuizHandle.nextpage = "quizSelect";
                mathGeoWriteAnswer();
                break;
            case "generalKnowledge":
                limit = 6;
                QuizHandle.nextpage = "quizResult";//shesh
                QuizController.on=false;
                gkWriteAnswer();
                break;
            case "riddles":
                limit = 15;
                QuizHandle.nextpage = "quizResult";//shesh
                QuizController.on=false;
                riddlesWriteAnswer();
                break;
            case "random":
                limit = 5;
                QuizHandle.nextpage = "quizSelect";
               randomWriteAnswer();
                break;
            default:
                break;
        }
    }
    
    /**
     * Creates question and answer for type Math &amp; Geometry, subtype w
     * @author 2018331059(Sabiha)  
     */
    void mathGeoWriteAnswer(){
        s6 = new String[] {"How many balls are here?","8","ball"};//shuruta num thakle oi num onujai chobi set
        s7 = new String[] {"Type 'i' 7 times.","iiiiiii"};//shurute text thakle shomossha nai
        s8 = new String[] {"Ariana had 10 candies. She ate 3 of them\n"
                + "How many candies are left?","7","candy"};
        
        l6 = new ArrayList<>(Arrays.asList(s6));
        l7 = new ArrayList<>(Arrays.asList(s7));
        l8 = new ArrayList<>(Arrays.asList(s8));
        
        quesWriteAnswer.add(l7);
        quesWriteAnswer.add(l6);
        quesWriteAnswer.add(l8);
    }
    
    /**
     * Creates question and answer for type General Knowledge, subtype w
     * @author 2018331059(Sabiha) 
     */
    void gkWriteAnswer(){
        s10 = new String[] {"Which place is known as the roof of the world?","Tibet"};
        s11 = new String[] {"Which is the tallest mountain in the world?","Mount Everest"};
        s12 = new String[] {"Which planet is known as the Red Planet?","Mars"};
        s13 = new String[] {"What is the principal source of energy for earth?","Sun"};
        s14 = new String[] {"You smell with your _?","Nose"};
        s15 = new String[] {"How many primes color are there?\nWrite in numbers","3","rainbow"};
        
        l10 = new ArrayList<>(Arrays.asList(s10));
        l11 = new ArrayList<>(Arrays.asList(s11));
        l12 = new ArrayList<>(Arrays.asList(s12));
        l13 = new ArrayList<>(Arrays.asList(s13));
        l14 = new ArrayList<>(Arrays.asList(s14));
        l15 = new ArrayList<>(Arrays.asList(s15));
        
        quesWriteAnswer.add(l10);
        quesWriteAnswer.add(l11);
        quesWriteAnswer.add(l12);
        quesWriteAnswer.add(l13);
        quesWriteAnswer.add(l14);
        quesWriteAnswer.add(l15);
    }
    
    /**
     * Creates question and answer for type Riddles, subtype w
     * @author 2018331022(Owishi) 
     */
     void riddlesWriteAnswer(){
        s1 = new String[] {"What five-letter word becomes shorter when you add two letters to it?","Shorter"};
        s2 = new String[] {"Where can you find cities, towns, shops, and streets but people?","Map"};
        s3 = new String[] {"Mary has four daughters, and each of her daughters has a brother."
                + "\nHow many children does Mary have? (Write numbers only)","5"};
        s4 = new String[] {"What is always in front of you but can’t be seen?","Future"};
        s5 = new String[] {"What has a neck but no head?","Bottle"};
        s6 = new String[] {"What word is spelled wrong in the dictionary?","Wrong"};
        s7 = new String[] {"What is full of holes but still holds water?","Sponge"};
        s8 = new String[] {"What is easy to get into but hard to get out of?","Snail"};
        s9 = new String[] {"David’s parents have three sons: Snap, Crackle and…?","David"};
        s10 = new String[] {"I am an odd number. Take away a letter and I become even.\n"
                + "What number am I? (Write down numbers only)","7"} ;
        s11 = new String[] {" A word I know, six letters it contains, remove one letter and 12\n"
                + "remains, what is it?","Dozens"};
        s12 = new String[] {"What begins with an E but only has one letter?","Envelope"};
        s13 = new String[] {"Where does success come before work?","Dictionary"};
        s14 = new String[] {"What begins with T, finishes with T, and has T in it?","Teapot"};
        s15 = new String[] {"I’m tall when I’m young, and I’m short when I’m old, what am I?","Candle"};
        
        l1 = new ArrayList<>(Arrays.asList(s1));
        l2 = new ArrayList<>(Arrays.asList(s2));
        l3 = new ArrayList<>(Arrays.asList(s3));
        l4 = new ArrayList<>(Arrays.asList(s4));
        l5 = new ArrayList<>(Arrays.asList(s5));
        l6 = new ArrayList<>(Arrays.asList(s6));
        l7 = new ArrayList<>(Arrays.asList(s7));
        l8 = new ArrayList<>(Arrays.asList(s8));
        l9 = new ArrayList<>(Arrays.asList(s9));
        l10 = new ArrayList<>(Arrays.asList(s10));
        l11 = new ArrayList<>(Arrays.asList(s11));
        l12 = new ArrayList<>(Arrays.asList(s12));
        l13 = new ArrayList<>(Arrays.asList(s13));
        l14 = new ArrayList<>(Arrays.asList(s14));
        l15 = new ArrayList<>(Arrays.asList(s15));        
        
        quesWriteAnswer.add(l1);
        quesWriteAnswer.add(l2);
        quesWriteAnswer.add(l3);
        quesWriteAnswer.add(l4);
        quesWriteAnswer.add(l5);
        quesWriteAnswer.add(l6);
        quesWriteAnswer.add(l7);
        quesWriteAnswer.add(l8);
        quesWriteAnswer.add(l9);
        quesWriteAnswer.add(l10);
        quesWriteAnswer.add(l11);
        quesWriteAnswer.add(l12);
        quesWriteAnswer.add(l13);
        quesWriteAnswer.add(l14);
        quesWriteAnswer.add(l15);
    }
     
    /**
     * Creates question and answer for type Random, subtype w
     * @author 2018331022(Owishi)  
     */
    void randomWriteAnswer(){
        mathGeoWriteAnswer();
        gkWriteAnswer();
        riddlesWriteAnswer();
    }
    
    /**
     * Controlling method for QuizSelectController, loads certain questions for certain type of quiz
     * @author 2018331022(Owishi)
     */
    void callSelect(){
        if(null != QuizHandle.type)switch (QuizHandle.type) {
            case "mathGeo":
                limit = 2;
                QuizHandle.nextpage = "quizResult";//shesh
                QuizController.on=false;
                mathGeoSelect();
                break;
            case "colorAnimal":
                limit = 8;
                QuizHandle.nextpage = "quizResult";//shesh
                QuizController.on=false;
                colorAnimalSelect();
                break;
            case "random":
                limit = 5;
                QuizHandle.nextpage = "quizResult";//shesh
                QuizController.on=false;
                randomSelect();
                break;
            default:
                break;
        }
    }
    
    /**
     * Creates question and answer for type General Knowledge, subtype s
     * @author 2018331022(Owishi) 
     */
    void mathGeoSelect(){
        s9 = new String[] {"Identify pentagon","pentagon","triangle","square","circle"};
        s10 = new String[] {"Identify circle","circle","triangle","square","pentagon"};

        l9 = new ArrayList<>(Arrays.asList(s9));
        l10 = new ArrayList<>(Arrays.asList(s10));
        
        quesSelect.add(l9);
        quesSelect.add(l10);
    }
    
    /**
     * Creates question and answer for type Color &amp; Animal, subtype s
     * @author 2018331059(Sabiha) 
     * @author 2018331022(Owishi)
     */
     void colorAnimalSelect(){
        s6 = new String[] {"Choose the red bar.","red","blue","dark blue","green"};
        s7 = new String[] {"I swim under the water every day. At Sea World you can watch me play.\n" +
            "I am smooth and my skin is gray. My voice is squeaky, some would say.\n" +
            "Who am I? Choose me!","dolphin","octopus","snake","cat"};      
        s8 = new String[] {"Which one is a bird? Click on the bird.","bird","lion","monkey","bee"};
        s9 = new String[] {"I can be big or small.I love to play and chase a ball. When you pat me\n"
                + "I wag my tail. I bark when the man comes with the mail.\n"
                +"Who am I? Choose me!","dog","elephant","octopus","cat"};
        s10 = new String[] {"Select the 'green and yellow' candy.","green and yellow candy",
            "purple and blue candy","red and white candy","yellow candy"};
        s11 = new String[] {"I am a common sight in nearly every zoo,\n" 
                +"I can even do some of the things that humans do.\n" 
                +"I come in many colors and am always rather furry,\n"
                +"I can swing through the trees in a mighty big hurry.\n"
                + "Who am I? Choose me!","monkey","dog","elephant","lion"};  
        s12 = new String[] {"Select the green hat","green hat","blue and red hat","orange hat","yellow hat"};
        s13 = new String[] {"Select the purple flower","purple flower","red flower",
            "yellow flower","pink flower"};
        s14 = new String[] {"Select the yellow bear","yellow bear","butterfly","duck","pink bear"};
       
        l6 = new ArrayList<>(Arrays.asList(s6));
        l7 = new ArrayList<>(Arrays.asList(s7));
        l8 = new ArrayList<>(Arrays.asList(s8));
        l9 = new ArrayList<>(Arrays.asList(s9));
        l10 = new ArrayList<>(Arrays.asList(s10));
        l11 = new ArrayList<>(Arrays.asList(s11));
        l12 = new ArrayList<>(Arrays.asList(s12));
        l13 = new ArrayList<>(Arrays.asList(s13));
        l14 = new ArrayList<>(Arrays.asList(s14));
       
        quesSelect.add(l6);
        quesSelect.add(l7);
        quesSelect.add(l8);
        quesSelect.add(l9);
        quesSelect.add(l10);
        quesSelect.add(l11);
        quesSelect.add(l12);
        quesSelect.add(l13);
        quesSelect.add(l14);
    }
     
    /**
      * Creates question and answer for type Random, subtype s
      * @author 2018331022(Owishi) 
     */
    void randomSelect(){
        mathGeoSelect();
        colorAnimalSelect();
    }

    /**
     * 
     * @return Color randomly generated color
     * @author 2018331022(Owishi) 
     */
    Color generateLightColor() {
        int randomNum = ThreadLocalRandom.current().nextInt(99, 256);
        int r = ThreadLocalRandom.current().nextInt(100, 256);
        int g = ThreadLocalRandom.current().nextInt(100, 256);
        int b = ThreadLocalRandom.current().nextInt(100, 256);
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }
    
    
    /**
     * @author 2018331022(Owishi) 
     */
    void clear(){
        QuizMultipleChoicesController.count=0;
        QuizMultipleChoicesController.quesMultipleChoice.clear();
        QuizFillInTheBlanksController.count=0;
        QuizFillInTheBlanksController.quesFillInTheBlanks.clear();        
        QuizWriteAnswerController.quesWriteAnswer.clear();
        QuizWriteAnswerController.count=0;
        QuizSelectController.quesSelect.clear();
        QuizSelectController.count=0;         
        QuizHandle.correctAnswerList.clear();
        QuizHandle.givenAnswer.clear();
        QuizController.on=false;
        QuizHandle.nextpage="";
        QuizHandle.load=false;
        QuizHandle.i=0;
    }
    
    /**
     * 
     * @param label question
     * @param next button
     * @author 2018331022(Owishi) 
     */
    void changeTextColor(Label label, JFXButton next){
        if("White".equals(QuizHandle.color)){
            label.setTextFill(javafx.scene.paint.Color.BLACK);
            next.setTextFill(javafx.scene.paint.Color.BLACK);
            QuizHandle.color="Black";
        }
        else {
            label.setTextFill(javafx.scene.paint.Color.WHITE);
            next.setTextFill(javafx.scene.paint.Color.WHITE);
            QuizHandle.color="White";
        }
    }
    
    /**
     * 
     * @param label question
     * @param next button
     * @author 2018331022(Owishi) 
     */
    void loadTextColor(Label label, JFXButton next){
        if("White".equals(QuizHandle.color)){
            label.setTextFill(javafx.scene.paint.Color.WHITE);
            next.setTextFill(javafx.scene.paint.Color.WHITE);
        }
        else {
            label.setTextFill(javafx.scene.paint.Color.BLACK);
            next.setTextFill(javafx.scene.paint.Color.BLACK);
        }
    }  
}
