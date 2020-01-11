package pl.szewczyk.aop.sendmail;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoApi {

    private List<Video> videoList = new ArrayList<>();

    public VideoApi(){
        this.videoList = new ArrayList<>();
        videoList.add(new Video(1L,"Video1", "Producer1"));
        videoList.add(new Video(2L,"Video2", "Producer2"));
        videoList.add(new Video(2L,"Video2", "Producer3"));
    }

    @GetMapping
    public ResponseEntity<List<Video>> getVideo() {
        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity addVideo(@RequestBody Video video){
        boolean add = videoList.add(video);
        if(add){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
