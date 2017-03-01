package org.odindelrio.dddaopentitybehaviour.domain.exception;

public class FollowerCantFollowHimSelfException extends RuntimeException {

  public FollowerCantFollowHimSelfException() {
    super("A follower can't follow himself... inception!");
  }
}
