package dao;

import java.util.List;

import models.Animal;

public interface AnimalDao {
	List<Animal> getAll() throws Exception;
	void insert(Animal a) throws Exception;
}
