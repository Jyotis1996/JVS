package com.assignment1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.assignment1.bean.LoginBean;
import com.assignment1.logic.LoginLogic;

/**
 * This class validate the user and redirect to success page if details are
 * correct otherwise redirect to same page
 * @author Jyoti date-2019/09/09
 *
 */
public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		LoginBean objLoginForm = null;
		LoginLogic objLoginLogic = null;
		ActionErrors errors = null;
		ActionForward forward = new ActionForward();
		String target = "";
		HttpSession session = request.getSession();
		//UserListAction objUserListAction=null;
		try {
			// initialize the ActionError class object
			errors = new ActionErrors();
			//objUserListAction=new UserListAction();
			objLoginLogic = new LoginLogic();
			objLoginForm = (LoginBean) form;
			session.setAttribute("userName", objLoginForm.getUserName());
			session.setAttribute("password", objLoginForm.getPassword());
			// Check the user is valid or not
			if (objLoginLogic.validateUser(objLoginForm.getUserName(),
					objLoginForm.getPassword())) {
				target = "success";
			} else {
				// add error message
				errors.add("error_msg", new ActionMessage(
						"LoginAuthentication.error"));
				target = "failure";
			}
		} catch (Exception e) {
			errors.add("name", new ActionMessage("id"));
		}
		// check there is any errors or not
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			forward = mapping.findForward(target);
		} else {
			// redirect to success page
			forward = mapping.findForward(target);
		}
		return forward;
	}
}
