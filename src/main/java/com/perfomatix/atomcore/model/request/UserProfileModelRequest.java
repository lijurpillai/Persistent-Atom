package com.perfomatix.atomcore.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserProfileModelRequest {
	@NotNull @NotEmpty @Size(min=2, max=30)
	private String firstName;
	@NotNull @NotEmpty @Size(min=2, max=30)
	private String lastName;
	@NotNull @NotEmpty
	private String roleDesc;
	@NotNull @NotEmpty
	private String roleId;
	@NotNull @NotEmpty
	private String org;
	@NotNull @NotEmpty
	private String orgId;
	@NotNull @NotEmpty
	private String userId;
	@NotNull @NotEmpty
	private String loginId;
	@NotNull @NotEmpty
	private String password;
	@NotNull @NotEmpty
	private String isActive;
	
	
	public String getRoleDesc() {
		
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
}
