package it.corso.configuration;
import java.io.IOException;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class UploadConfiguration implements ResourceLoaderAware
{
	private ResourceLoader resourceLoader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		this.resourceLoader = resourceLoader;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver()
	{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSizePerFile(3_145_728); //file di max 3MB
		resolver.setMaxInMemorySize(0);
		Resource uploadTempDir = resourceLoader.getResource("/tmp");
		try
		{
			resolver.setUploadTempDir(uploadTempDir);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return resolver;
	}
}