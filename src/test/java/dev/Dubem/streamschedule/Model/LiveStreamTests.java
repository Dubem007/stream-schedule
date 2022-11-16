package dev.Dubem.streamschedule.Model;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;


public class LiveStreamTests {

    @Test
    void create_new_mutable_live_stream(){
        MutableLiveStream stream = new MutableLiveStream();
        stream.setId(UUID.randomUUID().toString());
        stream.setTitle("Building Rest APIs with SpringBoot");
        stream.setDescription("Spring Boot is a very convenient way of building APIs, You have to go to the site first to download the starter app first");
        stream.setUrl("www.google.com");
        stream.setStartDate(LocalDateTime.of(2022,11,5,2,2));
        stream.setEndDate(LocalDateTime.of(2022,12,5,2,2));

        assertNotNull(stream);
        assertEquals("Building Rest APIs with SpringBoot",stream.getTitle(),"Building Rest APIs with SpringBoot" );
    }

    @Test
    void create_new_immutable_live_stream(){
        ImmutableLiveStream stream = new ImmutableLiveStream(
        UUID.randomUUID().toString(),
        "Building Rest APIs with SpringBoot",
        "Spring Boot is a very convenient way of building APIs, You have to go to the site first to download the starter app first",
        "www.google.com",
        LocalDateTime.of(2022,11,5,2,2),
        LocalDateTime.of(2022,12,5,2,2));

        assertNotNull(stream);
        assertEquals("Building Rest APIs with SpringBoot",stream.getTitle(),"Building Rest APIs with SpringBoot");


    }

    @Test
    void create_new_record_live_stream(){
        LiveStream stream = new LiveStream(
                UUID.randomUUID().toString(),
                "Building Rest APIs with SpringBoot",
                "Spring Boot is a very convenient way of building APIs, You have to go to the site first to download the starter app first",
                "www.google.com",
                LocalDateTime.of(2022,11,5,2,2),
                LocalDateTime.of(2022,12,5,2,2)
        );

        assertNotNull(stream);
        assertEquals("","Building Rest APIs with SpringBoot", stream.title());
        assertTrue(stream.getClass().isRecord());
        assertEquals("",6,stream.getClass().getRecordComponents().length);



    }
}
