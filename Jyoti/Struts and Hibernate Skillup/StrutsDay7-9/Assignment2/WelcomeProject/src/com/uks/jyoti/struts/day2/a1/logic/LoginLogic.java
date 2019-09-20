/**
 *
 */
package com.uks.jyoti.struts.day2.a1.logic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.DbMasterNames;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

/**
 * @author jyoti
 *
 */
public class LoginLogic {

	// This methods validate user is prasent in your system or not
	@SuppressWarnings("unchecked")
	public boolean validateUser(String uname, String pass, Map<String, Object> sessionMap) throws SQLException {

		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			Session session = objHibUtil.getSession();
			session.beginTransaction();
			List<UserDataBean> items = null;
			try {
				items = (List<UserDataBean>) session
						.createQuery("from " + DbMasterNames.ITEMS_MASTER + " where userid =:uname")
						.setParameter("uname", uname).list();
				if (items != null) {
					if (uname.equalsIgnoreCase(items.get(0).getUserid().toString())
							&& pass.equalsIgnoreCase(items.get(0).getPassword().toString())) {
						sessionMap.put("category", items.get(0).getCategory().toString());
						return true;
					}
				} else {
					return false;
				}
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.getTransaction().commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// returning the boolean
		return false;
	}

}
