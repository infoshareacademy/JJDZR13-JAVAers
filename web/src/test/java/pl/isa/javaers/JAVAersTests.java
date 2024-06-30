package pl.isa.javaers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class JAVAersTests {

	@Autowired
	WebApplicationContext context;
	@Autowired
	MockMvc mockMvc;


	@Test
	void contextLoads() {
		assertNotNull(context);
	}

	/*void TestSth(){
		mockMvc.perform(get())
	}*/

}
