package com.org.rkv.useraccount;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class BankingUserAccountRegistrationApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankingUserAccountRegistrationApplication.class, args);
	}

}
