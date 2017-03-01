package org.odindelrio.dddaopentitybehaviour.domain;

public interface FollowersRepository {
  void persistFollower(Follower follower, Followable followable);
}
