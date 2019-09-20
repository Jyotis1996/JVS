package com.assignment1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.assignment1.Database.ConnectDB;
import com.assignment1.bean.RegisterUserBean;
import com.assignment1.bean.UserListBean;
import com.assignment1.logic.UserListLogic;

public class RegisterUserAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String salutation = null;
		String firstName = null;
		String middleName = null;
		String lastName = null;
		String sex = null;
		String mailId = null;
		String birthDate = null;
		String address = null;
		String userName = null;
		String password = null;
		String[] areaOfInterest = null;
		String interestArea = "";
		String otherInterest = null;
		String category = null;
		RegisterUserBean objRegisterUserBean = null;
		ArrayList<UserListBean> objArrayList = null;
		PreparedStatement objPreparedStatement = null;
		Connection objConnection = null;
		ConnectDB objConnectDB = new ConnectDB();
		UserListLogic objListLogic = null;
		try {
			objListLogic = new UserListLogic();
			objRegisterUserBean = (RegisterUserBean) form;
			objConnection = objConnectDB.connect();
			// Get Values from Text boxes
			salutation = objRegisterUserBean.getSalutation();
			firstName = objRegisterUserBean.getFirstName();
			middleName = objRegisterUserBean.getMiddleInitial();
			lastName = objRegisterUserBean.getLastName();
			sex = objRegisterUserBean.getGender();
			mailId = objRegisterUserBean.getEmail();
			birthDate = objRegisterUserBean.getBirthDate().trim() + "/"
					+ objRegisterUserBean.getBirthMonth().trim() + "/"
					+ objRegisterUserBean.getBirthYear().trim();
			address = objRegisterUserBean.getAddress();
			userName = objRegisterUserBean.getUserName();
			password = objRegisterUserBean.getPassword();
			areaOfInterest = objRegisterUserBean.getAreaOfInterest();
			for (int i = 0; i < areaOfInterest.length; i++) {
				if (i == areaOfInterest.length - 1) {
					interestArea = interestArea + areaOfInterest[i];
				} else {
					interestArea = interestArea + areaOfInterest[i] + ",";
				}
			}
			otherInterest = objRegisterUserBean.getOtherInterest();
			category = objRegisterUserBean.getCategory();
			String query = "insert into UserDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			// Prepared statement object
			objPreparedStatement = objConnection.prepareStatement(query);

			objPreparedStatement.setString(1, userName);
			objPreparedStatement.setString(2, password);
			objPreparedStatement.setString(3, salutation);
			objPreparedStatement.setString(4, firstName);
			objPreparedStatement.setString(5, middleName);
			objPreparedStatement.setString(6, lastName);
			objPreparedStatement.setString(7, sex);
			objPreparedStatement.setString(8, mailId);
			objPreparedStatement.setString(9, birthDate);
			objPreparedStatement.setString(10, address);
			objPreparedStatement.setString(11, interestArea);
			objPreparedStatement.setString(12, otherInterest);
			objPreparedStatement.setString(13, category);

			int count = objPreparedStatement.executeUpdate();

			if (count > 0) {
				JOptionPane.showMessageDialog(null, "Record added Successfully...");
			}

			String categoryType = request.getParameter("catType").toString();
			request.setAttribute("categoryType", categoryType);
			// for Updated Data pass
			objArrayList = objListLogic.getUserList();
			request.setAttribute("UserList", objArrayList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("register");
	}
}
