package shixun4;

import java.util.*;

abstract class RecordScore {
	private Map<String, List<Integer>> rs;

	public RecordScore() {
		rs = new HashMap<String, List<Integer>>();
	}

	public void setScore(String name, List<Integer> score) {
		rs.put(name, score);
	}

	public void setScore(String name, int c, int m, int e) {
		rs.put(name, Arrays.asList(c, m, e));

	}
	public Map<String, List<Integer>> getRs(){
		return rs;
	}
	abstract public void save() throws Exception;
}

