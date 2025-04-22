package io.github.berkayelken.insta.follower.analyzer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Getter
@Setter
@ToString
public class UserInfo {
	private String href;
	private String value;
	private long timestamp;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if(!StringUtils.hasText(value))
			return false;
		UserInfo userInfo = (UserInfo) o;
		return value.equalsIgnoreCase(userInfo.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
