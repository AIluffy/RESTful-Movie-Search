/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Google;
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
public class GoogleServlet extends HttpServlet {

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
            URL restServiceURL = new URL("https://www.googleapis.com/customsearch/v1?key=AIzaSyDExqVOzsfLcE6D87mOAybLVWI1HAUP5zk&cx=006431901905483214390:i3yxhoqkzo0&num=10&alt=json&q=" + keywords);
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

            JSONObject obj = JSONObject.fromObject(result);
            List<Google> google = new ArrayList<Google>();
            if (obj != null) {
                JSONArray array = obj.getJSONArray("items");
                if (array != null && array.size() > 0) {
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject json = array.getJSONObject(i);
                        Google g = new Google(json.getString("title"), json.getString("link"), json.getString("snippet"));
                        google.add(g);
                    }
                }
                System.out.println("++++++++++++++++++++++++++++++++++" + google);
            }

            request.setAttribute("google", google);
            request.getRequestDispatcher("google.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }
    }
}


