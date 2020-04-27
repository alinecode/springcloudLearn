package learn.springcloud.feign.consumer.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class HelloFailFactory implements FallbackFactory<HelloService> {

	@Override
	public HelloService create(Throwable cause) {
		
		String msgString = ( cause==null || cause.getMessage() == null )? "service error" : cause.getMessage();
		
		// 返回一个重写的HelloService
		return new HelloService() {
			@Override
			public String helloworld(HttpServletRequest request) {
				
				return msgString;
			}
		};
	}

}
