package top.lirchis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.lirchis.entity.SiteSetting;

import java.util.List;

@Mapper
@Repository
public interface SiteSettingMapper {
	List<SiteSetting> getList();

	List<SiteSetting> getFriendInfo();

	String getWebTitleSuffix();

	int updateSiteSetting(SiteSetting siteSetting);

	int deleteSiteSettingById(Integer id);

	int saveSiteSetting(SiteSetting siteSetting);

	int updateFriendInfoContent(String content);

	int updateFriendInfoCommentEnabled(Boolean commentEnabled);
}
