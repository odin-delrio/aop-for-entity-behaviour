package org.odindelrio.dddaopentitybehaviour.infrastructure;

import org.odindelrio.dddaopentitybehaviour.domain.Followable;
import org.odindelrio.dddaopentitybehaviour.domain.Follower;
import org.odindelrio.dddaopentitybehaviour.domain.FollowersRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFollowersRepository implements FollowersRepository {

  private Map<String, Follower> storage = new HashMap<>();

  public void persistFollower(Follower follower, Followable followable) {
    this.storage.put(followable.getFollowableId(), follower);
  }
}
