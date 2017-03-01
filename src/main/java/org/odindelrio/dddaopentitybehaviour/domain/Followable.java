package org.odindelrio.dddaopentitybehaviour.domain;

public class Followable {
  private final String followableId;

  public Followable(String followableId) {
    this.followableId = followableId;
  }

  public String getFollowableId() {
    return followableId;
  }
}
