/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Chart;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/**
 *
 * @author AI
 */
public class ChartServlet extends HttpServlet {

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
            URL restServiceURL = new URL("https://app.viralheat.com/social/api/sentiment?api_key=95k6Dfev5r6hgwniqzI&text=" + keywords + "&alt=json");
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
            JSONObject obj = JSONObject.fromObject(result);
            if (obj != null) {
                if(obj.getString("mood") != null && obj.getString("prob") != null){
                request.setAttribute("mood", obj.getString("mood"));
                request.setAttribute("prob", obj.getString("prob"));
                request.getRequestDispatcher("chart.jsp").forward(request, response);
                }else {
                request.getRequestDispatcher("response.html").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("response.html").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }
    }
}
