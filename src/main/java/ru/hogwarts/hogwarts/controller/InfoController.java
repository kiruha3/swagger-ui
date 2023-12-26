package ru.hogwarts.hogwarts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.hogwarts.service.InfoService;

import java.util.stream.Stream;


@RestController
@RequestMapping("/port")
public class InfoController {


    private final InfoService infoService;
    private final Logger logger = LoggerFactory.getLogger(InfoService.class);

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    public String getPort() {
        return infoService.getPort();
    }

    @GetMapping("/chuma/{maxSize}")
    public Long getchuma(@PathVariable Integer maxSize) {
        Long sum = Long.valueOf(Stream.iterate(1, a -> a + 1)
                .limit(maxSize)
                .reduce(0, (a, b) -> a + b));
        Long finish = System.currentTimeMillis();
        return sum;
    }

}
