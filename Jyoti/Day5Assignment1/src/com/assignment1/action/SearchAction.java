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
import com.assignment1.logic.SearchLogic;
import com.assignment1.logic.UserListLogic;

public class SearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SearchLogic objSearchLogic = null;
		int count = 0;
		ArrayList<UserListBean> objArrayList = null;
		ArrayList<UserListBean> objArrayList1 = new ArrayList<>();
		UserListLogic objListLogic = new UserListLogic();
		String categoryType = null;
		try {
			String query = "select * from userdetails";
			String userIdSearch = request.getParameter("userName").toString();
			String categorySearch = request.getParameter("category").toString();
			String nameSearch = request.getParameter("firstName").toString();
			String addressSearch = request.getParameter("address").toString();
			String sexSearch = request.getParameter("gender").toString();
			String emailSearch = request.getParameter("email");

			// objArrayList = (ArrayList<UserListBean>)
			// request.getAttribute("UserList");

			objArrayList = objListLogic.getUserList();
			objSearchLogic = new SearchLogic();

			HttpSession session = request.getSession();
			String userName = session.getAttribute("UserName").toString();
			String password = session.getAttribute("Password").toString();

			for (int i = 0; i < objArrayList.size(); i++) {

				if (userName.equals(objArrayList.get(i).getUserName())
						&& password.equals(objArrayList.get(i).getPassword())) {
					categoryType = objArrayList.get(i).getCategory();
				}
			}
			request.setAttribute("categoryType", categoryType);
			if (userIdSearch.equals("") && categorySearch.equals("")
					&& nameSearch.equals("") && addressSearch.equals("")
					&& sexSearch.equalsIgnoreCase("")
					&& emailSearch.equalsIgnoreCase("")) {

				if (categoryType.equalsIgnoreCase("admin")) {
					request.setAttribute("UserList", objArrayList);
				} else if (categoryType.equalsIgnoreCase("user")) {
					for (int i = 0; i < objArrayList.size(); i++) {
						if (objArrayList.get(i).getUserName().equals(userName)
								&& objArrayList.get(i).getPassword()
										.equalsIgnoreCase(password)) {
							objArrayList1.add(objArrayList.get(i));
							request.setAttribute("UserList", objArrayList1);
						}
					}
				}
			} else {
				if (!userIdSearch.equalsIgnoreCase("")) {
					if (count > 0) {
						query = query + " and ";
					} else {
						query = query + " where ";
					}
					query = query + " USERID='" + userIdSearch.trim() + "'";
					count++;
				}
				if (!categorySearch.equals("")) {

					if (count > 0) {
						query = query + " and ";
					} else {
						query = query + " where ";
					}
					query = query + " CATEGORY='" + categorySearch.trim() + "'";
					count++;

				}
				if (!nameSearch.equalsIgnoreCase("")) {
					if (count > 0) {
						query = query + " and ";
					} else {
						query = query + " where ";
					}
					query = query
							+ " (SALUTAION +' '  +FIRSTNAME + ' ' +MIDDLEINITIAL +' '  +LASTNAME) like '%"
							+ nameSearch.trim() + "%'";
					count++;
				}
				if (!addressSearch.equalsIgnoreCase("")) {
					if (count > 0) {
						query = query + " and ";
					} else {
						query = query + " where ";
					}
					query = query + " ADDRESS like '%" + addressSearch.trim()
							+ "%'";
					count++;
				}
				if (!sexSearch.equalsIgnoreCase("")) {
					if (count > 0) {
						query = query + " and ";
					} else {
						query = query + " where ";
					}
					query = query + " SEX='" + sexSearch.trim() + "'";
					count++;
				}
				if (!emailSearch.equalsIgnoreCase("")) {
					if (count > 0) {
						query = query + " and ";
					} else {
						query = query + " where ";
					}
					query = query + " EMAILID='" + emailSearch.trim() + "'";
					count++;
				}

				objArrayList = objSearchLogic.getList(query);
				request.setAttribute("UserList", objArrayList);
			}

		} catch (Exception e) {

		}
		return mapping.findForward("setAllList");
	}
}
