/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author AI
 */
public class Movie {
    private int id;
    private String title;
    private String director;
    private String mwriter;
    private String star;
    private String mtype;
    private String country;
    private String mlanguage;
    private String mrelease;
    private String mlength;
    private String mlink;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMwriter() {
        return mwriter;
    }

    public void setMwriter(String mwriter) {
        this.mwriter = mwriter;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMlanguage() {
        return mlanguage;
    }

    public void setMlanguage(String mlanguage) {
        this.mlanguage = mlanguage;
    }

    public String getMrelease() {
        return mrelease;
    }

    public void setMrelease(String mrelease) {
        this.mrelease = mrelease;
    }

    public String getMlength() {
        return mlength;
    }

    public void setMlength(String mlength) {
        this.mlength = mlength;
    }

    public String getMlink() {
        return mlink;
    }

    public void setMlink(String mlink) {
        this.mlink = mlink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Movie(int id, String title, String director, String mwriter, String star, String mtype, String country, String mlanguage, String mrelease, String mlength, String mlink, String description) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.mwriter = mwriter;
        this.star = star;
        this.mtype = mtype;
        this.country = country;
        this.mlanguage = mlanguage;
        this.mrelease = mrelease;
        this.mlength = mlength;
        this.mlink = mlink;
        this.description = description;
    }
    public Movie() {
        
    }
    
    public String toString() {
        return "this is:" + getTitle();
    }
}
