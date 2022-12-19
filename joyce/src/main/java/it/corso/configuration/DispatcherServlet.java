package it.corso.configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[] {ContextConfiguration.class};
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] {"/"};
	}
}