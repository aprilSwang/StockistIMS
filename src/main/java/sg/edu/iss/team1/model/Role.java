
package sg.edu.iss.team1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Course class
 *
 * @version $Revision: 1.0
 */
@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "roleID")
	private String roleID;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
		public Role() {
	}
   // @OneToOne
   // @JoinColumn()
    //private Customer customer;
	public Role(String roleID, String name, String description) {

		this.roleID = roleID;
		this.name = name;
		this.description = description;

	}

	public Role(String roleID) {
		this.roleID = roleID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleID == null) ? 0 : roleID.hashCode());
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
		Role other = (Role) obj;
		if (roleID == null) {
			if (other.roleID != null)
				return false;
		} else if (!roleID.equals(other.roleID))
			return false;
		return true;
	}


	
	

}