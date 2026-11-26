package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

	
	@Autowired
	UserService userServ;
	
	@Test
	void userServ_test() {
		assertNotNull(userServ);
		assertNotNull(userServ.getUserRepository());
		assertEquals("MySQL", userServ.getUserRepository().getDbType());
		assertNotNull(userServ.getSecurityService());
		assertTrue(userServ.registerUser("1", "홍길동", "1234"));
		assertFalse(userServ.registerUser("2", "김철수", ""));

	}
	
}
