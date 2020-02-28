package atlantic.spprev.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import atlantic.spprev.modelo.Cla;

public class ClaDAO {

	public void inserir(Cla cla) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into tb_cla (idC, nome)values(?, ?)");
			ps.setInt(1, cla.getIdC());
			ps.setString(2, cla.getNome());

			ps.execute();
			ps.close();
			con.close();
			System.out.println("inserido com sucesso");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(Cla cla) {
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("update tb_cla set ?,?,? where idp=" + cla.getIdC());
			ps.setInt(1, cla.getIdC());
			ps.setString(2, cla.getNome());

			ps.execute();
			ps.close();
			con.close();
			System.out.println("inserido com sucesso");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean excluir(Cla cla) {
		boolean retorno = false;
		try {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from tb_cla where idc=" + cla.getIdC());
			retorno = ps.execute();
			ps.close();
			con.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public List<Cla> listar() {
		Connection con;
		List<Cla> lista = new ArrayList<Cla>();
		Cla c = new Cla();
		try {
			System.out.println("Antes da conexao");
			con = Conexao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from tb_cla");
			ResultSet rs = ps.executeQuery();

			System.out.println("Inicio do while");
			while (rs.next()) {
				c.setIdC(rs.getInt("idc"));
				c.setNome(rs.getString("nome"));
				System.out.println("ID: " + c.getIdC());
				System.out.println("Nome: " + c.getNome());
				lista.add(c);
				c = new Cla();
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
