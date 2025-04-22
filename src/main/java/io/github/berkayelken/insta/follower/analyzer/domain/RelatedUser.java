package io.github.berkayelken.insta.follower.analyzer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Getter
@Setter
@ToString
public class RelatedUser {
	@JsonProperty ("string_list_data")
	private UserInfo userInfo;

	public static boolean nonNull(RelatedUser relatedUser) {
		return relatedUser != null && relatedUser.userInfo != null && StringUtils.hasText(relatedUser.userInfo.getValue());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (userInfo == null)
			return false;
		RelatedUser that = (RelatedUser) o;
		return userInfo.equals(that.userInfo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userInfo);
	}
}
