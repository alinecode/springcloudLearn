package learn.springcloud.feign.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Service
@FeignClient(name = "hello-service666") // 调用的注册client名称
public interface HelloService {
    @RequestMapping("/hello2") // 该client下的controller，这里可以使用springMvc注解
    String helloworld(@RequestHeader HttpServletRequest request); // 参数
}
