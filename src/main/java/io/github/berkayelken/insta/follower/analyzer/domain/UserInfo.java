package io.github.berkayelken.insta.follower.analyzer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfo {
	private String href;
	private String value;
	private long timestamp;
}
