package com.assignment1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.assignment1.Database.ConnectDB;
import com.assignment1.bean.OperationBean;
import com.assignment1.bean.UserListBean;
import com.assignment1.common.Constants;
import com.assignment1.logic.UserListLogic;
/**
 * UpdateUserAction class to perform Update action
 * @author Jyoti date-2019/09/09
 *
 */
public class UpdateUserAction extends Action {

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
		String category=null;
		String target = "";
		ActionErrors errors = null;
		ActionForward forward = new ActionForward();
		PreparedStatement objPreparedStatement = null;
		Connection objConnection = null;
		ConnectDB objConnectDB = new ConnectDB();
		OperationBean objOperationBean = null;
		ArrayList<UserListBean> objArrayList=new ArrayList<>();
		ArrayList<UserListBean> objArrayList1=new ArrayList<>();
		UserListLogic objListLogic = new UserListLogic();
		try {
			errors = new ActionErrors();
			objConnection = objConnectDB.connect();
			objOperationBean = (OperationBean)form;
			userName = request.getParameter("hiddenUserId");
			password = request.getParameter("hiddenPassword");

			// Get Values from Text boxes
			salutation = objOperationBean.getSalutation();
			firstName = objOperationBean.getFirstName();
			middleName = objOperationBean.getMiddleInitial();
			lastName = objOperationBean.getLastName();
			sex = objOperationBean.getGender();
			category=objOperationBean.getCategory();
			mailId = objOperationBean.getEmail();
			birthDate = objOperationBean.getBirthYear().trim() + "-"
					+ objOperationBean.getBirthMonth().trim() + "-"
					+ objOperationBean.getBirthDate().trim();
			address = objOperationBean.getAddress();
			areaOfInterest = objOperationBean.getAreaOfInterest();
			for (int i = 0; i < areaOfInterest.length; i++) {
				if (i == areaOfInterest.length - 1) {
					interestArea = interestArea + areaOfInterest[i];
				} else {
					interestArea = interestArea + areaOfInterest[i] + ",";
				}
			}
			otherInterest = objOperationBean.getOtherInterest();
			// query to update the data into database
			String query = Constants.UPDATE_QUERY;
			// Prepared statement object
			objPreparedStatement = objConnection.prepareStatement(query);

			objPreparedStatement.setString(1, salutation);
			objPreparedStatement.setString(2, firstName);
			objPreparedStatement.setString(3, middleName);
			objPreparedStatement.setString(4, lastName);
			objPreparedStatement.setString(5, sex);
			objPreparedStatement.setString(6, mailId);
			objPreparedStatement.setString(7, birthDate);
			objPreparedStatement.setString(8, address);
			objPreparedStatement.setString(9, interestArea);
			objPreparedStatement.setString(10, otherInterest);
			objPreparedStatement.setString(11, category);
			objPreparedStatement.setString(12, userName);
			objPreparedStatement.setString(13, password);
			int count=objPreparedStatement.executeUpdate();

			if(count>0){
			}

			String categoryType = request.getParameter("catType").toString();
			request.setAttribute("categoryType", categoryType);
			//for Updated Data pass
			objArrayList = objListLogic.getUserList();
			for(int i=0;i<objArrayList.size();i++){
				if(objArrayList.get(i).getUserName().equals(userName) && objArrayList.get(i).getPassword().equals(password)){
					objArrayList1.add(objArrayList.get(i));
				}
			}
			request.setAttribute("UserList",objArrayList1);

		} catch (SQLException e) {
			target = "failure";
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward(target);
		}
		return forward;
	}

}
