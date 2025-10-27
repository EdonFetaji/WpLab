package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import mk.ukim.finki.wp.lab.web.servlet.BookListServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring6.SpringTemplateEngine;
import mk.ukim.finki.wp.lab.repository.implementation.InMemoryBookRepository;


@ServletComponentScan
@SpringBootApplication(exclude = {
        WebMvcAutoConfiguration.class
})
public class Lab1AApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1AApplication.class, args);
    }
//
//    @Bean
//    public ServletRegistrationBean<BookListServlet> bookListServlet(@Qualifier("bookServiceImpl") BookService service, SpringTemplateEngine engine) {
//        return new ServletRegistrationBean<>(new BookListServlet(engine, service), "/");
//    }

}
