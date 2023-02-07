package top.lirchis.util.comment.channel;

import top.lirchis.model.dto.Comment;

public interface CommentNotifyChannel {
	/**
	 * 通过指定方式通知自己
	 *
	 * @param comment 当前收到的评论
	 */
	void notifyMyself(Comment comment);
}
