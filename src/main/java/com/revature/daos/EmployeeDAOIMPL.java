package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;
import com.revature.utils.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOIMPL implements EmployeeDAO{
    private static Logger log = LoggerFactory.getLogger(EmployeeDAOIMPL.class);

    @Override
    public boolean login(String username, String password){

        return false;
    }

    @Override
    public boolean addUser(Employee employee) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO users (ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) "
                    + " "
                    + "VALUES (?,?,?,?,?,?,?);";
            int count = 0;
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, employee.getUserID());
            statement.setString(2, employee.getUsername());
            statement.setString(3, employee.getPassword());
            statement.setString(4, employee.getUserFirstName());
            statement.setString(5, employee.getUserLastName());
            statement.setString(6, employee.getUserEmail());
            statement.setInt(7, employee.getUserRoleID());
        } catch (SQLException e) {
            MDC.put("MJ", "1");
            log.error("Unable to connect to database", e);
        }
        return false;
    }
}
