package com.uks.jyoti.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.FormBean;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

/**
 * Logic for registering new user in database
 *
 * @author jyoti
 *
 */
public class RegisterLogic extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// this method added new user into the database
	public void registeruser(FormBean formList) throws SQLException, IOException {
		HibernateUtil objHibUtil = new HibernateUtil();
		Session session = objHibUtil.getSession();
		try {

			session.beginTransaction();

			// Initializing the Master data bean
			UserDataBean objDataBean = new UserDataBean();

			// Conversion of string to data
			String dateStr = formList.getDob().toString();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(dateStr);
			System.out.println(date);

			// Setting setter of registration data
			objDataBean.setAddress(formList.getAddress());
			objDataBean.setAreaofinterest(formList.getAreaofinterest());
			objDataBean.setCategory(formList.getCategory());
			objDataBean.setDob(date);
			objDataBean.setEmailId(formList.getEmailId());
			objDataBean.setFirstName(formList.getFirstName());
			objDataBean.setGender(formList.getGender());
			objDataBean.setLastName(formList.getLastName());
			objDataBean.setMiddleName(formList.getMiddleName());
			objDataBean.setOtherinterest(formList.getOtherinterest());
			objDataBean.setPassword(formList.getPassword());
			objDataBean.setSalutation(formList.getSalutation());
			objDataBean.setUserid(formList.getUserid());

			// Saving data into the database
			session.save(objDataBean);

			// Commits the current operation

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
		}
	}
}
