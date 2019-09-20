package com.uks.jyoti.struts.day2.a1.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.DbMasterNames;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

public class UserLogic {
	// Initializing the objects
	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	Session session;

	@SuppressWarnings("unchecked")
	public UserDataBean fetchUser(String userid) throws SQLException {

		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			session = objHibUtil.getSession();
			session.beginTransaction();
			List<UserDataBean> items = null;
			try {
				items = (List<UserDataBean>) session
						.createQuery("from " + DbMasterNames.ITEMS_MASTER + " where userid =:uname")
						.setParameter("uname", userid).list();

				String birth = items.get(0).getDob().toString();
				items.get(0).setBirth(birth);

				return items.get(0);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<UserDataBean> fetchAllUsers() throws SQLException {

		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			session = objHibUtil.getSession();
			session.beginTransaction();
			List<UserDataBean> items = null;
			try {
				items = session.createQuery("from " + DbMasterNames.ITEMS_MASTER).list();

				// Committed Transaction
				session.getTransaction().commit();

				return items;
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
