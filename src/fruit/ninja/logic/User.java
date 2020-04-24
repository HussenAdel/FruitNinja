/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit.ninja.logic;

/**
 *
 * @author david
 */
public class User {
    
    
    private String name;
    private int scoreLevelOne;
    private int scoreLevelTwo;
    private int scoreLevelThree;
    private int scoreArcade;

    public User(String name, int scoreLevelOne, int scoreLevelTwo, int scoreLevelThree,int scoreArcade) {
        this.name = name;
        this.scoreLevelOne = scoreLevelOne;
        this.scoreLevelTwo = scoreLevelTwo;
        this.scoreLevelThree = scoreLevelThree;
        this.scoreArcade=scoreArcade;
    }

    public User() {
         this.name = new String();
        this.scoreLevelOne = 0;
        this.scoreLevelTwo = 0;
        this.scoreLevelThree = 0;
        this.scoreArcade=0;
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScoreLevelOne(int scoreLevelOne) {
        this.scoreLevelOne = scoreLevelOne;
    }

    public void setScoreLevelTwo(int scoreLevelTwo) {
        this.scoreLevelTwo = scoreLevelTwo;
    }

    public void setScoreLevelThree(int scoreLevelThree) {
        this.scoreLevelThree = scoreLevelThree;
    }

    public String getName() {
        return name;
    }

    public int getScoreLevelOne() {
        return scoreLevelOne;
    }

    public int getScoreLevelTwo() {
        return scoreLevelTwo;
    }

    public int getScoreLevelThree() {
        return scoreLevelThree;
    }
    
    
    
    public void setMaxScore(int level,int score){
        
        switch(level){
            
            case 1:
                if(score>this.scoreLevelOne)
                    scoreLevelOne=score;
                break;
                
               case 2:
                if(score>this.scoreLevelTwo)
                    scoreLevelTwo=score;
                break;     
                    
               
                case 3:
                if(score>this.scoreLevelThree)
                    scoreLevelThree=score;
                break;
                
               default:
                    if(score>this.scoreArcade)
                    scoreArcade=score;
                break;
        }
        
        
            
    }

    public int getScoreArcade() {
        return scoreArcade;
    }

         
    
    
      
            
}
