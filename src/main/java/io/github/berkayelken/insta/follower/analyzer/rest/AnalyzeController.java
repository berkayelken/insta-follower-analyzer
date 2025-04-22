package io.github.berkayelken.insta.follower.analyzer.rest;

import io.github.berkayelken.insta.follower.analyzer.domain.RelationAnalyze;
import io.github.berkayelken.insta.follower.analyzer.service.AnalyzeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/api/insta/analyze")
public class AnalyzeController {
	private final AnalyzeService service;

	@PostMapping
	public RelationAnalyze analyze(@RequestPart ("following") MultipartFile following,
			@RequestPart("followers") MultipartFile followers) {
		return service.analyze(following, followers);
	}
}
