package io.github.berkayelken.insta.follower.analyzer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class RelationAnalyze {
	private Map<String, AnalyzedUser> singleDirectionFollowed;
	private Map<String, AnalyzedUser> singleDirectionFollower;

	public RelationAnalyze(FollowedUsers followedUsers, List<RelatedUser> followers) {
		singleDirectionFollowed = findSingleDirectionRelation(followedUsers.getUsers(), followers);
		singleDirectionFollower = findSingleDirectionRelation(followers, followedUsers.getUsers());
	}

	private static Map<String, AnalyzedUser> findSingleDirectionRelation(List<RelatedUser> first, List<RelatedUser> second) {
		if (CollectionUtils.isEmpty(first)) {
			return Collections.emptyMap();
		}

		if (CollectionUtils.isEmpty(second)) {
			return first.stream().filter(RelatedUser::nonNull).map(RelatedUser::getUserInfo).map(List::getFirst)
					.map(AnalyzedUser::new).collect(Collectors.toMap(AnalyzedUser::getUsername, Function.identity()));
		}

		return first.stream().filter(RelatedUser::nonNull).filter(relatedUser -> !second.contains(relatedUser))
				.map(RelatedUser::getUserInfo).map(List::getFirst).map(AnalyzedUser::new)
				.collect(Collectors.toMap(AnalyzedUser::getUsername, Function.identity()));
	}
}
