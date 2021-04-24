package com.nuevoProyecto.util;

import java.io.IOException;
import java.io.Serializable;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;


/**
 * Manejador de callbacks con login/password
 *
 * @author Gerson Samaniego
 * Fecha Creación: 25/06/2009
 */
public class ClientCallbackHandler implements CallbackHandler, Serializable {

	private String login;
	private String password;
	private boolean sesionReconstruida;

	/**
	 * Constructor that takes username and password
	 */
	public ClientCallbackHandler(String login, String password) {
		//logger.info("VCARDENAS: ClientCallbackHandler("+login+","+password+")");
		this.login = login;
		this.password = password;
		this.sesionReconstruida = false;
	}

	public ClientCallbackHandler(String login, String password, Boolean sesionReconstruida) {
		//logger.info("VCARDENAS: ClientCallbackHandler("+login+","+password+")");
		this.login = login;
		this.password = password;
		this.sesionReconstruida = sesionReconstruida==null?false:sesionReconstruida;
	}

	/**
	 * @see
	 * javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.callback.Callback[])
	 *
	 */
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		//logger.info("VCARDENAS: handle()"+login+","+password+")");
		int len = callbacks.length;

		Callback cb;

		for (int i = 0; i < len; i++) {
			cb = callbacks[i];

			if (cb instanceof NameCallback) {
				NameCallback ncb = (NameCallback) cb;
				//logger.info("VCARDENAS: NameCallback.setName="+login);
				ncb.setName(login);
			} else if (cb instanceof PasswordCallback) {
				PasswordCallback pcb = (PasswordCallback) cb;
				//logger.info("VCARDENAS: PasswordCallback.setPassword="+password);
				pcb.setPassword(password.toCharArray());
			} else {
				//logger.info("VCARDENAS: Error en los callbacks suministrados");
				throw new UnsupportedCallbackException(cb, "Error en los callbacks suministrados");
			}
		}
	}

	/**
	 * @return the sesionReconstruida
	 */
	public boolean isSesionReconstruida() {
		return sesionReconstruida;
	}
}