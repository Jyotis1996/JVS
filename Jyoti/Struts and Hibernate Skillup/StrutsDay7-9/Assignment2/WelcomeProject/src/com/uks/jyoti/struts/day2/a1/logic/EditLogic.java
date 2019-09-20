/**
 *
 */
package com.uks.jyoti.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.DbMasterNames;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.FormBean;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

/**
 * @author jyoti
 *
 */
public class EditLogic {
	// creating object of database class
	UserDataBean listbean = new UserDataBean();
	FormBean userData = new FormBean();
	Session session;

	// methods perform edit user operation
	@SuppressWarnings("unchecked")
	public UserDataBean editUser(String uname) throws SQLException, IOException {

		try {
			HibernateUtil objHibUtil = new HibernateUtil();

			session = objHibUtil.getSession();
			session.beginTransaction();
			List<UserDataBean> items = null;
			try {
				items = session.createQuery("from " + DbMasterNames.ITEMS_MASTER + " where userid =:uname")
						.setParameter("uname", uname).list();

				if (!items.get(0).getAreaofinterest().isEmpty()) {
					String[] arrList = items.get(0).getAreaofinterest().split(",");
					items.get(0).setArrList(arrList);

					String birth = items.get(0).getDob().toString();
					items.get(0).setBirth(birth);
				}
				listbean = items.get(0);

				// Committed Transaction
				session.getTransaction().commit();

				return listbean;
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// session.close();
		}
		return listbean;
	}

}
