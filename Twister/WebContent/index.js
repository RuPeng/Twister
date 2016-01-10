function login() {
	var username = document.getElementById("username").value.trim();
	var password = document.getElementById("password").value.trim();
	if (username === "") {
		alert("please input username");
		return;
	} else if (password === "") {
		alert("please input password");
		return;
	} else {
		var userInfo = {
			"username" : username,
			"password" : password
		};
		var value = JSON.stringify(userInfo);
		var url = "/Twister/LoginServlet?userInfo=" + value;
		var xmlhttpRequest = new XMLHttpRequest();
		xmlhttpRequest.open("post", url, true);
		xmlhttpRequest.send();

		xmlhttpRequest.onreadystatechange = function() {
			if (xmlhttpRequest.readyState == 4) {
				if (xmlhttpRequest.status == 200) {
					var msg = JSON.parse(xmlhttpRequest.responseText);
					if (msg.result == "login succeed!") {
						setCookie("currentUser", username.toString(), 1);
						window.location.href = "./postsHome.html";
					} else {
						alert(msg.result);
					}
				}
			}
		};
	}
}
