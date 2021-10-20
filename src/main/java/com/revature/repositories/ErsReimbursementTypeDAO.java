package com.revature.repositories;

import com.revature.models.ErsReimbursementType;

import java.util.List;

public interface ErsReimbursementTypeDAO {
    public List<ErsReimbursementType> getAllTypes();
    public String addType();
}
