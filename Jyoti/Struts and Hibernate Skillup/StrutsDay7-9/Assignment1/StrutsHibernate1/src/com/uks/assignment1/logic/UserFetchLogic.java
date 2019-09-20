package com.uks.assignment1.logic;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.uks.assignment1.common.util.DbMasterNames;
import com.uks.assignment1.common.util.HibernateUtil;
import com.uks.assignment1.bean.UserDataBean;

public class UserFetchLogic {

	UserDataBean objuser = new UserDataBean();
	HibernateUtil hbUtil = new HibernateUtil();
	@SuppressWarnings("unchecked")
	public List<UserDataBean> list() {
		Session session = hbUtil.getSession();
		session.beginTransaction();
		List<UserDataBean> items = null;
		try {
			items = (List<UserDataBean>) session.createQuery("from " + DbMasterNames.ITEMS_MASTER).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}

	@SuppressWarnings("unchecked")
	public List<UserDataBean> fetchUser(String userid) {
		Session session = hbUtil.getSession();
		session.beginTransaction();
		List<UserDataBean> items = null;
		try {
			items = (List<UserDataBean>) session
					.createQuery("from " + DbMasterNames.ITEMS_MASTER + " where userid = :userid")
					.setParameter("userid", userid).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return items;
	}
}
