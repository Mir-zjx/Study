package lastshixun;

public class OrderItem {
	private int id;//���
	private int orderId;//�������
	private int dishId;//��Ʒ���
	private double amount;//��Ʒ����
	public OrderItem() {}
	public OrderItem( int orderId, int dishId, double amount) {
		super();
		this.orderId = orderId;
		this.dishId = dishId;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
