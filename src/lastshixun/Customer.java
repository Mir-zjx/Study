package lastshixun;

public class Customer {
	private int id;
	private String name;
	private String sex;
	private String company;
	private String tel;
	private String cardID;//¹ó±ö¿¨ºÅ
	public Customer() {}
	public Customer(int id, String name, String sex, String company, String tel, String cardID) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.company = company;
		this.tel = tel;
		this.cardID = cardID;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
}
