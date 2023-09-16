package lastshixun;

public class Desk {
	private int id;//序号
	private String no;//餐台编号
	private int seating;//座位数
	private String status;//状态为：已预定、就餐中、已结账
	public Desk() {}
	public Desk(int id, String no, int seating, String status) {
		this.id = id;
		this.no = no;
		this.seating = seating;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public int getSeating() {
		return seating;
	}
	public void setSeating(int seating) {
		this.seating = seating;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
