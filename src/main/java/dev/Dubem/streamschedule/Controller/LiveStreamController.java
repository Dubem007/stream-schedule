package dev.Dubem.streamschedule.Controller;

import dev.Dubem.streamschedule.Model.LiveStream;
import dev.Dubem.streamschedule.Repository.LiveStreamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

    private final LiveStreamRepository repository;

    public LiveStreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    //GET http://localhost:8080/streams
    @GetMapping
    public List<LiveStream> findAll(){
        return repository.findAll();
    }

    //GET http://localhost:8080/streams/id
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id){
        return repository.findById(id);
    }
    //POST http://localhost:8080/streams
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LiveStream create (@Valid @RequestBody LiveStream stream){
        return repository.create(stream);
    }
    //PUT http://localhost:8080/streams/id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody LiveStream stream,@PathVariable String id){
         repository.update(stream,id);
    }
    //DELETE http://localhost:8080/streams/id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable String id){
        repository.delete(id);
    }
}
