package com.giyu.GamingClub.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="member")

public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float balance=0;
	private String phone;
	
	@OneToMany(mappedBy="member")
	List<Recharge> recharges;
	
	public List<Recharge> getRecharges(){
		return recharges;
	}
	
	public void setRecharges(List<Recharge> recharges) {
		this.recharges = recharges;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
