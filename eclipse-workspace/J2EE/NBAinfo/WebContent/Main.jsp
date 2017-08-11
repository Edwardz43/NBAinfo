<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	ResultSet rs = (ResultSet)request.getAttribute("rs");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>NBA</title>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<style>
.player-pic {
	float: left;
	padding-right: 10px;
	padding-bottom: 16px;
}

.player-details h3, .player-details p {
	margin-top: 8px;
	margin-bottom: 4px;
}

.action-list {
	clear: both;
}
</style>
</head>
<body>
<div data-role="page" data-theme="a">

<div data-role="header">
	<h1>Teams</h1>
</div>

<div data-role="content">
	<ul data-role="listview" data-filter="true">
   	<% while(rs.next()) {%>
		<li>
		<a href="Players?teamID=<%= rs.getString("teamID")%>"> 
			<img src="http://<%= rs.getString("logo")%>">
			<h2><%= rs.getString("name") %></h2>
            <h4><%= rs.getString("win") + " win " + rs.getString("loss") + " loss" %></h4>
		</a>
		</li>
	<% } %>
	</ul>
</div>
</div>
</body>
</html>