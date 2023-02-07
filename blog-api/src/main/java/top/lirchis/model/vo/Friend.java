package top.lirchis.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Friend {
	private String nickname;//昵称
	private String description;//描述
	private String website;//站点
	private String avatar;//头像
}
