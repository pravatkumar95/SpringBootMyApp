package com.centroxy.model;

import java.time.LocalDate;

import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.ToString;
@Document
@AllArgsConstructor
@ToString
public class Employee {
	
	@Id
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate joinDate;
    private LocalDate LeaveDate;
    private long joinTimeStamp;
    public long getJoinTimeStamp() {
		return joinTimeStamp;
	}
	public void setJoinTimeStamp(long joinTimeStamp) {
		this.joinTimeStamp = joinTimeStamp;
	}
	public long getLeaveTimeStamp() {
		return leaveTimeStamp;
	}
	public void setLeaveTimeStamp(long leaveTimeStamp) {
		this.leaveTimeStamp = leaveTimeStamp;
	}
	private long leaveTimeStamp;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public LocalDate getLeaveDate() {
		return LeaveDate;
	}
	public void setLeaveDate(LocalDate leaveDate) {
		LeaveDate = leaveDate;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", joinDate=" + joinDate
				+ ", LeaveDate=" + LeaveDate + ", joinTimeStamp=" + joinTimeStamp + ", leaveTimeStamp=" + leaveTimeStamp
				+ "]";
	}
	
	
	

}
