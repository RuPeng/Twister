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

import twister.FollowServiceLocator;
import twister.FollowSoapBindingStub;

/**
 * Servlet implementation class FollowServlet
 */
@WebServlet("/FollowServlet")
public class FollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static FollowSoapBindingStub f;

	@Override
	public void init() throws ServletException {
		if (f == null) {
			try {
				EngineConfiguration config = new FileProvider(
						FollowServlet.class
								.getResourceAsStream("Authentication.wsdd"));
				f = (FollowSoapBindingStub) new FollowServiceLocator(config)
						.getFollow();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter writer = response.getWriter();
		f.setUsername(username);
		if (request.getParameter("flag").equals("mefollow")) {
			writer.write(f.getFollowing(username));
		} else {
			writer.write(f.getFollower(username));
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		f.setUsername(req.getParameter("username"));
		f.deleteFollow(req.getParameter("follow"), req.getParameter("username"));

	}
}
