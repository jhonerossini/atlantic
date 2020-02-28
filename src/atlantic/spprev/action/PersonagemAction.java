package atlantic.spprev.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import atlantic.spprev.form.PersonagemForm;
import atlantic.spprev.jdbc.dao.ClaDAO;
import atlantic.spprev.jdbc.dao.PersonagemDAO;
import atlantic.spprev.modelo.Cla;
import atlantic.spprev.modelo.Personagem;

public class PersonagemAction extends DispatchAction {

	public ActionForward cadAltPer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Cla> listcla = new ClaDAO().listar();
		request.setAttribute("listacla", listcla);
		return mapping.findForward("sucess");
	}

	public ActionForward listar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		List<Personagem> lista = new PersonagemDAO().listar();
		PersonagemForm perForm = new PersonagemForm();
		perForm.setLista(lista);
		request.setAttribute("lista", lista);
		return mapping.findForward("sucess");
	}

	//
	public ActionForward salvar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		Personagem personagem = new Personagem();
		personagem.setIdP(Integer.parseInt(request.getParameter("id")));
		personagem.setNick(request.getParameter("nick"));
		personagem.setLevelP(Integer.parseInt(request.getParameter("level")));
		personagem.setId_cla(Integer.parseInt(request.getParameter("ncla")));

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("nick"));
		System.out.println(request.getParameter("level"));
		System.out.println(request.getParameter("ncla"));

		new PersonagemDAO().inserir(personagem);

		return mapping.findForward("sucess");
	}

}
