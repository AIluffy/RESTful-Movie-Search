/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import entity.AddJerseyClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author AI
 */
public class AddInfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String mwriter = request.getParameter("mwriter");
        String star = request.getParameter("star");
        String mtype = request.getParameter("mtype");
        String country = request.getParameter("country");
        String mlanguage = request.getParameter("mlanguage");
        String mrelease = request.getParameter("mrelease");
        String mlength = request.getParameter("mlength");      
        String mlink = request.getParameter("mlink");
        String description = request.getParameter("description");
        JSONObject list = new JSONObject();
         list.put("title", title);
         list.put("director", director);
         list.put("mwriter", mwriter);
         list.put("star", star);
         list.put("mtype", mtype);
         list.put("country", country);
         list.put("mlanguage", mlanguage);
         list.put("mrelease", mrelease);
         list.put("mlength", mlength);
         list.put("mlink", mlink);
         list.put("description", description);
         AddJerseyClient add = new AddJerseyClient();
         add.create_JSON(list.toString());
         
         request.getRequestDispatcher("addresult.html").forward(request, response);
         
         
    }
}
