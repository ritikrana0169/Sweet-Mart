package com.masai.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@NotNull(message = "Name of customer can't be Null")
	private String name;
	@NotNull(message = "Email of customer can't be Null")
	@Email(message = "Email should be in proper Format")
	@Column(unique = true)
	private String email;
	@NotNull(message = "Password of customer can't be Null")
	private String password;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private boolean active=true;
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	private String role = "ROLE_CUSTOMER";
	
//	@JsonIgnore
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	private Cart cart;


	public boolean getActive() {
		return this.active;
	}
	
}
