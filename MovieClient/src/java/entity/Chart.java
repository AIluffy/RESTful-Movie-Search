/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author AI
 */
public class Chart {
    private String mood;
    private String prob;

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getProb() {
        return prob;
    }

    public void setProb(String prob) {
        this.prob = prob;
    }

    public Chart(String mood, String prob) {
        this.mood = mood;
        this.prob = prob;
    }
    
    public Chart() {
        
    }
    
    public String toString(){
        return "this is:" + getProb();
    }
}
