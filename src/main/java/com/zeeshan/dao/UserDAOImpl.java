package com.zeeshan.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.zeeshan.model.User;

public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jt;

	public UserDAOImpl(DataSource dataSource) {
		jt = new JdbcTemplate(dataSource);
	}

	@Override
	public int registerUser(User user) {
		String sql = "INSERT INTO USER_DATA VALUES(?, ?)";
		try {
			int counter = jt.update(sql, new Object[] { user.getUserId(), user.getPassword() });
			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public String loginUser(User user) {
		String sql = "SELECT USER_ID FORM USER_DATA WHERE USER_ID=? AND USER_PASS=?";
		try {
			String userId = jt.queryForObject(sql, new Object[] { user.getUserId(), user.getPassword() }, String.class);
			return userId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
