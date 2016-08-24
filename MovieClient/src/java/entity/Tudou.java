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
public class Tudou {
    private String title;
    private String tags;
    private String description;
    private String picUrl;
    private int totalTime;
    private String outerPlayerUrl;
    private String bigPicUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getOuterPlayerUrl() {
        return outerPlayerUrl;
    }

    public void setOuterPlayerUrl(String outerPlayerUrl) {
        this.outerPlayerUrl = outerPlayerUrl;
    }

    public String getBigPicUrl() {
        return bigPicUrl;
    }

    public void setBigPicUrl(String bigPicUrl) {
        this.bigPicUrl = bigPicUrl;
    }

    public Tudou(String title, String tags, String description, String picUrl, int totalTime, String outerPlayerUrl, String bigPicUrl) {
        this.title = title;
        this.tags = tags;
        this.description = description;
        this.picUrl = picUrl;
        this.totalTime = totalTime;
        this.outerPlayerUrl = outerPlayerUrl;
        this.bigPicUrl = bigPicUrl;
    }

    public Tudou() {
    }
    
    @Override
    public String toString() {
        return "Tudou" + getTitle();
    }
    

}