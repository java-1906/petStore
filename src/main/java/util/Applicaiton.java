package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.List;

import dao.AnimalDao;
import dao.AnimalOracle;
import dao.AnimalService;
import models.Animal;

public class Applicaiton {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		System.out.println(con);
		
		List<Animal> list;
		try {			
			list = AnimalService.getAllAnimals();
		} catch (Exception e) {
			System.out.println("Opps.. (^_^)");
			return;
		}
		
		//createPet(2, "Frank", 2, list.get(0).getId());
		createPuppy("Aasdf", 1, 1);
		System.out.println(list);
		
		
		int id = createAnimal("Aligator", 3);
		createPuppy("Shaun", 100, id);
		createPuppy("Marie", 100, id);
	}
	
	
	public static void createPet(int id, String name, int age, int animal_id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "INSERT INTO PET (id, name, age, ANIMAL_ID) VALUES(?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setInt(4, animal_id);
		ps.execute();
	}
	
	public static void createPuppy(String name, int age, int animal_id) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "call create_puppy(?, ?, ?, ?)";
		CallableStatement ps = con.prepareCall(sql);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, animal_id);
		ps.registerOutParameter(4, Types.INTEGER);
		ps.execute();
		int id = ps.getInt(4);
		System.out.println(id);
	}
	
	public static int createAnimal(String name, int safty) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "call create_animal(?, ?, ?)";
		CallableStatement ps = con.prepareCall(sql);
		ps.setString(1, name);
		ps.setInt(2, safty);
		ps.registerOutParameter(3, Types.INTEGER);
		ps.execute();
		int id = ps.getInt(3);
		return id;
	}
}
