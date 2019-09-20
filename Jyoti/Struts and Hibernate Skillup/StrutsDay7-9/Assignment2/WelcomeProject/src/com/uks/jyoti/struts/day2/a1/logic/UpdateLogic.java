/**
 *
 */
package com.uks.jyoti.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.Constants;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

/**
 * @author jyoti
 *
 */
public class UpdateLogic {
	// creating object of database class
	UserDataBean listbean = new UserDataBean();
	Session session = null;

	// methods perform update user operation
	public String updateuser(UserDataBean listbean) throws SQLException, IOException {

		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			session = objHibUtil.getSession();
			session.beginTransaction();
			try {
				session.update(listbean);
				session.getTransaction().commit();
				return Constants.updateRecordSucc;

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.getTransaction().commit();
				session.close();
			}

			return Constants.updateRecordUnSucc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
