## Playing with Spring AOP


###Goal
Inject repository to the entity using AOP.

###Why?
Trying to follow DDD, I want to test a way to avoid anemic models, leading in self-explanatory use cases.

###Found problems
- First steps with Spring AOP are easy...
  
  but, now that I understand how AOP is working with Spring I think that I can't use Spring AOP for intercept method calls on **non beans** classes.

  Spring AOP works creating Proxys for classes that are registered in the Dependency Injection Container.

###Run
```bash
./gradlew bootRun
```

###Test
```bash
# manually with curl
curl -XPUT --header "Content-Type: application/json" localhost:8080/users/1/followers -d '{"follower_id": 2}' -v
```