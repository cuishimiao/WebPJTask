package cn.ncu.bbs.bbs.config;



import cn.ncu.bbs.bbs.component.LoginHandlerInterceptor;
import cn.ncu.bbs.bbs.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public WebMvcConfigurerAdapter WebMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashbord");
                registry.addViewController("/edit.html").setViewName("editperson");
                registry.addViewController("/register.html").setViewName("register");
                registry.addViewController("/postmeeting.html").setViewName("postmeeting");
                registry.addViewController("/meetlist.html").setViewName("mlist");
                registry.addViewController("/infomet.html").setViewName("infomeeting");
                registry.addViewController("/mpermt.html").setViewName("meetingpermt");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/login.html","/user/login","/register.html","/user/register");

            }

        };


        return adapter;
    }


    //将配置放到容器中，让它生效;国际化
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
