package org.odindelrio.dddaopentitybehaviour.domain;

import org.odindelrio.dddaopentitybehaviour.domain.exception.FollowerCantFollowHimSelfException;

public class Follower {
  private final String followerId;
  public FollowersRepository followersRepository;

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

    System.out.println("INSIDE Follower.follow() method");

    this.followersRepository.persistFollower(this, followable);
  }
}
