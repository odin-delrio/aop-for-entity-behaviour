package org.odindelrio.dddaopentitybehaviour.application.followusecase;

import org.odindelrio.dddaopentitybehaviour.domain.Followable;
import org.odindelrio.dddaopentitybehaviour.domain.Follower;

public class FollowUseCase {

  public void execute(FollowRequest request) {
    Follower follower = new Follower(request.getFollowerId());
    Followable followable = new Followable(request.getFollowableId());

    follower.follow(followable);
  }
}
