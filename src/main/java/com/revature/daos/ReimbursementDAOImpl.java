package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO {

    @Override
    public List<Reimbursement> findAll() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "Select * from ers_reimbursement;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            List<Reimbursement> list = new ArrayList();

            while (result.next()) {
                Reimbursement reimb = new Reimbursement(result.getInt("reimb_id"), result.getFloat("reimb_amount"),
                        result.getTime("reimb_submitted"), result.getTime("reimb_resolved"), result.getByte("reimb_receipt"), result.getInt("reimb_author"), result.getInt("reimb_resolver"),  );
                );

"
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
