package me.nichel.sportcenter.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Connection connection;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				final InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");

				final Properties properties = new Properties();
				properties.load(inputStream);

				String driver = properties.getProperty("driver");
				String url = properties.getProperty("url");
				String user = properties.getProperty("user");
				String password = properties.getProperty("password");

				Class.forName(driver);

				connection = DriverManager.getConnection(url, user, password);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}

	public static void close(final Connection toBeClosed) {
		if (toBeClosed != null) {
			try {
				toBeClosed.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
