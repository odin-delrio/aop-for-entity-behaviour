package org.odindelrio.dddaopentitybehaviour.domain;

import org.odindelrio.dddaopentitybehaviour.domain.exception.FollowerCantFollowHimSelfException;

public class Follower {
  private final String followerId;
  public transient FollowersRepository followersRepository;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Follower follower = (Follower) o;

    if (followerId != null ? !followerId.equals(follower.followerId) : follower.followerId != null) return false;
    return followersRepository != null ? followersRepository.equals(follower.followersRepository) : follower.followersRepository == null;
  }

  @Override
  public int hashCode() {
    int result = followerId != null ? followerId.hashCode() : 0;
    result = 31 * result + (followersRepository != null ? followersRepository.hashCode() : 0);
    return result;
  }
}
