package org.odindelrio.dddaopentitybehaviour.domain;

import java.util.Set;

public interface FollowersRepository {

  void persistFollower(Follower follower, Followable followable);

  Set<Follower> getFollowers(String followableUserId);
}
