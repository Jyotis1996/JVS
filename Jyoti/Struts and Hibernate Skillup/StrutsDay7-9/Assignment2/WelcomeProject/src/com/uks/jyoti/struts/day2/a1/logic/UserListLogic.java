package com.uks.jyoti.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.DbMasterNames;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

/**
 * Logic for fetching user list from database
 *
 * @author jyoti
 *
 */
public class UserListLogic {
	// Initializing the arrayList
	List<UserDataBean> list = new ArrayList<UserDataBean>();

	// Initializing query
	String hQuery = "from " + DbMasterNames.ITEMS_MASTER;
	int count = 0;

	// according to selection of the data select query genearete and getting the
	// select result
	@SuppressWarnings("unchecked")
	public List<UserDataBean> getUserList(String uname, String category, String fname, String address, String gender,
			String email) throws SQLException, IOException {

		HibernateUtil objHibUtil = new HibernateUtil();
		// UserDataBean objuser = new UserDataBean();

		Session session = objHibUtil.getSession();
		session.beginTransaction();
		try {
			if (uname == null || category == null || fname == null || address == null || gender == null
					|| email == null) {
				System.out.println(hQuery);

				return list;
			} else {
				// if username is not null
				if (!uname.equals("")) {
					if (count > 0) {
						hQuery = hQuery + " and ";
					} else {
						hQuery = hQuery + " where ";
					}
					hQuery = hQuery + " USERID='" + uname + "'";
					count++;
				}
				// if category is not null
				if (!category.equals("---")) {
					if (count > 0) {
						hQuery = hQuery + " and ";
					} else {
						hQuery = hQuery + " where ";
					}
					hQuery = hQuery + " CATEGORY='" + category + "'";
					count++;
				}
				// if firstnmae is not null
				if (!fname.equals("")) {
					if (count > 0) {
						hQuery = hQuery + " and ";
					} else {
						hQuery = hQuery + " where ";
					}
					hQuery = hQuery + "FIRSTNAME like '%" + fname + "%'";
					count++;
				}
				// if address is not null
				if (!address.equals("")) {
					if (count > 0) {
						hQuery = hQuery + " and ";
					} else {
						hQuery = hQuery + " where ";
					}
					hQuery = hQuery + " ADDRESS like '%" + address + "%'";
					count++;
				}
				// if gender is not null
				if (!gender.equals("---")) {
					if (count > 0) {
						hQuery = hQuery + " and ";
					} else {
						hQuery = hQuery + " where ";
					}
					hQuery = hQuery + " SEX='" + gender + "'";
					count++;
				}
				// if email is not null
				if (!email.equals("")) {
					if (count > 0) {
						hQuery = hQuery + " and ";
					} else {
						hQuery = hQuery + " where ";
					}
					hQuery = hQuery + " EMAILID='" + email + "'";
					count++;
				}

				Query query = session.createQuery(hQuery);
				list = query.list();
				return list;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.getTransaction().commit();
		}
		return list;
	}
}
