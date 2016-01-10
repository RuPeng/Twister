package twister.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

import twister.PostServiceLocator;
import twister.PostSoapBindingStub;

@WebServlet("/PostsServlet")
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PostSoapBindingStub p;

	@Override
	public void init() throws ServletException {
		if (p == null) {
			try {
				EngineConfiguration config = new FileProvider(
						FollowServlet.class
								.getResourceAsStream("Authentication.wsdd"));
				p = (PostSoapBindingStub) new PostServiceLocator(config)
						.getPost();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		p.setUsername(username);
		PrintWriter writer = response.getWriter();
		writer.write(p.getPost(username));

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String postData = request.getParameter("postData");
		JSONObject json;
		try {
			json = new JSONObject(postData);
			p.setUsername(json.getString("username"));
			writer.write(p.doPost(postData));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String postData = req.getParameter("postData");
		JSONObject json;
		try {
			json = new JSONObject(postData);
			p.setUsername(json.getString("username"));
			p.deletePost(postData);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
