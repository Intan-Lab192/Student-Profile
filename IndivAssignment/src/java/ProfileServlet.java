/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bean.ProfileBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import bean.ProfileBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String name = request.getParameter("name");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String bio = request.getParameter("bio");

        ProfileBean bean = new ProfileBean();

        bean.setStudentID(studentId);
        bean.setName(name);
        bean.setProgramme(program);
        bean.setEmail(email);
        bean.setHobbies(hobbies);
        bean.setIntroduction(bio);

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO PROFILE "
                    + "(STUDENTID, NAME, PROGRAMME, EMAIL, HOBBIES, INTRODUCTION) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bean.getStudentID());
            ps.setString(2, bean.getName());
            ps.setString(3, bean.getProgramme());
            ps.setString(4, bean.getEmail());
            ps.setString(5, bean.getHobbies());
            ps.setString(6, bean.getIntroduction());

            ps.executeUpdate();

            request.setAttribute("reqName", bean.getName());
            request.setAttribute("reqStudentId", bean.getStudentID());
            request.setAttribute("reqProgram", bean.getProgramme());
            request.setAttribute("reqEmail", bean.getEmail());
            request.setAttribute("reqHobbies", bean.getHobbies());
            request.setAttribute("reqBio", bean.getIntroduction());

      request.getRequestDispatcher("profile.jsp")
        .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Error : " + e.getMessage()
            );
        }
    }
}
