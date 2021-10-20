package com.revature.repositories;

import com.revature.models.ErsReimbursment;
import com.revature.models.ErsUserRoles;

import java.util.HashMap;
import java.util.List;

public interface ErsUserRolesDAO {
    public List<ErsUserRoles> getAllRoles();
    public HashMap<Integer, Integer> filterTickets();
    public int createUserRole();
}
