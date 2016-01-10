package twister.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;
import org.json.JSONException;
import org.json.JSONObject;

import twister.LoginServiceLocator;
import twister.LoginSoapBindingStub;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static LoginSoapBindingStub l;

	@Override
	public void init() throws ServletException {
		if (l == null) {
			try {
				EngineConfiguration config = new FileProvider(
						FollowServlet.class
								.getResourceAsStream("Authentication.wsdd"));
				l = (LoginSoapBindingStub) new LoginServiceLocator(config)
						.getLogin(new URL(
								"http://localhost:8280/services/LoginProxy"));
			} catch (ServiceException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		l.setUsername(username);
		PrintWriter writer = response.getWriter();
		writer.write(l.getAllPosts(username));
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String userinfo = request.getParameter("userInfo");
		try {
			JSONObject json = new JSONObject(userinfo);
			l.setUsername(json.getString("username"));
			writer.write(l.verifyUser(userinfo));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
