package green.spring.greenBBS;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	// 유저ID
	private String userId;
	
	// 비밀번호
	private String password;
	
	// 이름
	private String userName;
	
	// 이메일
	private String userEmail;
	
	// 생년월일
	private LocalDate birthday;
	
	// 주소
	private Address address;

}
