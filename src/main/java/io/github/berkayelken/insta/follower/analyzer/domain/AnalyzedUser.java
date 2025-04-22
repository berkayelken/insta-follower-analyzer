package io.github.berkayelken.insta.follower.analyzer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
public class AnalyzedUser {
	private String username;
	private String url;
	private LocalDate relationStartedAt;

	public AnalyzedUser(UserInfo userInfo) {
		username = userInfo.getValue();
		url = userInfo.getHref();
		relationStartedAt = Instant.ofEpochSecond(userInfo.getTimestamp()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
