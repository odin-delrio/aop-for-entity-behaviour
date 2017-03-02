package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.controller;

import org.odindelrio.dddaopentitybehaviour.application.followusecase.FollowRequest;
import org.odindelrio.dddaopentitybehaviour.application.followusecase.FollowUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class FollowController {

  private final FollowUseCase followUseCase;

  public FollowController(FollowUseCase followUseCase) {
    this.followUseCase = followUseCase;
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
