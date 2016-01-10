function getFollowMe() {
	if (getCookieValue("currentUser") == null) {
		window.location.href = "./index.html";
	}
	var xmlhttpRequest = new XMLHttpRequest();
	var url = "/Twister/FollowServlet?username="
			+ getCookieValue("currentUser") + "&flag=followme";
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

							trElement.appendChild(tdElementUser);
							trElement.appendChild(tdElementVisit);
							var buttonVisit = document.createElement('button');
							buttonVisit.setAttribute("onclick", "visit('"
									+ usera[j] + "');");
							buttonVisit.innerHTML = "visit";
							tdElementUser.innerHTML = usera[j];
							tdElementVisit.appendChild(buttonVisit);
							document.getElementById("followmetable")
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

function visit(username) {
	setCookie("visit", username, 1);
	window.location.href = "./myPosts.html";
}