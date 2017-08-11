<%@page import="java.util.HashMap"%>
<%@page import="org.jsoup.select.Evaluator.IsEmpty"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HashMap<String, String> player = (HashMap)request.getAttribute("player");
	boolean isEmpty = (boolean)request.getAttribute("isEmpty");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= player.get("firstname") +" "+player.get("lastname") %></title>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>
    <div class="action-list"></div>
	<div data-role="page" data-add-back-btn="true" data-theme="a">
		<div data-role="header">
			<h1>Player Details</h1>
		</div>
		<div data-role="content">
			<img src="http://<%= player.get("picture") %>" class="player-pic" width="240" onerror="myFunction(this)">
			<div class="player-details">
				<h1><%= player.get("firstname") +" "+player.get("lastname") %></h1>
				<h2>Number : #<%= player.get("number") %></h2>
				<h2>Position : <%= player.get("pos") %></h2>
			</div>

			<ul data-role="listview" data-inset="true" class="action-list">
				<li><h4>Height</h4><p><%= player.get("height") %></p></li>
				<li><h4>Weight</h4><p><%= player.get("weight") %></p></li>
				<li><h4>NBA Debut</h4><%= player.get("debut") %></p></li>
				<li><h4>From</h4><p><%= player.get("[from]") %></p></li>
				<li><h4>Birth Day</h4><p><%= player.get("born") %></p></li>
				<li><h4>Age</h4><p><%= player.get("age") %></p></li>
				<li>
					<a href="<%= player.get("website") %>" target="_blank">Website</a>
				</li>
				<li>
					<a href="https://www.youtube.com/results?search_query=
						<%= player.get("firstname") +"+"+player.get("lastname") %>"
						target="_blank">Vedio Link
					</a>
				</li>

				<!-- Player Data -->
				<section class="nba-player-season-career-stats">
					<table data-role="table" data-mode="columntoggle" class="ui-responsive ui-shadow" >
						<thead>
							<tr>
								<th><span>2016 - 17</span></th>
								<th data-priority="1" scope="col"><abbr title="Minutes Per Game">MPG</abbr></th>
								<th  data-priority="2"><abbr title="Field Goal Percentage">FG%</abbr></th>
								<th data-priority="6"><abbr title="Three Point Percentage">3P%</abbr></th>
								<th data-priority="7"><abbr title="Free Throw Percentage">FT%</abbr></th>
								<th data-priority="3"><abbr title="Points Per Game">PPG</abbr></th>
								<th data-priority="4"><abbr title="Rebounds Per Game">RPG</abbr></th>
								<th data-priority="5"><abbr title="Assists Per Game">APG</abbr></th>
								<th data-priority="8"><abbr title="Blocks Per Game">BPG</abbr></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">SEASON</th>
								<td>
									<%= isEmpty?"":player.get("mpg") %>
								</td>
								<td>
									<%= isEmpty?"":player.get("fg%") %>
								</td>
								<td>
									<%= isEmpty?"":player.get("3p%") %>
								</td>
								<td>
									<%= isEmpty?"":player.get("ft%") %>
								</td>
								<td>
									<%= isEmpty?"":player.get("ppg") %>
								</td>
								<td>
									<%= isEmpty?"":player.get("rpg") %>
								</td>
								<td>
									<%= isEmpty?"":player.get("apg") %>
								</td>	
								<td>
									<%= isEmpty?"":player.get("bpg") %>
								</td>
							</tr>
						</tbody>
					</table>
				</section>

			</ul>
		</div>
		<div data-role="footer" data-position="fixed" style="text-align:center;">
	    	<a href="Main" data-icon="home">Home</a>
	  	</div>
	</div>
<script>
	var myFunction = function (e) {
		this.onerror=null;
		e.src = "http://i.cdn.turner.com/nba/nba/.element/img/2.0/sect/statscube/players/large/default_nba_headshot_v2.png";
	}
</script>	
</body>
</html>