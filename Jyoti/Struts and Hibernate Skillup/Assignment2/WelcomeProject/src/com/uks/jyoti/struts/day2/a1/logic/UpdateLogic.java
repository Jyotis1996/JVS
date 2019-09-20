/**
 *
 */
package com.uks.jyoti.struts.day2.a1.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.uks.jyoti.struts.common.util.Constants;
import com.uks.jyoti.struts.common.util.DbMasterNames;
import com.uks.jyoti.struts.common.util.HibernateUtil;
import com.uks.jyoti.struts.day2.a1.bean.UserDataBean;

/**
 * @author jyoti
 *
 */
public class UpdateLogic {
	// creating object of database class
	UserDataBean listbean = new UserDataBean();
	Session session;

	// methods perform update user operation
	public String updateuser(UserDataBean listbean) throws SQLException, IOException {

		try {
			HibernateUtil objHibUtil = new HibernateUtil();
			// UserDataBean objuser = new UserDataBean();

			session = objHibUtil.getSession();
			session.beginTransaction();
			try {
				Query query = session
						.createQuery("update " + DbMasterNames.ITEMS_MASTER + " set salulation =:salulation,"
								+ "firstname =:firstname," + "middleinitial =:middleinitial," + "lastname =:lastname,"
								+ "sex =:gender," + "emailid =:emailId," + "birthdate =:dob," + "address =:address,"
								+ "userid =:userid," + "password =:password," + "areaofinterest =:areaofinterest,"
								+ "otherinterest =:otherinterest," + "category =:category" + " WHERE userid =:userid");
				query.setParameter("salulation", listbean.getSalutation());
				query.setParameter("firstname", listbean.getFirstName());
				query.setParameter("middleinitial", listbean.getMiddleName());
				query.setParameter("lastname", listbean.getLastName());
				query.setParameter("gender", listbean.getGender());
				query.setParameter("emailId", listbean.getEmailId());

				// Converting String to Date and Storing into the Database
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateInString = listbean.getBirth();
				Date date = formatter.parse(dateInString);
				query.setParameter("dob", date);

				query.setParameter("address", listbean.getAddress());
				query.setParameter("userid", listbean.getUserid());
				query.setParameter("password", listbean.getPassword());
				query.setParameter("areaofinterest", listbean.getAreaofinterest());
				query.setParameter("otherinterest", listbean.getOtherinterest());
				query.setParameter("category", listbean.getCategory());
				query.setParameter("userid", listbean.getUserid());

				int updateResult = query.executeUpdate();
				System.out.println("User data Update Status=" + updateResult);
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
