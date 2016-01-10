function search() {
	var value = document.getElementById("name").value.trim();
	document.getElementById("searchResult").innerHTML = "";
	var url = "/Twister/FindFriends?searchVal=" + value;
	var xmlhttpRequest = new XMLHttpRequest();
	xmlhttpRequest.open("get", url, true);
	xmlhttpRequest.send();
	xmlhttpRequest.onreadystatechange = function() {
		if (xmlhttpRequest.readyState == 4) {
			if (xmlhttpRequest.status == 200) {
				var msg = JSON.parse(xmlhttpRequest.responseText);

				if (msg.result != "Sorry, not found!") {
					var pElement = document.createElement('p');
					var brElement = document.createElement('br');
					var btnElement = document.createElement('button');

					pElement.innerHTML = msg.result;
					btnElement.innerHTML = "Follow";
					btnElement.setAttribute("onclick", "follow('" + msg.result
							+ "');");

					document.getElementById("searchResult").appendChild(
							pElement);
					document.getElementById("searchResult").appendChild(
							brElement);
					document.getElementById("searchResult").appendChild(
							btnElement);

				} else {
					var pElement = document.createElement('p');
					pElement.innerHTML = msg.result;
					document.getElementById("searchResult").appendChild(
							pElement);
				}

			} else {
				alert("server exception!");
			}
		}
	};
}

function checkLogin() {
	if (getCookieValue("currentUser") == null) {
		window.location.href = "./index.html";
	}
}

function follow(username) {
	var url2 = "/Twister/FindFriends?user=" + username + "&current="
			+ getCookieValue("currentUser");
	var xmlhttpRequest = new XMLHttpRequest();
	xmlhttpRequest.open("post", url2, true);
	xmlhttpRequest.send();
	xmlhttpRequest.onreadystatechange = function() {
		if (xmlhttpRequest.readyState == 4) {
			if (xmlhttpRequest.status == 200) {
				alert(JSON.parse(xmlhttpRequest.responseText).result);
			} else {
				alert("server exception!");
			}
		}
	};
}