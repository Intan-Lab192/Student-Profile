<%-- 
    Document   : editProfile
    Created on : Jun 20, 2026, 3:56:29 PM
    Author     : Intan
--%>
<%@page import="bean.ProfileBean"%>

<%
    ProfileBean bean =
            (ProfileBean) request.getAttribute("profile");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>

    <link rel="stylesheet" href="css/style.css?v=3">
</head>

<body>

<div class="container">

    <div class="greeting-title">
        Edit Profile
    </div>

    <div class="cursive-text">
        Update your profile information
    </div>

    <form action="UpdateProfileServlet" method="post">

        <div class="form-group">
            <label>Student ID :</label>

            <input type="text"
                   name="studentID"
                   value="<%= bean.getStudentID() %>"
                   readonly>
        </div>

        <div class="form-group">
            <label>Name :</label>

            <input type="text"
                   name="name"
                   value="<%= bean.getName() %>"
                   required>
        </div>

        <div class="form-group">
            <label>Programme :</label>

            <input type="text"
                   name="programme"
                   value="<%= bean.getProgramme() %>"
                   required>
        </div>

        <div class="form-group">
            <label>Email :</label>

            <input type="email"
                   name="email"
                   value="<%= bean.getEmail() %>"
                   required>
        </div>

        <div class="form-group">
            <label>Hobbies :</label>

            <input type="text"
                   name="hobbies"
                   value="<%= bean.getHobbies() %>"
                   required>
        </div>

        <div class="form-group">
            <label>Introduction :</label>

            <textarea name="introduction" required><%= bean.getIntroduction() %></textarea>
        </div>

        <button type="submit" class="btn-pink">
            UPDATE PROFILE
        </button>

    </form>

    <a href="ViewProfileServlet">
        <button type="button" class="btn-pink">
            BACK TO PROFILES
        </button>
    </a>

</div>

</body>
</html>