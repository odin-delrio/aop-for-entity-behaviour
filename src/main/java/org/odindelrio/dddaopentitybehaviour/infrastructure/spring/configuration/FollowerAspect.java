package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.configuration;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.odindelrio.dddaopentitybehaviour.domain.Follower;
import org.odindelrio.dddaopentitybehaviour.infrastructure.InMemoryFollowersRepository;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FollowerAspect {

  @Before("execution(* org.odindelrio.dddaopentitybehaviour.domain.Follower.follow(..))")
  public void beforeFollow() throws Throwable {
    System.out.println("BEFORE Follow Entity follow()");
  }

  @Around("execution(* org.odindelrio.dddaopentitybehaviour.domain.Follower.follow(..))")
  public Object aroundFollow(ProceedingJoinPoint pjp) throws Throwable {

    System.out.println("AROUND Follow Entity follow()");

    // First attempt to inject repository...
    System.out.println("Injecting Repository to entity...");
    ((Follower) pjp.getThis()).followersRepository = new InMemoryFollowersRepository();

    return pjp.proceed();
  }

  @Before("execution(* org.odindelrio.dddaopentitybehaviour.application.followusecase.FollowUseCase.execute(..))")
  public void beforeUseCasePersist() throws Throwable {
    System.out.println("BEFORE USE CASE EXECUTION!");
  }
}
