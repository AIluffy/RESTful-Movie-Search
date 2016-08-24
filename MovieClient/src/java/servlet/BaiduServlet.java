/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Baidu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
public class BaiduServlet extends HttpServlet {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpURLConnection httpConnection = null;
        
  
        String k = request.getParameter("keywords");
//        String keywords = URLEncoder.encode("k", "utf-8");
        try {
            URL restServiceURL = new URL("http://images.baidu.com/i?tn=baiduimagejson&word=" +k+ "&pn=2&rn=20");
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
            List<Baidu> pic = new ArrayList<Baidu>();
            if (obj != null) {
                JSONArray array = obj.getJSONArray("data");
                if (array != null && array.size() > 0) {
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject json = array.getJSONObject(i);
                        Baidu b = new Baidu(json.optString("objURL"));
                        pic.add(b);
                    }
                }
            }
          
            request.setAttribute("baidu", pic);
            request.getRequestDispatcher("baidu.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpConnection.disconnect();
        }
    }

}
