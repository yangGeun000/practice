package green.spring.hello;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	private String name;
	private int korean;
	private int english;
	private int math;
	
	public int getTotal() {
		return korean+english+math;
	}
	public float getAvg() {
		float avg = (float)getTotal()/3;
		int tmp= (int)(avg*10);
		avg = (float)tmp/10;
		return avg;
	}
}
