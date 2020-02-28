package atlantic.spprev.modelo;

public class Personagem extends Cla{

	private Integer idP;
	private String nick;
	private Integer levelP;
	private Integer id_cla;

	public Integer getIdP() {
		return idP;
	}

	public void setIdP(Integer idP) {
		this.idP = idP;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getLevelP() {
		return levelP;
	}

	public void setLevelP(Integer levelP) {
		this.levelP = levelP;
	}

	public Integer getId_cla() {
		return id_cla;
	}

	public void setId_cla(Integer id_cla) {
		this.id_cla = id_cla;
	}

}
