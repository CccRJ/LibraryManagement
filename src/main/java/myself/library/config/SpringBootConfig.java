package myself.library.config;

import myself.library.interceptor.HostInfoInterceptor;
import myself.library.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: library
 * @description:
 * @author: ChaiRJ
 * @create: 2020-08-26 21:40
 **/

@Configuration
public class SpringBootConfig implements WebMvcConfigurer {
    @Autowired
    private HostInfoInterceptor hostInfoInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(hostInfoInterceptor).addPathPatterns("/**");

                registry.addInterceptor(loginInterceptor).addPathPatterns("/books/**");
            }
        };
    }
}
