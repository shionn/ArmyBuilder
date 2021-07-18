package armybuilder;

import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
		super.onStartup(servletContext);
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	//
	// @Override
	// protected Filter[] getServletFilters() {
	// return new Filter[] { new CharacterEncodingFilter("UTF-8"), new RequestContextFilter(),
	// new DelegatingFilterProxy("springSecurityFilterChain") };
	// }

	@Override
	public void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

	@EnableWebMvc
	// @EnableScheduling
	@Configuration
	@ComponentScan({ "armybuilder" })
	// @PropertySource("classpath:configuration.properties")
	public static class WebMvcConfig implements WebMvcConfigurer {
		@Bean
		public InternalResourceViewResolver viewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setViewClass(JstlView.class);
			viewResolver.setPrefix("/WEB-INF/jsp/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/css/**").addResourceLocations("/css/");
			registry.addResourceHandler("/js/**").addResourceLocations("/js/");
			registry.addResourceHandler("/font/**").addResourceLocations("/font/");
			registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		}

	}
}
