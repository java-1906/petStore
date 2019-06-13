package dao;

import java.util.List;

import models.Animal;

public class AnimalService {
	private static final AnimalDao dao = new AnimalOracle();
	
	public static List<Animal> getAllAnimals() throws Exception {
		return dao.getAll();
	}
}
