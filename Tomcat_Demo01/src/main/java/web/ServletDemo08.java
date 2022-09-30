package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@WebServlet("/demo08")
public class ServletDemo08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get...");
        Map<String, String[]> map = req.getParameterMap();
        for(String key:map.keySet()){
            System.out.print(key+":");
            String[] values = map.get(key);
            for(String value:values){
                System.out.print(value+" ");
            }
            System.out.println();
        }

    }
}
