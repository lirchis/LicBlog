package top.lirchis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.lirchis.entity.Category;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
	List<Category> getCategoryList();

	List<Category> getCategoryNameList();

	int saveCategory(Category category);

	Category getCategoryById(Long id);

	Category getCategoryByName(String name);

	int deleteCategoryById(Long id);

	int updateCategory(Category category);
}
