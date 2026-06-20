/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Intan
 */
import bean.ProfileBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {

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
                    "SELECT * FROM PROFILE "
                    + "WHERE STUDENTID = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, studentID);

            ResultSet rs =
                    ps.executeQuery();

            ProfileBean bean =
                    new ProfileBean();

            if (rs.next()) {

                bean.setStudentID(
                        rs.getString("STUDENTID"));

                bean.setName(
                        rs.getString("NAME"));

                bean.setProgramme(
                        rs.getString("PROGRAMME"));

                bean.setEmail(
                        rs.getString("EMAIL"));

                bean.setHobbies(
                        rs.getString("HOBBIES"));

                bean.setIntroduction(
                        rs.getString("INTRODUCTION"));
            }

            request.setAttribute(
                    "profile",
                    bean);

            request.getRequestDispatcher(
                    "editProfile.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error : " + e.getMessage());
        }
    }
}
