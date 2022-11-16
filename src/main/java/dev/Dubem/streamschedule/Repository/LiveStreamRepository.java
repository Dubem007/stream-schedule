package dev.Dubem.streamschedule.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.Dubem.streamschedule.Model.LiveStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LiveStreamRepository {
    private List<LiveStream> streams = new ArrayList<>();

    public LiveStreamRepository(){
        streams.add(new LiveStream(
                UUID.randomUUID().toString(),
                "Building Rest APIs with SpringBoot",
                "Spring Boot is a very convenient way of building APIs, You have to go to the site first to download the starter app first",
                "www.google.com",
                LocalDateTime.of(2022,11,5,2,2),
                LocalDateTime.of(2022,12,5,2,2)
        ));
    }

    public List<LiveStream> findAll(){
        return streams;
    }

    public LiveStream findById(String id){
        return streams.stream().filter(streams -> streams.id().equals(id)).findFirst().orElse(null);
    }

    public LiveStream create (LiveStream stream){
        streams.add(stream);
        return stream;
    }
    public void update (LiveStream stream, String id){
        LiveStream existing = streams.stream().filter(streams -> streams.id().equals(id)).findFirst()
                .orElseThrow(()-> new IllegalArgumentException("Stream not found"));
        int i = streams.indexOf(existing);
        streams.set(i,stream);

    }
    public void delete (String id){
        streams.removeIf(streams->streams.id().equals(id));
    }
}
