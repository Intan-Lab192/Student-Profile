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
import bean.ProfileBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ProfileBean> profileList =
                new ArrayList<ProfileBean>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM PROFILE";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                ProfileBean bean =
                        new ProfileBean();

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

                profileList.add(bean);
            }

            request.setAttribute(
                    "profileList",
                    profileList);

            request.getRequestDispatcher(
                    "viewProfiles.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    e.getMessage());
        }
    }
}