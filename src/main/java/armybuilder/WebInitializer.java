package armybuilder;

import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;

@Configuration
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {
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

	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		super.customizeRegistration(registration);
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
			viewResolver.setExposedContextBeanNames("menu", "markdown");
			return viewResolver;
		}


		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/css/**").addResourceLocations("/css/");
			registry.addResourceHandler("/js/**").addResourceLocations("/js/");
			registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
			registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		}

	}

}
