package co.com.bancolombia.model.user.gateways;

import co.com.bancolombia.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> createUser(User payload);
    Mono<User> getUserById(Long id);
    Flux<User> getUsers();
    Flux<User> getUsersByName(String name);
}
