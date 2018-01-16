package sg.edu.iss.team1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "userID")
	private int userID;
	@Basic(optional = false)
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;

	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "userrole", joinColumns = {
			@JoinColumn(name = "userID", referencedColumnName = "userID") }, inverseJoinColumns = {
					@JoinColumn(name = "roleID", referencedColumnName = "roleID") }

	)
	private List<Role> roleSet;
	
	@Transient
	private ArrayList<String> roleIDs = new ArrayList<String>();

	public User() {
	}

	public User(int userID, String name, String password) {
		this.userID = userID;
		this.name = name;
		this.password = password;
	}

	public User(int userID) {
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(ArrayList<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public ArrayList<String> getRoleIds() {
		ArrayList<Role> rList = (ArrayList<Role>) this.getRoleSet();
		ArrayList<String> roleIDs = new ArrayList<String>();
		for (Role role : rList) {
			roleIDs.add(role.getRoleID());
		}
		return roleIDs;
	}

	public void setRoleIDs(ArrayList<String> roleIDs) {

		this.roleIDs = roleIDs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userID;
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
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", password=" + password
				+ ", roleSet=" + roleSet + ", roleIds=" + roleIDs + "]";
	}

}
	