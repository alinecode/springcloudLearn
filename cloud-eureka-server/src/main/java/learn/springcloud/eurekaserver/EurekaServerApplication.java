package learn.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 生成demo https://start.spring.io/ 
 * 
 * cloud api https://cloud.spring.io/spring-cloud-static/Greenwich.M3/multi/multi_spring-cloud.html
 * 
 * Eureka官方简介 https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance
 * 
 * @author 
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
    
    /**
     * 关闭/放行csrf，否则客户端启动报错：Cannot execute request on any known server
     * api相关： https://cloud.spring.io/spring-cloud-static/Greenwich.M3/single/spring-cloud.html#_securing_the_eureka_server
     * @author 
     *
     */
    @EnableWebSecurity
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            super.configure(http); // 密码验证服务等
//            http.csrf().disable();  // 关闭csrf
            http.csrf().ignoringAntMatchers("/eureka/**"); // 仅忽略关闭特定的url的csrf
        }
    }
    
}
