function getMeFollow() {
	if (getCookieValue("currentUser") == null) {
		window.location.href = "./index.html";
	}
	document.getElementById("mefollowtable").innerHTML = "";
	var xmlhttpRequest = new XMLHttpRequest();
	var url = "/Twister/FollowServlet?username="
			+ getCookieValue("currentUser") + "&flag=mefollow";
	xmlhttpRequest.open("get", url, true);
	xmlhttpRequest.send();
	xmlhttpRequest.onreadystatechange = function() {
		if (xmlhttpRequest.readyState == 4) {
			if (xmlhttpRequest.status == 200) {
				var msg = JSON.parse(xmlhttpRequest.responseText);
				var users = JSON.parse(msg.result);
				for ( var i in users) {
					if (users[i].length > 0) {
						var usera = users[i];
						for ( var j in usera) {
							var trElement = document.createElement('tr');
							var tdElementUser = document.createElement('td');
							var tdElementVisit = document.createElement('td');
							var tdElementUnfollow = document
									.createElement('td');

							trElement.appendChild(tdElementUser);
							trElement.appendChild(tdElementVisit);
							trElement.appendChild(tdElementUnfollow);
							var buttonVisit = document.createElement('button');
							buttonVisit.setAttribute("onclick", "visit('"
									+ usera[j] + "');");
							buttonVisit.innerHTML = "visit";
							var buttonUnfollow = document
									.createElement('button');
							buttonUnfollow.setAttribute("onclick", "unfollow('"
									+ usera[j] + "');");
							buttonUnfollow.innerHTML = "unfollow";
							tdElementUser.innerHTML = usera[j];
							tdElementVisit.appendChild(buttonVisit);
							tdElementUnfollow.appendChild(buttonUnfollow);
							document.getElementById("mefollowtable")
									.appendChild(trElement);
						}

					}
				}
			} else {
				alert("server exception!");
			}
		}
	};
}

function unfollow(username) {
	var xmlhttpRequest = new XMLHttpRequest();
	var url = "/Twister/FollowServlet?username="
			+ getCookieValue("currentUser") + "&follow=" + username;
	xmlhttpRequest.open("delete", url, true);
	xmlhttpRequest.send();
	xmlhttpRequest.onreadystatechange = function() {
		if (xmlhttpRequest.readyState == 4) {
			if (xmlhttpRequest.status == 200) {
				getMeFollow();
			}
		}
	};
}

function visit(username) {
	setCookie("visit", username, 1);
	window.location.href = "./myPosts.html";
}