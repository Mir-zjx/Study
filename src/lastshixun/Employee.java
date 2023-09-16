package lastshixun;

public class Employee {
	int id;
	String name;
	String sex;
	String birthday;
	String identityID;
	String address;
	String tel;
	String position;
	String freeze;
	
	public Employee(int id, String name, String sex, String birthday, String identityID, String address, String tel,
			String position, String freeze) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.identityID = identityID;
		this.address = address;
		this.tel = tel;
		this.position = position;
		this.freeze = freeze;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIdentityID() {
		return identityID;
	}
	public void setIdentityID(String identityID) {
		this.identityID = identityID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFreeze() {
		return freeze;
	}
	public void setFreeze(String freeze) {
		this.freeze = freeze;
	}
	
	
}
