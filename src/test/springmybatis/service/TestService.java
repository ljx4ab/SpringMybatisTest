package test.springmybatis.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.springmybatis.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	TestMapper testMapper;

	public List<Map<String, Object>> getTests() {
		return testMapper.getTests();
	}

	public void init() {

		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:d:/sample.db")) {

			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("create table test (id integer, name string)");
			statement.executeUpdate("insert into test values(1, 'aaa')");
			statement.executeUpdate("insert into test values(2, 'bbb')");
			ResultSet rs = statement.executeQuery("select * from test");
			while (rs.next()) {
				// read the result set
				System.out.println("name = " + rs.getString("name"));
				System.out.println("id = " + rs.getInt("id"));
			}
		} catch (Exception e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
		}
	}
}
