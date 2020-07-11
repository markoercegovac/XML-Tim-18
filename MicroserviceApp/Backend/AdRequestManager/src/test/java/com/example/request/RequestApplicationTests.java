package com.example.request;

import com.example.request.model.AdvertStateEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestApplicationTests {

	@Test
	void contextLoads() {

		AdvertStateEnum e = AdvertStateEnum.APPROVED;
		String a = "APPROVED";

		assert (e.equals(AdvertStateEnum.valueOf(a)));
		System.out.println("---------ENUM: "+ AdvertStateEnum.valueOf(a));
	}

}
