package twister;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import twister.database.DBManager;
import twister.entities.User;

public class Register {

	public String createUser(String newUser) {
		DBManager dbm = new DBManager();
		ObjectMapper mapper = new ObjectMapper();
		User user;
		JSONObject json = new JSONObject();
		try {
			user = mapper.readValue(newUser, User.class);
			if (dbm.userExist(user)) {
				try {
					json.put("result", "username has already exist!");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				dbm.createUser(user);
				dbm.close();
				try {
					json.put("result", "register succeed!");
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
