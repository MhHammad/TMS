package com.app.pojos;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="admin")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Admin extends  BaseEntity {
	
	@Column(length = 50, unique = true)
	private String email;

	@Column(length = 50, nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	private String confirmPassword;

	@Column(length = 50)
	private String name;

	@Column(length = 10)
	private String phoneNo;

	@Column(length = 10, unique = true)
	private String alternateNo;

}
