package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.odindelrio.dddaopentitybehaviour.domain.Follower;
import org.odindelrio.dddaopentitybehaviour.domain.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FollowerAspect {

  @Autowired
  private FollowersRepository repository;

  // Currently not working
  @Before("execution(* org.odindelrio.dddaopentitybehaviour.domain.Follower.follow(..))")
  public void beforeFollow() throws Throwable {
    System.out.println("BEFORE Follow Entity follow()");
  }

  // Currently not working
  @Around("execution(* org.odindelrio.dddaopentitybehaviour.domain.Follower.follow(..))")
  public Object aroundFollow(ProceedingJoinPoint pjp) throws Throwable {

    ((Follower) pjp.getThis()).followersRepository = repository;

    return pjp.proceed();
  }

  @Before("execution(* org.odindelrio.dddaopentitybehaviour.application.followusecase.FollowUseCase.execute(..))")
  public void beforeRepositoryPersist() throws Throwable {
    System.out.println("BEFORE USE CASE EXECUTION!");
  }
}
