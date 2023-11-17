package co.com.bancolombia.r2dbc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

@Repository
public interface UserReactiveRepository extends ReactiveCrudRepository<UserEntity, Integer> {
    @Query(value = "select e from UserEntity e where e.name like concat('%',:name,'%')")
    Flux<UserEntity> findByName(String name);
}
