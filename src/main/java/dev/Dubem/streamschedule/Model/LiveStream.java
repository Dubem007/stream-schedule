package dev.Dubem.streamschedule.Model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record LiveStream(String id, String title, String description, String url, LocalDateTime startDate,LocalDateTime endDate) {
    public LiveStream(String id ,@NotEmpty String title, String description, String url, LocalDateTime startDate, LocalDateTime endDate){
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
