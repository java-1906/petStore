package models;

import java.io.Serializable;

public class Animal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2360478139566169242L;
	private Integer id;
	private String name;
	private Integer safty;
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Animal(Integer id, String name, Integer safty) {
		super();
		this.id = id;
		this.name = name;
		this.safty = safty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSafty() {
		return safty;
	}

	public void setSafty(Integer safty) {
		this.safty = safty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((safty == null) ? 0 : safty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (safty == null) {
			if (other.safty != null)
				return false;
		} else if (!safty.equals(other.safty))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", safty=" + safty + "]";
	}
}
