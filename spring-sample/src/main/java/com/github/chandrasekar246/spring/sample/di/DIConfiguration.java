
package com.github.chandrasekar246.spring.sample.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value={"com.github.chandrasekar246.spring.sample.di"})
public class DIConfiguration {

	@Bean
	public MessageService getMessageService(){
//		return new EmailService();
		return new TwitterService();
	}
}
