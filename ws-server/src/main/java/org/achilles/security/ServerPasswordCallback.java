package org.achilles.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.ws.common.Info;

public class ServerPasswordCallback implements CallbackHandler {
	
	private Info info;
	
	public void setInfo(Info info){
		this.info = info;
	}

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for(int i = 0;i < callbacks.length;i++){
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
			String id = pc.getIdentifier();
			switch(pc.getUsage()){
			case WSPasswordCallback.USERNAME_TOKEN:
				if(info.getUsername().equals(id)){
					pc.setPassword(info.getPassword());
				}
				break;
			case WSPasswordCallback.DECRYPT:
			case WSPasswordCallback.SIGNATURE:
				break;
			}
		}
	}

}
