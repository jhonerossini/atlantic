package atlantic.spprev.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import atlantic.spprev.jdbc.dao.ClaDAO;
import atlantic.spprev.modelo.Cla;

public class ClaAction extends DispatchAction {
	
	
	public ActionForward salvar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		Cla cla = new Cla();
		cla.setIdC(Integer.parseInt(request.getParameter("id")));
		cla.setNome(request.getParameter("nick"));
		
		new ClaDAO().inserir(cla);
		
		return mapping.findForward("sucess");
	}
}
