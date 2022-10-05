package green.spring.greenBBS;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
	// 우편번호
	private String postCode;
	
	// 위치
	private String location;
}
