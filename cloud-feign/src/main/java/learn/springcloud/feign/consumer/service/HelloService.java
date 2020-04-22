package learn.springcloud.feign.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * 网上有的文章说引入的依赖是spring-cloud-starter-feign，其实官方不再推荐使用，推荐使用spring-cloud-starter-openfeign
 * 
 * 因为Feign中已经依赖了Hystrix，所以在Maven配置上不用做任何改动。
 * 关于单独引入Hystrix依赖，网上有的文章说引入的依赖是spring-cloud-starter-hystrix，其实官方不在推荐使用，推荐使用spring-cloud-starter-netflix-hystrix
 * 
 * https://note.youdao.com/ynoteshare1/index.html?id=2f175a5a86dc34537ccf6a97ba35d1ed&type=note
 * 
 * @author  
 *
 */
@Service
@FeignClient(name = "hello-service666") // 调用的注册client名称
public interface HelloService {
    @RequestMapping("/hello2") // 该client下的controller，这里可以使用springMvc注解
    String helloworld(@RequestHeader HttpServletRequest request); // 参数
}
