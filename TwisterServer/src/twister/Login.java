package twister;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import twister.database.DBManager;
import twister.entities.Posts;
import twister.entities.User;

public class Login {
	public String getAllPosts(String username) {
		DBManager dbm = new DBManager();
		User u = dbm.searchUser(username);
		List<String> follow = u.getMeFollow();
		if (follow == null) {
			follow = new ArrayList<String>();
		}
		PriorityQueue<Posts> tmp = new PriorityQueue<Posts>(
				new Comparator<Posts>() {
					@Override
					public int compare(Posts arg0, Posts arg1) {
						// TODO Auto-generated method stub
						return arg1.getDate().compareTo(arg0.getDate());
					}
				});
		for (String f : follow) {
			tmp.addAll(dbm.getPosts(f));
		}
		PriorityQueue<Posts> result = new PriorityQueue<Posts>(50,
				new Comparator<Posts>() {
					@Override
					public int compare(Posts arg0, Posts arg1) {
						// TODO Auto-generated method stub
						return arg1.getDate().compareTo(arg0.getDate());
					}
				});
		int size = tmp.size();
		for (int i = 0; i < 50 && i < size; i++) {
			result.add(tmp.poll());
		}
		JSONObject json = new JSONObject();
		JSONArray jsonarray = new JSONArray();
		jsonarray.put(result);
		try {
			json.put("result", jsonarray.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}

	public String verifyUser(String userInfo) {
		DBManager dbm = new DBManager();

		ObjectMapper mapper = new ObjectMapper();
		User user;
		JSONObject json = new JSONObject();

		try {
			user = mapper.readValue(userInfo, User.class);
			if (dbm.checkUserInfo(user)) {
				try {
					json.put("result", "login succeed!");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				try {
					json.put("result", "username or password error!");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json.toString();
	}
}
