package top.lirchis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.lirchis.config.properties.UploadProperties;
import top.lirchis.interceptor.AccessLimitInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	AccessLimitInterceptor accessLimitInterceptor;
	@Autowired
	UploadProperties uploadProperties;

	/**
	 * 跨域请求
	 *
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedHeaders("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
				.maxAge(3600);
	}

	/**
	 * 请求拦截器
	 *
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accessLimitInterceptor);
	}

	/**
	 * 本地静态资源路径映射
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(uploadProperties.getAccessPath()).addResourceLocations(uploadProperties.getResourcesLocations());
	}
}
