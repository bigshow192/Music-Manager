package com.example.musicmanager.controller;

import com.example.musicmanager.models.ConnectSql;
import com.example.musicmanager.models.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/ll")
    public String index(Model model) throws SQLException, ClassNotFoundException {
        List<Music> m= new ArrayList<>();
        ConnectSql s= new ConnectSql();
        Connection conn=s.conn();
        String sql= "Select * from Music";
        PreparedStatement ps= conn.prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        while (rs.next())
        {
            m.add(new Music(rs.getString(1),rs.getString(2),rs.getString(3)));

        }
        model.addAttribute("listm",m);
        return "index";
    }
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=MusicManager;"
            + "integratedSecurity=true;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "duy123456";
    @PostMapping("/test")
    public String addMusic(@ModelAttribute Music music, HttpServletRequest request)
    {
        String name=request.getParameter("name");
        String genre=request.getParameter("genre");
        String filename=request.getParameter("filename");
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql="INSERT INTO Music VALUES ('"+name+"','"+genre+"','"+filename+"')";
            stmt.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(name);


        return "redirect:/";

    }


}
