package io.github.berkayelken.insta.follower.analyzer.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.berkayelken.insta.follower.analyzer.domain.FollowedUsers;
import io.github.berkayelken.insta.follower.analyzer.domain.RelatedUser;
import io.github.berkayelken.insta.follower.analyzer.domain.RelationAnalyze;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.List;

@AllArgsConstructor
@Service
public class AnalyzeService {
	private final ObjectMapper objectMapper;

	@SneakyThrows
	public RelationAnalyze analyze(MultipartFile following, MultipartFile followers) {
		FollowedUsers followedUsers = objectMapper.readValue(following.getInputStream(), FollowedUsers.class);
		List<RelatedUser> followersList = objectMapper.readValue(followers.getInputStream(), new TypeReference<List<RelatedUser>>() {
			@Override
			public Type getType() {
				return super.getType();
			}
		});
		return new RelationAnalyze(followedUsers, followersList);
	}
}
