package com.assignment1.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.assignment1.bean.UserListBean;
import com.assignment1.logic.DeleteUserLogic;
import com.assignment1.logic.UserListLogic;

/**
 * DeleteUser Action class to perform delete action
 * @author Jyoti date-2019/09/09
 *
 */
public class DeleteUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] userValues = null;
		DeleteUserLogic objDeleteUserLogic=null;
		UserListLogic objListLogic=null;
		ArrayList<UserListBean> objArrayList=null;
		String target = "";
		ActionForward forward = new ActionForward();
		int k=0;
		try {
			objListLogic=new UserListLogic();
			objDeleteUserLogic=new DeleteUserLogic();
			userValues = (String[]) request.getParameterValues("hiddenValues");

			for(int i=0; i<userValues.length;i++){
				System.out.println(userValues[i]);
				k=objDeleteUserLogic.deleteRow(userValues[i]);
			}
			if(k>0){
				target = "success";
			}
			String categoryType = request.getParameter("catType").toString();
			request.setAttribute("categoryType", categoryType);
			objArrayList=objListLogic.getUserList();
			request.setAttribute("UserList", objArrayList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = mapping.findForward(target);

		return forward;
	}
}
