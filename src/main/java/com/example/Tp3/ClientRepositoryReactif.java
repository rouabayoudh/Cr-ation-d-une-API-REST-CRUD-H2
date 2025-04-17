package com.example.Tp3;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClientRepositoryReactif {
    public static Map<Long,Client> clients = new HashMap<>();

    Mono<Client> save(Client client){
        clients.put(client.getId(),client);
        return Mono.justOrEmpty(client);
    }

    Mono<Client> findById(Long id){
        return Mono.justOrEmpty(clients.get(id));
    }
    Flux<Client> findAll(){
        return Flux.fromIterable(clients.values());
    }
    Mono<Client> delete(Long id){
        return Mono.justOrEmpty(clients.remove(id));
    }



}
