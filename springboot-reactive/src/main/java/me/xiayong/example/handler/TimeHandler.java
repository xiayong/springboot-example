package me.xiayong.example.handler;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author YongXia.
 * @since 1.0
 */
@Component
public class TimeHandler implements HandlerFunction<ServerResponse> {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Override
    public Mono<ServerResponse> handle(ServerRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("local",Locale.getDefault() );
        map.put("time", new Date());

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(map), Map.class);
    }

    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(1)).map(sequence -> ServerSentEvent.<String> builder()
                        .id(String.valueOf(sequence))
                        .event("message")
                        .data("Event data " + sequence + ", " +  DTF.format(LocalDateTime.now()) )
                        .build())
                ,
                ServerSentEvent.class);
    }
}
