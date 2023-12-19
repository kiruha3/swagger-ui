package ru.hogwarts.hogwarts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.hogwarts.service.InfoService;

@RestController
@RequestMapping("/port")
public class InfoController {
        @Autowired
        public InfoService infoService;
        @GetMapping
        public String getPort(){
                return infoService.getPort();
        }

}
