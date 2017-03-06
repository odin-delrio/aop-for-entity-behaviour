package org.odindelrio.dddaopentitybehaviour.infrastructure;

import org.odindelrio.dddaopentitybehaviour.domain.Followable;
import org.odindelrio.dddaopentitybehaviour.domain.Follower;
import org.odindelrio.dddaopentitybehaviour.domain.FollowersRepository;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryFollowersRepository implements FollowersRepository {

  private Map<String, LinkedHashSet<Follower>> storage = new HashMap<>();

  @Override
  public Set<Follower> getFollowers(String followableUserId) {
    return storage.getOrDefault(followableUserId, new LinkedHashSet<>());
  }

  @Override
  public void persistFollower(Follower follower, Followable followable) {
    if (!this.storage.containsKey(followable.getFollowableId())) {
      this.storage.put(followable.getFollowableId(), new LinkedHashSet<>());
    }

    this.storage.get(followable.getFollowableId()).add(follower);
  }
}
