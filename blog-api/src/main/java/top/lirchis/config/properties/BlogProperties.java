package top.lirchis.config.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "blog")
public class BlogProperties {
	/**
	 * 博客名称
	 */
	private String name;
	/**
	 * 博客后端接口URL
	 */
	private String api;
	/**
	 * 博客前端后台管理URL
	 */
	private String cms;
	/**
	 * 博客前端前台页面URL
	 */
	private String view;
}