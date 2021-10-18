package com.revature.daos;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO {
    private static Logger log =
            LoggerFactory.getLogger(ReimbursementDAOImpl.class);

    @Override
    public List<Reimbursement> findAll() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "Select * from ers_reimbursement;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            List<Reimbursement> list = new ArrayList();

            while (result.next()) {
                Reimbursement reimb = new Reimbursement();
                reimb.setReimbID(result.getInt("reimb_id"));
                reimb.setReimbAmount(result.getFloat("reimb_amount"));
                reimb.setReimbSubmitted(result.getTime("reimb_submitted"));
                reimb.setReimbResolved(result.getTime("reimb_resolved"));
                reimb.setReimbDescription(result.getString("reimb_description"));
                reimb.setReimbAuthor(result.getInt("reimb_author"));
                reimb.setReimbResolver(result.getInt("reimb_resolver"));
                reimb.setReimbStatusID(result.getInt("reimb_status_id"));
                reimb.setReimbTypeID(result.getInt("reimb_type_id"));
            }

            return list;

        } catch (SQLException e) {
            log.error("SQL exception. Check tables names", e);
            e.printStackTrace();
        }
        return null;
    }
}
