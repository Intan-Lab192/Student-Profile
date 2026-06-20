/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Intan
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String studentID =
                request.getParameter("studentID");

        String name =
                request.getParameter("name");

        String programme =
                request.getParameter("programme");

        String email =
                request.getParameter("email");

        String hobbies =
                request.getParameter("hobbies");

        String introduction =
                request.getParameter("introduction");

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE PROFILE "
                    + "SET NAME=?, PROGRAMME=?, EMAIL=?, HOBBIES=?, INTRODUCTION=? "
                    + "WHERE STUDENTID=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, programme);
            ps.setString(3, email);
            ps.setString(4, hobbies);
            ps.setString(5, introduction);
            ps.setString(6, studentID);

            ps.executeUpdate();

            response.sendRedirect("ViewProfileServlet");

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    e.getMessage());
        }
    }
}
