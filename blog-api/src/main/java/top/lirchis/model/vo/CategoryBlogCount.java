package top.lirchis.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryBlogCount {
	private Long id;
	private String name;//分类名
	private Integer value;//分类下博客数量
}
