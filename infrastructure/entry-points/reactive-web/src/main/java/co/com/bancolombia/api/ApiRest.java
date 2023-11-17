package co.com.bancolombia.api;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final UserUseCase userUseCase;

    @PostMapping(path ="")
    public Mono<User> createUser(@RequestBody User userPayload) {
        return userUseCase.createUser(userPayload);
    }

    @GetMapping(path = "/{id}")
    public Mono<User> getUserById(@PathVariable("id") Long id) {
        return userUseCase.getUserById(id);
    }

    @GetMapping(path = "")
    public Flux<User> getUsers() {
        return userUseCase.getUsers();
    }

    @GetMapping(path = "/{name}")
    public Flux<User> getUsersByName(@PathVariable("name") String name) {
        return userUseCase.getUsersByName(name);
    }

}
