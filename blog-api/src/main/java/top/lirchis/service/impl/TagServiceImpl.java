package top.lirchis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lirchis.constant.RedisKeyConstants;
import top.lirchis.entity.Tag;
import top.lirchis.exception.NotFoundException;
import top.lirchis.exception.PersistenceException;
import top.lirchis.mapper.TagMapper;
import top.lirchis.service.RedisService;
import top.lirchis.service.TagService;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
	@Autowired
	TagMapper tagMapper;
	@Autowired
	RedisService redisService;

	@Override
	public List<Tag> getTagList() {
		return tagMapper.getTagList();
	}

	@Override
	public List<Tag> getTagListNotId() {
		String redisKey = RedisKeyConstants.TAG_CLOUD_LIST;
		List<Tag> tagListFromRedis = redisService.getListByValue(redisKey);
		if (tagListFromRedis != null) {
			return tagListFromRedis;
		}
		List<Tag> tagList = tagMapper.getTagListNotId();
		redisService.saveListToValue(redisKey, tagList);
		return tagList;
	}

	@Override
	public List<Tag> getTagListByBlogId(Long blogId) {
		return tagMapper.getTagListByBlogId(blogId);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveTag(Tag tag) {
		if (tagMapper.saveTag(tag) != 1) {
			throw new PersistenceException("标签添加失败");
		}
		redisService.deleteCacheByKey(RedisKeyConstants.TAG_CLOUD_LIST);
	}

	@Override
	public Tag getTagById(Long id) {
		Tag tag = tagMapper.getTagById(id);
		if (tag == null) {
			throw new NotFoundException("标签不存在");
		}
		return tag;
	}

	@Override
	public Tag getTagByName(String name) {
		return tagMapper.getTagByName(name);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteTagById(Long id) {
		if (tagMapper.deleteTagById(id) != 1) {
			throw new PersistenceException("标签删除失败");
		}
		redisService.deleteCacheByKey(RedisKeyConstants.TAG_CLOUD_LIST);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateTag(Tag tag) {
		if (tagMapper.updateTag(tag) != 1) {
			throw new PersistenceException("标签更新失败");
		}
		redisService.deleteCacheByKey(RedisKeyConstants.TAG_CLOUD_LIST);
		//修改了标签名或颜色，可能有首页文章关联了标签，也要更新首页缓存
		redisService.deleteCacheByKey(RedisKeyConstants.HOME_BLOG_INFO_LIST);
	}
}
