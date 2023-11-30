package htwberlin.Webtech_Trainingsplan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/uebung")
    public List<Uebung> getAllThings() {
        return service.getAll();
    }

}