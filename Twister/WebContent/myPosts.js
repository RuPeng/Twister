function getMyPosts() {
	document.getElementById("myPosts").innerHTML = "";
	if (getCookieValue("currentUser") == null) {
		window.location.href = "./index.html";
	}

	var xmlhttpRequest = new XMLHttpRequest();
	var url = "/Twister/PostsServlet?username=";
	if (getCookieValue("visit") != null) {
		url += getCookieValue("visit");
		setCookie("visit", null, -1);
	} else {
		url += getCookieValue("currentUser");
	}
	xmlhttpRequest.open("get", url, true);
	xmlhttpRequest.send();
	xmlhttpRequest.onreadystatechange = function() {
		if (xmlhttpRequest.readyState == 4) {
			if (xmlhttpRequest.status == 200) {
				var msg = JSON.parse(xmlhttpRequest.responseText);
				var posts = JSON.parse(msg.result);
				for ( var i in posts) {
					var trElement = document.createElement('tr');
					var tdElementContent = document.createElement('td');
					var tdElementDelete = document.createElement('td');
					var tdElementTime = document.createElement('td');

					trElement.appendChild(tdElementContent);
					trElement.appendChild(tdElementTime);
					trElement.appendChild(tdElementDelete);

					tdElementContent.innerHTML = posts[i].content;
					tdElementTime.innerHTML = posts[i].date.toString()
							.substring(0, 19).replace("T", " ");
					var buttonDelete = document.createElement('button');
					buttonDelete.setAttribute("onclick", "deletePost('"
							+ posts[i].content + "','" + posts[i].date + "','"
							+ posts[i].username + "')");
					buttonDelete.innerHTML = "delete";
					tdElementDelete.appendChild(buttonDelete);
					document.getElementById("myPosts").appendChild(trElement);
				}
			} else {
				alert("server exception!");
			}
		}
	};
}

function deletePost(content, date, username) {
	var postData = {
		"content" : content,
		"date" : new Date(date),
		"username" : username
	};
	var value = JSON.stringify(postData);
	var xmlhttpRequest = new XMLHttpRequest();
	var url = "/Twister/PostsServlet?postData=" + value;
	xmlhttpRequest.open("delete", url, true);
	xmlhttpRequest.send();
	xmlhttpRequest.onreadystatechange = function() {
		if (xmlhttpRequest.readyState == 4) {
			if (xmlhttpRequest.status == 200) {
				getMyPosts();
			} else {
				alert("server exception!");
			}
		}
	};
}