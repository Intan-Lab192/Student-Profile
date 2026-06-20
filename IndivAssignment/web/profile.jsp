<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : display
    Created on : May 21, 2026, 2:36:12 PM
    Author     : Intan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submitted Profile Information</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css?v=3"> <!-- for calling style.css folder -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"> <!-- For changing the font in the webpage -->
    </head>
    <body>
     <div class="container">
        <div class="greeting-title">
            Hi <%= request.getAttribute("reqName") %> <i class="fa-solid fa-heart accent-icon"></i>
        </div>
        <div class="greeting-title" style="margin-bottom: 10px;">nice to meet you !</div>"
        <div class="cursive-text">This is your information</div>
        
        <div class="profile-box">
            <div style="text-align: right; margin-bottom: 10px; color: #ff758f;"> 
                <i class="fa-regular fa-heart"></i>
                <i class="fa-regular fa-star"></i>
                <i class="fa-regular fa-wand-magic-sparkles"></i>
        </div>
            <table class="info-table">
                <tr>
                    <td class ="label-cell">Name:</td>
                    <td><%= request.getAttribute("reqName") %></td>
                </tr>
                <tr>
                    <td class ="label-cell">Student Id:</td>
                    <td><%= request.getAttribute("reqStudentId") %></td>
                </tr>
                <tr>
                    <td class ="label-cell">Program::</td>
                    <td><%= request.getAttribute("reqProgram") %></td>
                </tr>
                <tr>
                    <td class ="label-cell">Email:</td>
                    <td><%= request.getAttribute("reqEmail") %></td>
                </tr>
                <tr>
                    <td class ="label-cell">Hobbies:</td>
                    <td><%= request.getAttribute("reqHobbies") %></td>
                </tr>
                <tr>
                    <td class ="label-cell">Short Self Introduction:</td>
                    <td><%= request.getAttribute("reqBio") %></td>
                </tr>
            </table>
        </div>
                <br>
                <a href="index.html" style="text-decoration: none;">
                    <button type="button" class="btn-pink">Back</button>
                </a>
        </div>        
    </body>
</html>
