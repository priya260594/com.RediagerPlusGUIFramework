package com.hc.rediagerplus.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods related to database
 * 
 * @author Priyanka
 */

public class DatabaseUtility {
	Connection con;
	ResultSet result;

	/**
	 * This generic method is used to get database connection
	 * 
	 * @throws Throwable
	 */

	public void getConnection() throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IPathConstants.dBURL, IPathConstants.dBURL, IPathConstants.dbPassword);

	}

	/**
	 * This generic method is used to execute the select query
	 * 
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeSelectQuery(String query) throws Throwable {
		Statement stat = con.createStatement();
		result = stat.executeQuery(query);
		return result;
	}

	/**
	 * This generic method is used to execute the non select query
	 * 
	 * @param query
	 * @return
	 * @throws Throwable
	 */

	public int executeNonSelectQuery(String query) throws Throwable {
		Statement stat = con.createStatement();
		int result = stat.executeUpdate(query);
		return result;
	}

	/**
	 * This generic method is used to close the database connection
	 * 
	 * @throws Throwable
	 */
	public void closeConnection() throws Throwable {
		con.close();
	}

}
