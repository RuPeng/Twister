package twister;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import twister.database.DBManager;
import twister.entities.User;

public class Friend {
	public String searchFriend(String search) {
		JSONObject json = new JSONObject();
		DBManager dbm = new DBManager();
		User user = dbm.searchUser(search);
		if (user != null) {
			try {
				json.put("result", user.getUsername());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			try {
				json.put("result", "Sorry, not found!");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return json.toString();
	}

	public String follow(String user, String current) {
		DBManager dbm = new DBManager();
		User u = dbm.searchUser(user);
		User c = dbm.searchUser(current);

		if (u.getFollowMe() == null) {
			u.setFollowMe(new ArrayList<String>());
		}
		if (c.getMeFollow() == null) {
			c.setMeFollow(new ArrayList<String>());
		}
		JSONObject json = new JSONObject();
		if (u.getFollowMe().contains(c.getUsername())
				&& c.getMeFollow().contains(u.getUsername())) {
			try {
				json.put("result", "You have already followed this user!");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			u.getFollowMe().add(c.getUsername());
			c.getMeFollow().add(u.getUsername());
			dbm.createUser(c);
			dbm.createUser(u);
			try {
				json.put("result", "Follow succeed!");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return json.toString();

	}
}
