package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Animal;
import util.ConnectionUtil;

public class AnimalOracle implements AnimalDao {

	private static final Logger log = LogManager.getLogger(AnimalOracle.class);

	public List<Animal> getAll() throws Exception {
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.error("Connection was null");
			throw new Exception("Unable to connect to database");
		}

		List<Animal> list;
		
		try {			
			String sql = "select * from animal";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			list = new LinkedList<Animal>();
			
			while (rs.next()) {
				list.add(new Animal(rs.getInt("id"), rs.getString("name"), rs.getInt("safty")));
			}
		} catch (SQLException e) {
			log.error("Unable to execute sql query", e);
			throw new Exception("Unable to connect to database");
		}

		return list;
	}

	public void insert(Animal a) {
		// TODO Auto-generated method stub

	}

}
