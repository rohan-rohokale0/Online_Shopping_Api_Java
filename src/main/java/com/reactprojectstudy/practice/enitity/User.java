package com.reactprojectstudy.practice.enitity;
import com.reactprojectstudy.practice.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;


@Entity
@Table(name="users")
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

private String name;

private String email;

private String password;

private UserRole userRole;

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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public UserRole getUserRole() {
	return userRole;
}

public void setUserRole(UserRole userRole) {
	this.userRole = userRole;
}



}
        
