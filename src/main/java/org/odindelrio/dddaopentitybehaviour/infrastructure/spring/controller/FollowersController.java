package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.controller;

import org.odindelrio.dddaopentitybehaviour.application.follow.FollowRequest;
import org.odindelrio.dddaopentitybehaviour.application.follow.FollowUseCase;
import org.odindelrio.dddaopentitybehaviour.application.getfollowers.GetFollowersRequest;
import org.odindelrio.dddaopentitybehaviour.application.getfollowers.GetFollowersResponse;
import org.odindelrio.dddaopentitybehaviour.application.getfollowers.GetFollowersUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class FollowersController {

  private final GetFollowersUseCase getFollowersUseCase;
  private final FollowUseCase followUseCase;

  public FollowersController(GetFollowersUseCase getFollowersUseCase, FollowUseCase followUseCase) {
    this.getFollowersUseCase = getFollowersUseCase;
    this.followUseCase = followUseCase;
  }

  @GetMapping("/users/{followableUserId}/followers")
  public ResponseEntity<List<GetFollowersResponse.Follower>> getFollowers(
      @PathVariable("followableUserId") String followableUserId
  ) {
    GetFollowersRequest request = new GetFollowersRequest(followableUserId);
    return ResponseEntity.ok(getFollowersUseCase.execute(request).getFollowers());
  }

  @PutMapping("/users/{followableUserId}/followers/{followerUserId}")
  public ResponseEntity follow(
      @PathVariable("followableUserId") String followableUserId,
      @PathVariable("followerUserId") String followerUserId
  ) {
    FollowRequest followRequest = new FollowRequest(followerUserId, followableUserId);
    followUseCase.execute(followRequest);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
