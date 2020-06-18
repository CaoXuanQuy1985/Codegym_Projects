package cg.wbd.grandemonstration;

/*import cg.wbd.grandemonstration.controller.CustomerController;*/
/*import cg.wbd.grandemonstration.service.CustomerService;*/
/*import cg.wbd.grandemonstration.service.ProvinceService;*/
/*import cg.wbd.grandemonstration.service.impl.CustomerServiceImplWithSpringData;*/
/*import cg.wbd.grandemonstration.service.impl.ProvinceServiceImplWithSpringData;*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
/*@ComponentScan(basePackageClasses=CustomerController.class)*/
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

    /*@Bean
    public CustomerService customerService() {
        return new CustomerServiceImplWithSpringData();
    }*/

/*    @Bean
    public ProvinceService provinceService() {
        return new ProvinceServiceImplWithSpringData();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
