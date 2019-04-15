package pack.thesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pack.thesis.dao.ThesisDao;
import pack.thesis.model.Thesis;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ThesisController {

    @Autowired
    private ThesisDao thesisDao;

    @GetMapping(value = "/theses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Thesis> getTheses() {
        return thesisDao.findAll();
    }

    @GetMapping(value = "/thesis/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Thesis getThesis(@PathVariable Long id) {
        return thesisDao.findById(id).orElse(new Thesis());
    }

    @GetMapping(value = "/thesisByAspirantFullName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Thesis> getThesisByAspirantFullName(@PathVariable String name) {
        return thesisDao.findByAspirantFio(name);
    }

    @GetMapping(value = "/thesisBySupervisorFullName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Thesis> getThesisBySupervisorFullName(@PathVariable String name) {
        return thesisDao.findBySupervisorFio(name);
    }

    @GetMapping(value = "/thesisByThesisTitle/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Thesis getThesisByThesisTitle(@PathVariable String title) {
        return thesisDao.findByThesisTitle(title);
    }

    @GetMapping(value = "/thesisByScienceCode/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Thesis> getThesisByScienceCode(@PathVariable String code) {
        return thesisDao.findByScienceCode(code);
    }

    @GetMapping(value = "/thesisByScienceField/{field}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Thesis> getThesisByScienceField(@PathVariable String field) {
        return thesisDao.findByScienceField(field);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addThesis(@RequestBody Thesis thesis){
        return thesisDao.save(thesis) != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping(value = "/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        thesisDao.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus updatePerson(@RequestBody Thesis thesis) {
        return thesisDao.save(thesis) != null ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
    }
}


