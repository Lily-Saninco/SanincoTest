package com.saninco.clubweb.testcases;

import java.sql.SQLException;

import com.saninco.clubweb.testClass.ClubUser;
import com.saninco.clubweb.util.FileForUser;

public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

	    ClubUser databaseUser=FileForUser.userSearch("user1");
	}

}
