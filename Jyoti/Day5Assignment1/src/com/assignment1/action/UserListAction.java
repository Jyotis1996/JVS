package com.assignment1.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.assignment1.bean.UserListBean;
import com.assignment1.logic.UserListLogic;

public class UserListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		UserListLogic objListLogic = null;
		ArrayList<UserListBean> objArrayList = new ArrayList<>();
		ArrayList<UserListBean> objArrayList1 =new ArrayList<>();
		boolean flag = false;
		String target = "";
		try {
			String userName = session.getAttribute("UserName").toString();
			String password = session.getAttribute("Password").toString();
			objListLogic = new UserListLogic();
			objArrayList = objListLogic.getUserList();
			for (int i = 0; i < objArrayList.size(); i++) {
				if (objArrayList.get(i).getUserName().equals(userName)
						&& objArrayList.get(i).getPassword().equals(password)) {

					if (objArrayList.get(i).getCategory().equalsIgnoreCase("admin")) {
						request.setAttribute("categoryType", "admin");
						flag = true;
						target = "showData";
					}
					// System.out.println(objArrayList.get(i).getCategory());
					if (objArrayList.get(i).getCategory()
							.equalsIgnoreCase("user")) {
						request.setAttribute("categoryType", "user");
						objArrayList1.add(objArrayList.get(i));
						request.setAttribute("UserList", objArrayList1);
						target = "showData";
						flag = false;

					}
				}
			}
			if (flag) {
				objArrayList.clear();
				request.setAttribute("UserList", objArrayList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(target);

	}
}
