package atlantic.spprev.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atlantic.spprev.modelo.Personagem;

public class PersonagemDAO {

	public void inserir(Personagem personagem) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into tb_personagem(idP, nick, levelp, id_cla)values(?,?,?,?)");

			ps.setInt(1, personagem.getIdP());
			ps.setString(2, personagem.getNick());
			ps.setInt(3, personagem.getLevelP());
			ps.setInt(4, personagem.getId_cla());

			ps.execute();
			ps.close();
			con.close();
			System.out.println("inserido com sucesso");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Personagem personagem) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update tb_personagem set ?,?,? where idp=" + personagem.getIdP());
			ps.setString(1, personagem.getNick());
			ps.setInt(2, personagem.getLevelP());
			ps.setInt(3, personagem.getId_cla());

			ps.execute();
			ps.close();
			con.close();
			System.out.println("inserido com sucesso");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean excluir(Personagem personagem) {
		boolean retorno = false;
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from tb_personagem where idp=" + personagem.getIdP());
			retorno = ps.execute();
			ps.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public List<Personagem> listar() {
		Connection con;
		List<Personagem> lista = new ArrayList<Personagem>();
		Personagem p = new Personagem();
		try {
			System.out.println("Antes da conexao");
			con = Conexao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from tb_personagem inner join tb_cla on id_cla = idc");
			ResultSet rs = ps.executeQuery();

			System.out.println("Inicio do while");
			while (rs.next()) {
				p.setIdP(rs.getInt("idp"));
				p.setNick(rs.getString("nick"));
				p.setLevelP(rs.getInt("levelp"));
				p.setId_cla(rs.getInt("id_cla"));
				p.setNome(rs.getString("nome"));
				System.out.println("ID: " + p.getIdP());
				System.out.println("Nick: " + p.getNick());
				System.out.println("Level: " + p.getLevelP());
				System.out.println("ID cla: " + p.getId_cla());
				lista.add(p);
				p = new Personagem();
			}
			ps.close();
			con.close();
			System.out.println("Fim do while");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
