/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AI
 */
@Entity
@Table(name = "movie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id = :id"),
    @NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title = :title"),
    @NamedQuery(name = "Movie.findByDirector", query = "SELECT m FROM Movie m WHERE m.director = :director"),
    @NamedQuery(name = "Movie.findByMwriter", query = "SELECT m FROM Movie m WHERE m.mwriter = :mwriter"),
    @NamedQuery(name = "Movie.findByStar", query = "SELECT m FROM Movie m WHERE m.star = :star"),
    @NamedQuery(name = "Movie.findByMtype", query = "SELECT m FROM Movie m WHERE m.mtype = :mtype"),
    @NamedQuery(name = "Movie.findByCountry", query = "SELECT m FROM Movie m WHERE m.country = :country"),
    @NamedQuery(name = "Movie.findByMlanguage", query = "SELECT m FROM Movie m WHERE m.mlanguage = :mlanguage"),
    @NamedQuery(name = "Movie.findByMrelease", query = "SELECT m FROM Movie m WHERE m.mrelease = :mrelease"),
    @NamedQuery(name = "Movie.findByMlength", query = "SELECT m FROM Movie m WHERE m.mlength = :mlength"),
    @NamedQuery(name = "Movie.findByMlink", query = "SELECT m FROM Movie m WHERE m.mlink = :mlink"),
    @NamedQuery(name = "Movie.findByDescription", query = "SELECT m FROM Movie m WHERE m.description = :description")})
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 50)
    @Column(name = "director")
    private String director;
    @Size(max = 50)
    @Column(name = "mwriter")
    private String mwriter;
    @Size(max = 70)
    @Column(name = "star")
    private String star;
    @Size(max = 30)
    @Column(name = "mtype")
    private String mtype;
    @Size(max = 20)
    @Column(name = "country")
    private String country;
    @Size(max = 20)
    @Column(name = "mlanguage")
    private String mlanguage;
    @Size(max = 20)
    @Column(name = "mrelease")
    private String mrelease;
    @Size(max = 10)
    @Column(name = "mlength")
    private String mlength;
    @Size(max = 100)
    @Column(name = "mlink")
    private String mlink;
    @Size(max = 300)
    @Column(name = "description")
    private String description;

    public Movie() {
    }

    public Movie(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ id=" + id + " ]";
    }
    
}
