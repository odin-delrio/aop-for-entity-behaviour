package org.odindelrio.dddaopentitybehaviour.application.getfollowers;

import org.odindelrio.dddaopentitybehaviour.domain.Follower;
import org.odindelrio.dddaopentitybehaviour.domain.FollowersRepository;

import java.util.stream.Collectors;

public class GetFollowersUseCase {

  private FollowersRepository repository;

  public GetFollowersUseCase(FollowersRepository repository) {
    this.repository = repository;
  }

  public GetFollowersResponse execute(GetFollowersRequest request) {
    return new GetFollowersResponse(
        repository
            .getFollowers(request.getFollowableUserId())
            .stream()
            .map(Follower::getFollowerId)
            .map(GetFollowersResponse.Follower::new)
            .collect(Collectors.toList())
    );
  }
}
