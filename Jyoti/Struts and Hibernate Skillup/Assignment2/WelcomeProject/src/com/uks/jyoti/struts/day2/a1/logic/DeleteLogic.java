/**
 *
 */
package com.uks.jyoti.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.DbMasterNames;
import com.uks.jyoti.struts.common.util.HibernateUtil;

/**
 * @author jyoti
 *
 */
public class DeleteLogic {

	// creating object of database class
	Connection con = null;

	// methods perform delete operation
	public void deleteUser(String[] uname) throws SQLException, IOException {

		Session session = null;
		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			session = objHibUtil.getSession();
			session.beginTransaction();
			try {
				for (int i = 0; i < uname.length; i++) {
					Query query = session
							.createQuery("delete " + DbMasterNames.ITEMS_MASTER + " where userid =:uname ");
					query.setParameter("uname", uname[i]);
					query.executeUpdate();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.getTransaction().commit();
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
