function postState() {
	var content = document.getElementById("postContent").value;
	if (content.length > 160) {
		alert("message should no more than 160 characters.");
		return false;
	}
	var userNameFormCookie = getCookieValue("currentUser");
	var myTime = new Date();

	var postData = {
		"content" : content,
		"date" : myTime,
		"username" : userNameFormCookie
	};

	var value = JSON.stringify(postData);
	var url = "/Twister/PostsServlet?postData=" + value;
	var xmlhttpRequest = new XMLHttpRequest();
	xmlhttpRequest.open("post", url, true);
	xmlhttpRequest.send();

	xmlhttpRequest.onreadystatechange = function() {
		if (xmlhttpRequest.readyState == 4) {
			if (xmlhttpRequest.status == 200) {
				var msg = JSON.parse(xmlhttpRequest.responseText);
				if (msg.result == "succeed!") {
					checkLogin();
				} else {
					alert(msg.result);
				}
			}

		}

	};
}

function checkLogin() {
	document.getElementById("postContent").value = "";
	document.getElementById("postsTable").innerHTML = "";
	if (getCookieValue("currentUser") == null) {
		window.location.href = "./index.html";
	} else {
		var url = "/Twister/LoginServlet?username="
				+ getCookieValue("currentUser");
		var xmlhttpRequest = new XMLHttpRequest();
		xmlhttpRequest.open("get", url, true);
		xmlhttpRequest.send();
		xmlhttpRequest.onreadystatechange = function() {
			if (xmlhttpRequest.readyState == 4) {
				if (xmlhttpRequest.status == 200) {
					var msg = JSON.parse(xmlhttpRequest.responseText);
					var results = JSON.parse(msg.result);
					for ( var i in results) {
						var result = results[i];
						for ( var j in result) {
							var trElement = document.createElement('tr');
							var tdElementContent = document.createElement('td');
							var tdElementUser = document.createElement('td');
							var tdElementTime = document.createElement('td');

							trElement.appendChild(tdElementContent);
							trElement.appendChild(tdElementUser);
							trElement.appendChild(tdElementTime);

							tdElementContent.innerHTML = result[j].content;
							tdElementUser.innerHTML = result[j].username;
							tdElementTime.innerHTML = result[j].date.toString()
									.substring(0, 19);

							document.getElementById("postsTable").appendChild(
									trElement);
						}
					}
				}

			}

		};
	}
}