/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.service;

import entity.Movie;
import java.net.URLDecoder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author AI
 */
@Stateless
@Path("entity.movie")
public class MovieFacadeREST extends AbstractFacade<Movie> {

    @PersistenceContext(unitName = "MovieRestfulServerPU")
    private EntityManager em;

    public MovieFacadeREST() {
        super(Movie.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Movie entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Short id, Movie entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Short id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Movie find(@PathParam("id") Short id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Movie> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Movie> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    //Extend method
    @GET
    @Path("title/{title}")
    @Produces({"application/json"})
    public List<Movie> find(@PathParam("title") String title) {
        return em.createNativeQuery("select * from movie where title like '%" + URLDecoder.decode(title) + "%'", Movie.class).getResultList();
    }

    @GET
    @Path("id/{id}")
    @Produces({"application/json"})
    public List<Movie> findId(@PathParam("id") String id) {
        return em.createNativeQuery("select * from movie where id =" + id, Movie.class).getResultList();
    }
}
