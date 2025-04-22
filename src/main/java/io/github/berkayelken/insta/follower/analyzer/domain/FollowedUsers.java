package io.github.berkayelken.insta.follower.analyzer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FollowedUsers {
	@JsonProperty("relationships_following")
	private List<RelatedUser> users;
}
