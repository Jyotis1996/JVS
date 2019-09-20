/**
 *
 */
package com.uks.jyoti.struts.day2.a1.logic;

import java.sql.Connection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.DbMasterNames;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

/**
 * @author jyoti
 *
 */
public class DetailLogic {

	Connection con = null;
	UserDataBean listbean;
	// LoginBeans objbean =new LoginBeans();

	// methods perform details of user retriving operation
	@SuppressWarnings("unchecked")
	public UserDataBean detailUser(String uname) {

		Session session = null;
		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			session = objHibUtil.getSession();
			session.beginTransaction();
			List<UserDataBean> items = null;
			try {
				items = (List<UserDataBean>) session
						.createQuery("from " + DbMasterNames.ITEMS_MASTER + " where userid =:uname")
						.setParameter("uname", uname).list();

				String birth = items.get(0).getDob().toString();
				items.get(0).setBirth(birth);

				return items.get(0);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.getTransaction().commit();
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listbean;
	}
}
