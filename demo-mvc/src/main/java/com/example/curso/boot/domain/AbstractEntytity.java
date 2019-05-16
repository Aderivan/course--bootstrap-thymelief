package com.example.curso.boot.domain;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntytity<ID extends Serializable> implements Serializable {
	// o abstract faz com que essa classe seja usada através de herança e não por instância
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY é o auto incremento do mySQL
	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AbstractEntytity<?> other = (AbstractEntytity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " id= " + id;
	}
	
}
