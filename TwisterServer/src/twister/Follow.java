package twister;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import twister.database.DBManager;
import twister.entities.User;

public class Follow {
	public String getFollower(String username) {
		DBManager dbm = new DBManager();
		User user = dbm.searchUser(username);
		JSONObject json = new JSONObject();
		JSONArray jsonarray = new JSONArray();

		jsonarray.put(user.getFollowMe());
		try {
			json.put("result", jsonarray.toString());

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	public String getFollowing(String username) {
		DBManager dbm = new DBManager();
		User user = dbm.searchUser(username);
		JSONObject json = new JSONObject();
		JSONArray jsonarray = new JSONArray();
		jsonarray.put(user.getMeFollow());
		try {
			json.put("result", jsonarray.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();

	}

	public void deleteFollow(String follow, String usernmae) {
		DBManager dbm = new DBManager();
		User user = dbm.searchUser(follow);
		User current = dbm.searchUser(usernmae);
		while (current.getMeFollow().contains(user.getUsername())) {
			current.getMeFollow().remove(user.getUsername());
		}
		while (user.getFollowMe().contains(current.getUsername())) {
			user.getFollowMe().remove(current.getUsername());
		}
		dbm.createUser(user);
		dbm.createUser(current);
	}
}
