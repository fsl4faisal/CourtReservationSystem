package com.faisal.court.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
	@NotNull
	@Size(min=2)
	private String name;
	
	@NotNull
	@Size(min=9,max=14)
	private String phone;
	
	@Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	public Member(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public Member(){}
}
