package com.mgnrega.conn;

import java.sql.Connection;

public class CheckConnection {

	public static void main(String[] args) {
	Connection conn=	DBconnection.provideConnection();
	System.out.println(conn);
	}

}
