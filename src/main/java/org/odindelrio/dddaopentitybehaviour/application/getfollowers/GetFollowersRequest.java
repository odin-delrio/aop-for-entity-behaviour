package org.odindelrio.dddaopentitybehaviour.application.getfollowers;

public class GetFollowersRequest {
  private final String followableUserId;

  public GetFollowersRequest(String followableUserId) {
    this.followableUserId = followableUserId;
  }

  public String getFollowableUserId() {
    return followableUserId;
  }
}
