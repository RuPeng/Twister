function trimSpaces(str) {
	var resultStr = "";
	temp = str.split(/\s/);
	for (var i = 0; i < temp.length; i++)
		resultStr += temp[i];
	return resultStr;
};

function checkUserName() {
	var nameValue = trimSpaces(document.getElementById("username").value);
	var warning1 = document.getElementById("UNwarning1");
	var warning2 = document.getElementById("UNwarning2");
	var validName = /^[a-zA-Z]+$/;
	if (nameValue === "") {
		warning1.style.display = "inline";
		warning2.style.display = "none";
	} else if (!validName.test(nameValue) || nameValue.length > 16) {
		warning1.style.display = "none";
		warning2.style.display = "inline";
	} else {
		warning1.style.display = "none";
		warning2.style.display = "none";
	}
};

function checkRealName() {
	var nameValue = trimSpaces(document.getElementById("realname").value);
	var warning1 = document.getElementById("RNwarning1");
	var warning2 = document.getElementById("RNwarning2");
	var validName = /^[a-zA-Z]+$/;
	if (nameValue === "") {
		warning1.style.display = "inline";
		warning2.style.display = "none";
	} else if (!validName.test(nameValue) || nameValue.length > 16) {
		warning1.style.display = "none";
		warning2.style.display = "inline";
	} else {
		warning1.style.display = "none";
		warning2.style.display = "none";
	}
};

function checkBio() {
	var warning = document.getElementById("BIOwarning");
	if (document.getElementById("biography").value.length > 100) {
		warning.style.display = "inline";
	} else {
		warning.style.display = "none";
	}
};

function checkEmail() {
	var emailAddValue = document.getElementById("emailAdd").value.trim();
	var warning = document.getElementById("EAwarning");
	var validEmailAdd = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	if (!validEmailAdd.test(emailAddValue)) {
		warning.style.display = "inline";
	} else {
		warning.style.display = "none";
	}
};

function checkPassword1() {
	var pwd1 = document.getElementById("password1").value;
	var warning1 = document.getElementById("PWwarning1");
	if (pwd1 === "") {
		warning1.style.display = "inline";
	} else {
		warning1.style.display = "none";
	}
};

function checkPassword2() {
	var pwd1 = document.getElementById("password1").value;
	var pwd2 = document.getElementById("password2").value;
	var warning2 = document.getElementById("PWwarning2");
	var warning3 = document.getElementById("PWwarning3");
	if (pwd2 === "") {
		warning2.style.display = "inline";
		warning3.style.display = "none";
	} else if (pwd1 !== pwd2) {
		warning2.style.display = "none";
		warning3.style.display = "inline";
	} else {
		warning2.style.display = "none";
		warning3.style.display = "none";
	}
};

function submit() {
	checkUserName();
	checkRealName();
	checkBio();
	checkEmail();
	checkPassword1();
	checkPassword2();
	var find = false;
	var elements = document.getElementsByTagName("span");
	for (var i = 0; i < elements.length; i++) {
		if (elements[i].style.display == "inline") {
			find = true;
		}
	}
	if (find) {
		alert("submit failed!");
	} else {
		var newUser = {
			"username" : document.getElementById("username").value,
			"realname" : document.getElementById("realname").value,
			"biography" : document.getElementById("biography").value,
			"email" : document.getElementById("emailAdd").value,
			"password" : document.getElementById("password1").value,
		};

		var value = JSON.stringify(newUser);
		var url = "/Twister/RegisterServlet?newUser=" + value;
		var xmlhttpRequest = new XMLHttpRequest();
		xmlhttpRequest.open("post", url, true);
		xmlhttpRequest.send(null);

		xmlhttpRequest.onreadystatechange = function() {
			if (xmlhttpRequest.readyState == 4) {
				if (xmlhttpRequest.status == 200) {
					var msg = JSON.parse(xmlhttpRequest.responseText);
					if (msg.result == "register succeed!") {
						window.location.replace("./index.html");
					} else {
						alert(msg.result);
					}
				}
			}
		};
	}
};