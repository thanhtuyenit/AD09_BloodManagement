package fpt.ad09.blood_management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detailuser")
public class DetailUser {

	@Id
	@Column(name = "id_user", nullable = false)
	int idUser;

	@Column(name = "fullname", length = 100, nullable = true)
	String fullname;

	@Column(name = "sex", nullable = true)
	int sex;

	@Column(name = "birthday", nullable = true)
	String birthday;

	@Column(name = "phone", length = 50, nullable = true)
	String phone;

	@Column(name = "address", length = 100, nullable = true)
	String address;

	@Column(name = "email", length = 50, nullable = true)
	String email;

	@OneToOne
	@JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
	private User user;

	public DetailUser() {
		super();
	}

	public DetailUser(int idUser, String fullname, int sex, String birthday, String phone, String address,
			String email) {
		super();
		this.idUser = idUser;
		this.fullname = fullname;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
	

	public DetailUser(int idUser, String fullname, int sex, String birthday, String phone, String address, String email,
			User user) {
		super();
		this.idUser = idUser;
		this.fullname = fullname;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.user = user;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "DetailUser [idUser=" + idUser + ", fullname=" + fullname + ", sex=" + sex + ", birthday=" + birthday
				+ ", phone=" + phone + ", address=" + address + ", email=" + email + ", user=" + user + "]";
	}

}
