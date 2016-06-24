package org.ws.client.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.ws.common.Info;

public class ClientPasswordCallback implements CallbackHandler {
	
	private Info info;
	
	public ClientPasswordCallback(Info info){
		super();
		this.info = info;
	}

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for(int i = 0;i < callbacks.length;i++){
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
			if(pc.getUsage() == WSPasswordCallback.USERNAME_TOKEN){
				if(info.getUsername().equals(pc.getIdentifier())){
					pc.setPassword(info.getPassword());
				}
			}
		}
	}

}
