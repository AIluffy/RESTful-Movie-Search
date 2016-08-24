/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Tudou;
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
public class TudouServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String k = request.getParameter("keywords");
        String keywords = URLEncoder.encode(k, "utf-8");
        HttpURLConnection httpConnection = null;
        try {
            URL restServiceURL = new URL("http://api.tudou.com/v6/video/search?app_key=c0954f3cb05dc197&format=json&kw=" + keywords);
            httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream()), "UTF-8"));
            String result = "", output;
            while ((output = responseBuffer.readLine()) != null) {

                result += output;
            }
//            response.getWriter().write(result);
            // response.setCharacterEncoding("GBK");

            JSONObject obj = JSONObject.fromObject(result);
            List<Tudou> tMovies = new ArrayList<Tudou>();
            if (obj != null) {
                JSONArray array = obj.getJSONArray("results");
                if (array != null && array.size() > 0) {
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject json = array.getJSONObject(i);
                        Tudou m = new Tudou(json.getString("title"), json.getString("tags"), json.getString("description"), json.getString("picUrl"), json.getInt("totalTime"), json.getString("outerPlayerUrl"), json.getString("bigPicUrl"));
                        tMovies.add(m);
                    }
                }
            }
            request.setAttribute("tudou", tMovies);
            request.getRequestDispatcher("tudou.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }
    }

}
