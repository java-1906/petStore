package util;

import java.sql.Connection;
import java.util.List;

import dao.AnimalDao;
import dao.AnimalOracle;
import dao.AnimalService;
import models.Animal;

public class Applicaiton {
	public static void main(String[] args) {
		Connection con = ConnectionUtil.getConnection();
		System.out.println(con);
		
		List<Animal> list;
		try {			
			list = AnimalService.getAllAnimals();
		} catch (Exception e) {
			System.out.println("Opps.. (^_^)");
			return;
		}
		
		System.out.println(list);
	}
}
