package twister;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

import twister.database.DBManager;

public class AuthenticationHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			WSPasswordCallback wspc = (WSPasswordCallback) callback;
			DBManager dbm = new DBManager();
			if (dbm.searchUser(wspc.getIdentifier()) != null) {
				wspc.setPassword(wspc.getIdentifier());
			}
		}

	}

}
