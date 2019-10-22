package com.mail.pp;

public class Main {

	public static void main(String[] args) {
		gmail gmail = new gmail("josedaniel23.71", "");
		//Gmail gmail = new Gmail("USER", "PASS");
		gmail.connect();

		System.out.println("Unread: " + gmail.getUnreadMessageCount());
	}

}
