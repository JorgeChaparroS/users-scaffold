package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> createUser(User data) {
        return userRepository.createUser(data).map(p->{
            return p;
        });
    }

    public Mono<User> getUserById(Long id) {
        return userRepository.getUserById(id).map(p-> {
            return p;
        });
    }

    public Flux<User> getUsers() {
        return userRepository.getUsers();
    }

    public Flux<User> getUsersByName(String name) {
        return userRepository.getUsersByName(name);
    }


}
