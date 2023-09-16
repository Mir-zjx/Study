package lastshixun;

public class Dish {	
	private int id;
	private String name;
	private int categoryId;
	private String code;
	private String unit;
	private double price;
	private String status;
	public Dish() {}
	public Dish(int id, String name, int categoryId,String code, 
			String unit, double price,String status) {
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.code = code;
		this.unit = unit;
		this.price = price;
		this.status = status;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
