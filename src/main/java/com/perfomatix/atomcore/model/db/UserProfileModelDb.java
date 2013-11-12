package com.perfomatix.atomcore.model.db;

	import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

	//@Document(collection="userprofile")
	public class UserProfileModelDb {
		
		@Id
		private String id;
		private String firstName;
		private String lastName;
		private String roleDesc;
		private String roleId;		
		private String org;
		private String orgId;
		private String userId;
		private String loginId;
		private String password;
		private String isActive;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
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
		public String getIsActive() {
			return isActive;
		}
		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}
	}
