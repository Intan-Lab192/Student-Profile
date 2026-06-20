<%-- 
    Document   : viewProfiles
    Created on : Jun 20, 2026, 11:27:34 AM
    Author     : Intan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.ProfileBean"%>

<%
    ArrayList<ProfileBean> profileList =
            (ArrayList<ProfileBean>) request.getAttribute("profileList");
%>

<!DOCTYPE html>
<html>
<head>
    <title>View All Profiles</title>

    <link rel="stylesheet" href="css/style.css?v=3">

    <style>

        .table-container{
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(255, 182, 193, 0.3);
            width: 95%;
            max-width: 1200px;
            border: 2px solid #ffe4e6;
        }

        .profile-table{
            width:100%;
            border-collapse: collapse;
            margin-top:20px;
        }

        .profile-table th{
            background-color:#ffb6c1;
            color:white;
            padding:12px;
            text-align:left;
        }

        .profile-table td{
            padding:12px;
            border-bottom:1px solid #ffe4e6;
            color:#4a4a4a;
        }

        .profile-table tr:hover{
            background-color:#fff7f8;
        }

        .search-box{
            width:70%;
            padding:10px;
            border:1px solid #ffccd5;
            border-radius:8px;
            font-family:'Poppins', sans-serif;
        }

        .search-btn{
            background-color:#ffb6c1;
            color:white;
            border:none;
            padding:10px 20px;
            border-radius:25px;
            cursor:pointer;
            font-weight:600;
        }

        .search-btn:hover{
            background-color:#ff9aa2;
        }

        .action-btn{
            text-decoration:none;
            display:inline-block;
            padding:8px 15px;
            border-radius:20px;
            color:white;
            margin:3px;
            font-size:14px;
            font-weight:600;
        }

        .edit-btn{
            background-color:#ffb6c1;
        }

        .edit-btn:hover{
            background-color:#ff9aa2;
        }

        .delete-btn{
            background-color:#ff758f;
        }

        .delete-btn:hover{
            background-color:#ff5c7a;
        }

        .back-link{
            text-decoration:none;
        }

    </style>

</head>

<body>

<div class="table-container">

    <div class="greeting-title">
        Student Profile Records
    </div>

    <div class="cursive-text">
        View, Search, Edit and Delete Profiles
    </div>

    <form action="SearchProfileServlet" method="post">

        <input type="text"
               name="keyword"
               class="search-box"
               placeholder="Search by Student ID or Name">

        <input type="submit"
               value="Search"
               class="search-btn">

    </form>

    <table class="profile-table">

        <tr>
            <th>Student ID</th>
            <th>Name</th>
            <th>Programme</th>
            <th>Email</th>
            <th>Hobbies</th>
            <th>Introduction</th>
            <th>Actions</th>
        </tr>

        <%
        if(profileList != null){

            for(ProfileBean bean : profileList){
        %>

        <tr>

            <td><%= bean.getStudentID() %></td>
            <td><%= bean.getName() %></td>
            <td><%= bean.getProgramme() %></td>
            <td><%= bean.getEmail() %></td>
            <td><%= bean.getHobbies() %></td>
            <td><%= bean.getIntroduction() %></td>

            <td>

                <a class="action-btn edit-btn"
                   href="EditProfileServlet?studentID=<%= bean.getStudentID() %>">
                    Edit
                </a>

                <a class="action-btn delete-btn"
                   href="DeleteProfileServlet?studentID=<%= bean.getStudentID() %>">
                    Delete
                </a>

            </td>

        </tr>

        <%
            }
        }
        %>

    </table>

    <br>

    <a href="index.html" class="back-link">
        <button type="button" class="btn-pink">
            Back To Form
        </button>
    </a>

</div>

</body>
</html>
