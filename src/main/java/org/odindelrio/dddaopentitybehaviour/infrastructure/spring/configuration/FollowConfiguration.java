package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.configuration;

import org.odindelrio.dddaopentitybehaviour.application.followusecase.FollowUseCase;
import org.odindelrio.dddaopentitybehaviour.domain.FollowersRepository;
import org.odindelrio.dddaopentitybehaviour.infrastructure.InMemoryFollowersRepository;
import org.odindelrio.dddaopentitybehaviour.infrastructure.spring.controller.FollowController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FollowConfiguration {

  @Bean
  public FollowUseCase followUseCase() {
    return new FollowUseCase();
  }

  @Bean
  public FollowController followController(FollowUseCase followUseCase) {
    return new FollowController(followUseCase);
  }

  @Bean
  public FollowersRepository followersRepository() {
    return new InMemoryFollowersRepository();
  }
}
