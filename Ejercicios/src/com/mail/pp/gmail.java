package com.mail.pp;

import java.util.Properties;

import javax.mail.*;
//import javax.mail.internet.*;

public class gmail {
	String user;
	String pass;
	String host;
	Folder inbox;

	public gmail(String user, String pass) {
		this.user = user + "@gmail.com";
		this.pass = pass;
		this.host = "imap.gmail.com";
	}

	public boolean connect() {
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect(host, user, pass);

			inbox = store.getFolder("Inbox");
			// Obtenemos la casilla de entrada como carpeta a analizar

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getUnreadMessageCount() {
		try {
			inbox.open(Folder.READ_ONLY);
			int count = inbox.getUnreadMessageCount();
			inbox.close(false);
			return count;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
			// En caso de una excepción retornamos -1
		}
	}
}
