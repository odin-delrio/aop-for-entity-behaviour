package org.odindelrio.dddaopentitybehaviour.domain;

import org.odindelrio.dddaopentitybehaviour.domain.exception.FollowerCantFollowHimSelfException;
import org.odindelrio.dddaopentitybehaviour.infrastructure.InMemoryFollowersRepository;

public class Follower {
  private final String followerId;
  public FollowersRepository followersRepository = new InMemoryFollowersRepository();

  public Follower(String followerId) {
    this.followerId = followerId;
  }

  public String getFollowerId() {
    return followerId;
  }

  public void follow(Followable followable) {
    if (followable.getFollowableId().equals(followerId)) {
      throw new FollowerCantFollowHimSelfException();
    }

    this.followersRepository.persistFollower(this, followable);
  }
}
