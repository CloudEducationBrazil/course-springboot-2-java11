package com.educandoweb.coursejava.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Especificação do JPA - O hibernate eh a implementação do JPA
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Interface Serializable = Para que os objetos possam ser transformados em cadeias de bytes 
// gravados em arquivos para trafegar na rede
@Entity
@Table(name = "tb_user")
public class User implements Serializable { // Jackson, biblioteca que faz a serialização do JSON
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	// Associação - Diagrama de Classe DER // To many association ele faz o lazing loading, 
	// somente o JPA não carrega os objetos para muitos, para não estourar a memória do computador
	// Em properties a instrução "spring.jpa.open-in-view", tem que está TRUE. Ex.: spring.jpa.open-in-view=true
	// Para reinderizar o JSON no final do ciclo de vida da class invocando o JPA
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public User() {
	}
	
	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public List<Order> getOrders() {
		return orders;
	}	
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override // hashCode, Serve para comparar objetos
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password=" + password
				+ "]";
	}
}
