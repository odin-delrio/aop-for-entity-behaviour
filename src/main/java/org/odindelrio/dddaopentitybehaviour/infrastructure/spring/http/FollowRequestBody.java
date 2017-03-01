package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.http;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowRequestBody {

  private String followerId;

  public FollowRequestBody(@JsonProperty("follower_id") String followerId) {
    this.followerId = followerId;
  }

  public String getFollowerId() {
    return followerId;
  }
}
