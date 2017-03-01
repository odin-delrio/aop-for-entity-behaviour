package org.odindelrio.dddaopentitybehaviour.application.followusecase;

public class FollowRequest {
  private final String followerId;
  private final String targetUserId;

  public FollowRequest(String followerId, String targetUserId) {
    this.followerId = followerId;
    this.targetUserId = targetUserId;
  }

  public String getFollowerId() {
    return followerId;
  }

  public String getTargetUserId() {
    return targetUserId;
  }
}
