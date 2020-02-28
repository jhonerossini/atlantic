package atlantic.spprev.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import atlantic.spprev.jdbc.dao.PersonagemDAO;
import atlantic.spprev.modelo.Personagem;

public class PersonagemForm extends ActionForm {

	private List<Personagem> lista;

	public List<Personagem> getLista() {
		return lista;
	}

	public void setLista(List<Personagem> lista) {
		this.lista = lista;
	}

}
