package twister;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import twister.database.DBManager;
import twister.entities.Posts;

public class Post {
	public String getPost(String username) {
		DBManager dbm = new DBManager();
		PriorityQueue<Posts> posts = dbm.getPosts(username);
		PriorityQueue<Posts> result = new PriorityQueue<Posts>(20,
				new Comparator<Posts>() {

					@Override
					public int compare(Posts arg0, Posts arg1) {
						// TODO Auto-generated method stub
						return arg1.getDate().compareTo(arg0.getDate());
					}
				});
		int size = posts.size();
		for (int i = 0; i < 20 && i < size; i++) {
			result.add(posts.poll());
		}
		JSONObject json = new JSONObject();
		JSONArray jsonarray = new JSONArray(result);
		try {
			json.put("result", jsonarray.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	public String doPost(String postData) {
		DBManager dbm = new DBManager();
		ObjectMapper mapper = new ObjectMapper();
		Posts post;
		JSONObject json = new JSONObject();
		try {
			post = mapper.readValue(postData, Posts.class);

			if (dbm.createPost(post)) {
				try {
					json.put("result", "succeed!");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				try {
					json.put("result", "failed!");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}

	public void deletePost(String postData) {
		ObjectMapper mapper = new ObjectMapper();
		Posts post;
		try {
			post = mapper.readValue(postData, Posts.class);
			DBManager dbm = new DBManager();
			dbm.deletePost(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
