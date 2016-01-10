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

import twister.FriendServiceLocator;
import twister.FriendSoapBindingStub;

@WebServlet("/FindFriends")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FriendSoapBindingStub f;

	@Override
	public void init() throws ServletException {
		if (f == null) {
			try {
				EngineConfiguration config = new FileProvider(
						FollowServlet.class
								.getResourceAsStream("Authentication.wsdd"));
				f = (FriendSoapBindingStub) new FriendServiceLocator(config)
						.getFriend();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String search = request.getParameter("searchVal");

		f.setUsername(search);
		writer.write(f.searchFriend(search));

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		f.setUsername(request.getParameter("current"));
		writer.write(f.follow(request.getParameter("user"),
				request.getParameter("current")));

	}
}
