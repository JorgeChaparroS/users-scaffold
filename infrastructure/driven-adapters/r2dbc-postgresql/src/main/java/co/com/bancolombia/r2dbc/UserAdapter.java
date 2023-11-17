package co.com.bancolombia.r2dbc;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class UserAdapter implements UserRepository {

    private final UserReactiveRepository userReactiveRepository;

    @Override
    public Mono<User> createUser(User payload) {
        return userReactiveRepository.save(UserEntity.builder()
                .email(payload.getEmail())
                .name(payload.getName())
                .build()).map(m ->
                    User.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .email(m.getEmail())
                        .build());
    }
    @Override
    public Mono<User> getUserById(Long id) {
        return userReactiveRepository.findById(id.intValue()).map(m ->
                User.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .email(m.getEmail())
                        .build());
    }
    @Override
    public Flux<User> getUsers() {
        return userReactiveRepository.findAll().map(m ->
                User.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .email(m.getEmail())
                        .build());
    }
    @Override
    public Flux<User> getUsersByName(String name) {
        return userReactiveRepository.findByName(name).map(m ->
                User.builder()
                        .id(m.getId())
                        .name(m.getName())
                        .email(m.getEmail())
                        .build());
    }
}
