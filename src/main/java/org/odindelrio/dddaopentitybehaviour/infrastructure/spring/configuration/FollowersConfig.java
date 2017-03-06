package org.odindelrio.dddaopentitybehaviour.infrastructure.spring.configuration;

import org.odindelrio.dddaopentitybehaviour.application.follow.FollowUseCase;
import org.odindelrio.dddaopentitybehaviour.application.getfollowers.GetFollowersUseCase;
import org.odindelrio.dddaopentitybehaviour.domain.FollowersRepository;
import org.odindelrio.dddaopentitybehaviour.infrastructure.InMemoryFollowersRepository;
import org.odindelrio.dddaopentitybehaviour.infrastructure.spring.controller.FollowersController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FollowersConfig {

  @Bean
  public GetFollowersUseCase getFollowersUseCase(FollowersRepository repository) {
    return new GetFollowersUseCase(repository);
  }

  @Bean
  public FollowUseCase followUseCase() {
    return new FollowUseCase();
  }

  @Bean
  public FollowersController followersController(GetFollowersUseCase getFollowersUseCase, FollowUseCase followUseCase) {
    return new FollowersController(getFollowersUseCase, followUseCase);
  }

  @Bean
  public FollowersRepository followersRepository() {
    return new InMemoryFollowersRepository();
  }
}
