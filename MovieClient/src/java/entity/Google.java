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
public class Google {
    private String title;
    private String link;
    private String snippet;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public Google(String title, String link, String snippet) {
        this.title = title;
        this.link = link;
        this.snippet = snippet;
    }

    public Google() {
    }

    public String toString() {
        return "this is:" + getLink();
    }
}

