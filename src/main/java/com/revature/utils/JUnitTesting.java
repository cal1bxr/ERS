package com.revature.utils;

import com.revature.models.ErsUserRoles;
import com.revature.models.ErsUsers;
import com.revature.repositories.ErsUsersDAO;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JUnitTesting {
    ErsUsersDAO ersUserDao;
    ErsUserRoles ersUserRole = new ErsUserRoles(1, "ADMIN");
    ErsUsers ersUser1 = new ErsUsers(1,"mjordan",1281629883, "Matt", "Jordan","mjordan@mjordan", ersUserRole);
    @Test
    public void testFindByEmail(){
        Session session = HibernateUtil.getSession();
        List<ErsUsers> ersUser = (List<ErsUsers>) ersUserDao.getUserByEmail("mjordan@mjordan");
        Assert.assertEquals(ersUser1, ersUser);
//        Assert.assertEquals("1", ersUser.getErsUsersId());
//        Assert.assertEquals("Matt", ersUser.getErsFirstName());
//        Assert.assertEquals("Jordan", ersUser.getErsLastName());
//        Assert.assertEquals("1", ersUser.getErsUserRole());
        return;

    }

    @Test
    public void testFindUserRole(){
        Session session = HibernateUtil.getSession();
        ErsUsers ersUser = ersUserDao.getUserRole(1);

        Assert.assertEquals(ersUser1.getErsUsersId(), ersUser.getErsUserRole());
        return;

    }

    @Test
    public void getUserByUsername(){
        Session session = HibernateUtil.getSession();
        ErsUsers ersUser = ersUserDao.getUsername("mjordan");

        Assert.assertEquals(ersUser1.getErsUsersId(), ersUser.getErsUserRole());
        return;
    }
}
