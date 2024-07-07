package com.tempusmachina.app;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import javax.servlet.ServletContext;

@SpringBootTest
class AppApplicationTests {
	
	@MockBean
    private ServletContext servletContext;

}
