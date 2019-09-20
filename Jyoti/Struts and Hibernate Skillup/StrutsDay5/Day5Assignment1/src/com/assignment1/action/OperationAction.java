package com.assignment1.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.assignment1.bean.UserListBean;
import com.assignment1.logic.UserListLogic;

/**
 * Operation action class to perform particular operation when button is clicked
 * @author Jyoti date-2019/09/09
 *
 */
public class OperationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ArrayList<UserListBean> objArrayList = null;
		String target = "";
		UserListLogic objListLogic = null;
		try {
			String[] checkUserName = request.getParameterValues("check_box");
			objListLogic = new UserListLogic();
			objArrayList = objListLogic.getUserList();
			String category = request.getParameter("catType").toString();
			request.setAttribute("categoryType", category);

			// For Register
			if (request.getParameter("register") != null) {
				target = "register";
			}
			// For Update
			if (request.getParameter("update") != null) {

				for (int i = 0; i < objArrayList.size(); i++) {
					for (int j = 0; j < checkUserName.length; j++) {
						if (objArrayList.get(i).getUserName()
								.equals(checkUserName[j])) {
							request.setAttribute("userId", objArrayList.get(i)
									.getUserName());
							request.setAttribute("password", objArrayList
									.get(i).getPassword());
							request.setAttribute("EditList",
									objArrayList.get(i));

						}
					}
				}
				target = "update";
			}
			// For Delete
			if (request.getParameter("delete") != null) {
				request.setAttribute("displayList", objArrayList);
				request.setAttribute("UserList", checkUserName);
				target = "delete";
			}
			// For Details
			if (request.getParameter("details") != null) {
				for (int i = 0; i < objArrayList.size(); i++) {
					for (int j = 0; j < checkUserName.length; j++) {
						if (objArrayList.get(i).getUserName()
								.equals(checkUserName[j])) {
							request.setAttribute("displayList",
									objArrayList.get(i));
						}
					}
				}
				target = "details";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(target);
	}
}
