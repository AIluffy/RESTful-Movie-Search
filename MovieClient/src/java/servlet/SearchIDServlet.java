/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import entity.Movie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author AI
 */
public class SearchIDServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
       String k = request.getParameter("keywords");
        String keywords = URLEncoder.encode(k, "utf-8");
        HttpURLConnection httpConnection = null;
        try {
            URL restServiceURL = new URL("http://localhost:8080/MovieRestfulServer/webresources/entity.movie/id/" + keywords);
            httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));
            String result = "", output;
            while ((output = responseBuffer.readLine()) != null) {
                result += output;
            }

            JSONArray array = JSONArray.fromObject(result);
            if (array != null && array.size() > 0) {
                List<Movie> movies = new ArrayList<Movie>();
                for (int i = 0; i < array.size(); i++) {
                    JSONObject json = array.getJSONObject(i);
                    Movie m = new Movie(json.getInt("id"),json.getString("title"), json.getString("director"), json.getString("mwriter"), json.getString("star"), json.getString("mtype"), json.getString("country"), json.getString("mlanguage"), json.getString("mrelease"), json.getString("mlength"), json.getString("mlink"), json.getString("description"));
                    movies.add(m);
                }

                request.setAttribute("movies", movies);
                request.getRequestDispatcher("movieDisplay.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }
    }
}
