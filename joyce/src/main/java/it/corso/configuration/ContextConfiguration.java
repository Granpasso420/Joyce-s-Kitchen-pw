package it.corso.configuration;
import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"it.corso.controller","it.corso.service","it.corso.dao","it.corso.configuration"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
@EnableJpaRepositories(basePackages = {"it.corso.dao"}, entityManagerFactoryRef = "emf", transactionManagerRef = "tmf")
public class ContextConfiguration implements WebMvcConfigurer
{
	@Autowired
	private Environment env;
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message");
		return source;
	}
	
	@Bean
	public SpringResourceTemplateResolver templateResolver()
	{
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		resolver.setCacheable(true);
		return resolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine()
	{
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.setTemplateEngineMessageSource(messageSource());
		return engine;
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver()
	{
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		return resolver;
	}
	
	@Bean
	public LocalValidatorFactoryBean validator()
	{
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Override
	public Validator getValidator()
	{
		return validator();
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter()
	{
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
		return adapter;
	}
	
	@Bean(name = "emf")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setJpaVendorAdapter(getJpaVendorAdapter());
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan("it.corso.model");
		bean.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		bean.setValidationMode(ValidationMode.NONE);
		return bean;
	}
	
	@Bean(name = "tmf")
	public JpaTransactionManager getJpaTransactionManager()
	{
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return manager;
	}
}