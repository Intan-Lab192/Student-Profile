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

@WebServlet("/DeleteProfileServlet")
public class DeleteProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String studentID =
                request.getParameter("studentID");

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "DELETE FROM PROFILE WHERE STUDENTID = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, studentID);

            ps.executeUpdate();

            response.sendRedirect("ViewProfileServlet");

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    e.getMessage());
        }
    }
}
