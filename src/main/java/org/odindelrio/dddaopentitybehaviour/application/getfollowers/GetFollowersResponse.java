package org.odindelrio.dddaopentitybehaviour.application.getfollowers;

import java.util.Collections;
import java.util.List;

public class GetFollowersResponse {
  private final List<Follower> followers;

  public GetFollowersResponse(List<Follower> followers) {
    this.followers = Collections.unmodifiableList(followers);
  }

  public List<Follower> getFollowers() {
    return followers;
  }

  public static class Follower {
    private String id;

    Follower(String id) {
      this.id = id;
    }

    public String getId() {
      return id;
    }
  }
}
