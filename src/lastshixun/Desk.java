package lastshixun;

public class Desk {
	private int id;//���
	private String no;//��̨���
	private int seating;//��λ��
	private String status;//״̬Ϊ����Ԥ�����Ͳ��С��ѽ���
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
