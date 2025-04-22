package io.github.berkayelken.insta.follower.analyzer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
public class RelatedUser {
	@JsonProperty ("string_list_data")
	private List<UserInfo> userInfo;

	public static boolean nonNull(RelatedUser relatedUser) {
		return relatedUser != null && !CollectionUtils.isEmpty(relatedUser.userInfo) && StringUtils.hasText(relatedUser.userInfo.getFirst().getValue());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RelatedUser that = (RelatedUser) o;
		if (CollectionUtils.isEmpty(userInfo) || CollectionUtils.isEmpty(that.userInfo))
			return false;
		return userInfo.getFirst().equals(that.userInfo.getFirst());
	}

	@Override
	public int hashCode() {
		return Objects.hash(userInfo);
	}
}
