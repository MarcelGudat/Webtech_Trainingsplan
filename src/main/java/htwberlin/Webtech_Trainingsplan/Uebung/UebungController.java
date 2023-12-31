package htwberlin.Webtech_Trainingsplan.Uebung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
public class UebungController {

    @Autowired
    UebungService service;

    Logger logger = LoggerFactory.getLogger(UebungController.class);

    @PostMapping("/uebung")
    public Uebung createThing(@RequestBody Uebung uebung) {
        return service.save(uebung);
    }

    @GetMapping("/uebung/{id}")
    public Uebung getThing(@PathVariable String id) {
        logger.info("GET request on route things with {}", id);
        Long uebungId = Long.parseLong(id);
        return service.get(uebungId);
    }

    @GetMapping("/uebungs")
    public List<Uebung> getAllThings() {
        return service.getAll();
    }

    @DeleteMapping ("/uebung/{id}")
    public void deleteWorkout(@PathVariable String id) {
        Long uebungid = Long.parseLong(id);
        service.delete(uebungid);
    }


}