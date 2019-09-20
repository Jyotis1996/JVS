package com.uks.assignment1.logic;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.uks.assignment1.common.util.DbMasterNames;
import com.uks.assignment1.common.util.HibernateUtil;
import com.uks.assignment1.bean.LoginBean;
import com.uks.assignment1.bean.UserDataBean;

/**
 * Login logic class to validate user
 *
 * @author Jyoti date-2019/09/13
 */

public class LoginLogic {

	LoginBean objbean = new LoginBean();

	// private String userId, userPassword;
	Session session = null;
	String returnResult = "";
	List<UserDataBean> items = null;

	// This methods validate user is prasent in your system or not
	@SuppressWarnings("unchecked")
	public String validateUser(LoginBean objbean) {

		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			Session session = objHibUtil.getSession();
			session.beginTransaction();

			try {

				items = (List<UserDataBean>) session.createQuery("from " + DbMasterNames.ITEMS_MASTER).list();
				if (items != null) {
					return "success";
				} else {
					return "login";
				}

			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.getTransaction().commit();
				session.close();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return "success";
	}
}
