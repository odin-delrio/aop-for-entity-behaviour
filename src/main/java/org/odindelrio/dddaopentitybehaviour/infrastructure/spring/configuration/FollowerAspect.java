package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.odindelrio.dddaopentitybehaviour.domain.Follower;
import org.odindelrio.dddaopentitybehaviour.domain.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class FollowerAspect {

  @Autowired
  private FollowersRepository followersRepository;

  private static final FollowerAspect instance = new FollowerAspect();

  /**
   * Needed for Spring to get the aspect instance.
   * Name "aspectOf" is a must. Magic ;)
   *
   * @return
   */
  public static FollowerAspect aspectOf() {
    return instance;
  }

  @Bean
  public FollowerAspect init() {
    return instance;
  }

  @Before("execution(* org.odindelrio.dddaopentitybehaviour.domain.Follower.follow(..))")
  public void beforeFollow() throws Throwable {
    System.out.println("BEFORE Follow Entity follow()");
  }

  @Around("execution(* org.odindelrio.dddaopentitybehaviour.domain.Follower.follow(..))")
  public Object aroundFollow(ProceedingJoinPoint pjp) throws Throwable {

    System.out.println("AROUND Follow Entity follow()");

    // First attempt to inject repository...
    System.out.println("Injecting Repository to entity...");
    ((Follower) pjp.getThis()).followersRepository = followersRepository;

    return pjp.proceed();
  }

  @Before("execution(* org.odindelrio.dddaopentitybehaviour.application.follow.FollowUseCase.execute(..))")
  public void beforeUseCasePersist() throws Throwable {
    System.out.println("BEFORE USE CASE EXECUTION!");
  }
}
