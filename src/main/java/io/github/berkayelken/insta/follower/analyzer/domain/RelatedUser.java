package io.github.berkayelken.insta.follower.analyzer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RelatedUser {
	@JsonProperty("string_list_data")
	private UserInfo userInfo;
}
