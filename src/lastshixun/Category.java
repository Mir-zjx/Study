package lastshixun;

public class Category {
	private int id;
	private String name;
	private String describ;
	public Category() {}
	public Category(int id, String name, String describ) {
		this.id = id;
		this.name = name;
		this.describ = describ;
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
	public String getDescrib() {
		return describ;
	}
	public void setDescrib(String describ) {
		this.describ = describ;
	}
	
}
