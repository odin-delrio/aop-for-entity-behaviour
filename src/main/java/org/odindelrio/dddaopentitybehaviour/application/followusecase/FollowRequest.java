package org.odindelrio.dddaopentitybehaviour.application.followusecase;

public class FollowRequest {
  private final String followerId;
  private final String followableId;

  public FollowRequest(String followerId, String followableId) {
    this.followerId = followerId;
    this.followableId = followableId;
  }

  public String getFollowerId() {
    return followerId;
  }

  public String getFollowableId() {
    return followableId;
  }
}
