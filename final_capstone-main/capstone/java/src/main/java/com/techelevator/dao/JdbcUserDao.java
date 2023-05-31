package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.techelevator.model.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        int userId;
        try {
            userId = jdbcTemplate.queryForObject("select user_id from users where username = ?", int.class, username);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("User " + username + " was not found.");
        }

        return userId;
    }

	@Override
	public User getUserById(int userId) {
		String sql = "SELECT * FROM users WHERE user_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		if (results.next()) {
			return mapRowToUser(results);
		} else {
			throw new UserNotFoundException();
		}
	}

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }

        return users;
    }

    @Override
    public User findByUsername(String username) {
        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    @Override
    public boolean create(String username, String password, String role, String firstName, String lastName,
                          String emailAddress, String phoneNumber, int age, String emergencyFirstName, String emergencyLastName,
                          String emergencyPhone) {
        String insertUserSql = "insert into users (username,password_hash,role,first_name,last_name,email_address,phone_number,age,emerg_first_name,emerg_last_name,emerg_phone)" +
                               "values (?,?,?,?,?,?,?,?,?,?,?)";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();

        return jdbcTemplate.update(insertUserSql, username, password_hash, ssRole, firstName, lastName,
                                  emailAddress, phoneNumber, age, emergencyFirstName, emergencyLastName, emergencyPhone) == 1;
    }
//    @Override
//    public boolean addPendingUser(User user) {
//        String password = user.getPassword();
//        String role = user.getRole();
//        String addUserSql = "insert into users (username,password_hash,role,first_name,last_name,email_address," +
//                "phone_number,age,emerg_first_name,emerg_last_name,emerg_phone) values (?,?,?,?,?,?,?,?,?,?,?)";
//        String password_hash = new BCryptPasswordEncoder().encode(password);
//        String ssRole = role.toUpperCase().startsWith("ROLE_") ? role.toUpperCase() : "ROLE_" + role.toUpperCase();
//
//        return jdbcTemplate.update(addUserSql, user.getUsername(), password_hash, ssRole, user.getFirstName(),
//                user.getLastName(), user.getEmailAddress(), user.getPhoneNumber(), user.getAge(), user.getEmergFirstName(),
//                user.getEmergLastName(), user.getEmergPhone()) == 1;
//
//    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmailAddress(rs.getString("email_address"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setAge(rs.getInt("age"));
        user.setEmergencyFirstName(rs.getString("emerg_first_name"));
        user.setEmergencyLastName(rs.getString("emerg_last_name"));
        user.setEmergencyPhone(rs.getString("emerg_phone"));
        user.setActivated(true);
//        user.setFirstName(rs.getString("first_name"));
//        user.setLastName(rs.getString("last_name"));
//        user.setEmailAddress(rs.getString("email_address"));
//        user.setPhoneNumber(rs.getString("phone_number"));
//        user.setAge(rs.getInt("age"));
//        user.setEmergFirstName(rs.getString("emerg_first_name"));
//        user.setEmergLastName(rs.getString("emerg_last_name"));
//        user.setEmergPhone(rs.getString("emerg_phone"));
        return user;
    }
}
