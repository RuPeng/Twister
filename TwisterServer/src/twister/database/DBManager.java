package twister.database;

import java.util.Comparator;
import java.util.PriorityQueue;

import twister.entities.Posts;
import twister.entities.User;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oIOException;

public class DBManager {
	private static ObjectServer server;
	private ObjectContainer client;

	public DBManager() {
		if (server == null) {
			server = Db4o.openServer("twister.data", 8087);
		}
		client = server.openClient();
	}

	public boolean checkUserInfo(User u) {
		ObjectSet<User> users = client.query(User.class);
		for (User user : users) {
			if (user.getUsername().equals(u.getUsername())) {
				if (user.getPassword().equals(u.getPassword())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean userExist(User u) {
		ObjectSet<User> users = client.query(User.class);
		for (User user : users) {
			if (user.getUsername().equals(u.getUsername())) {
				return true;
			}
		}
		return false;
	}

	public User searchUser(String name) {
		ObjectSet<User> users = client.query(User.class);
		for (User user : users) {
			if (user.getUsername().equals(name)) {
				return user;
			}
		}
		return null;
	}

	public boolean close() throws Db4oIOException {
		return client.close();
	}

	public boolean createUser(User u) {
		client.store(u);
		client.store(u.getFollowMe());
		client.store(u.getMeFollow());
		client.commit();
		return true;
	}

	public boolean createPost(Posts p) {
		client.store(p);
		client.commit();
		return true;

	}

	public PriorityQueue<Posts> getPosts(String username) {
		PriorityQueue<Posts> posts = new PriorityQueue<>(
				new Comparator<Posts>() {

					@Override
					public int compare(Posts arg0, Posts arg1) {
						return arg1.getDate().compareTo(arg0.getDate());
					}
				});
		ObjectSet<Posts> post = client.query(Posts.class);
		for (Posts p : post) {
			if (p.getUsername().equals(username)) {
				posts.add(p);
			}
		}
		return posts;
	}

	public void deletePost(Posts po) {
		ObjectSet<Posts> post = client.query(Posts.class);
		for (Posts p : post) {
			if (p.getUsername().equals(po.getUsername())
					&& p.getContent().equals(po.getContent())
					&& p.getDate().toString()
							.equalsIgnoreCase(po.getDate().toString())) {
				client.delete(p);
				client.commit();
			}
		}
	}
}
