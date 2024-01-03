package htwberlin.Webtech_Trainingsplan.Uebung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UebungService {

    @Autowired
    UebungRepository repo;

    public Uebung save(Uebung uebung) {
        return repo.save(uebung);
    }

    public Uebung get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Uebung> getAll() {
        Iterable<Uebung> iterator = repo.findAll();
        List<Uebung> uebungs = new ArrayList<Uebung>();
        for (Uebung uebung : iterator)  uebungs.add(uebung);
        return uebungs;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}