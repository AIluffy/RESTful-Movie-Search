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
public class Baidu {
    private String hoverURL;

    public String getHoverURL() {
        return hoverURL;
    }

    public void setHoverURL(String hoverURL) {
        this.hoverURL = hoverURL;
    }

    public Baidu(String hoverURL) {
        this.hoverURL = hoverURL;
    }
 
    public Baidu() {
    }
    
    public String toString(){
        return "Baidu"+ getHoverURL();
    }
}
