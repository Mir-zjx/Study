package lastshixun;

import java.sql.ResultSet;

public interface IBaseDAO<T> {
	public void add(T t);
	public void delete(int id);
	public void update(int id,T t);
	public ResultSet query();
	public ResultSet query_1(int id);
}
