//package pack.thesis.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import pack.thesis.dao.ThesisSmallDao;
//import pack.thesis.model.ThesisOldSmall;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class ThesisSmallController {
//
//    @Autowired
//    private ThesisSmallDao thesisSmallDao;
//
//    @GetMapping(value = "/theses", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<ThesisOldSmall> getTheses() {
//        return thesisSmallDao.findAll();
//    }
//
//    @GetMapping(value = "/thesis/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ThesisOldSmall getThesis(@PathVariable Long id) {
//        return thesisSmallDao.findById(id).orElse(new ThesisOldSmall());
//    }
//
//    @GetMapping(value = "/thesisByAspirantFullName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<ThesisOldSmall> getThesisByAspirantFullName(@PathVariable String name) {
//        return thesisSmallDao.findByAspirantFio(name);
//    }
//
//    @GetMapping(value = "/thesisBySupervisorFullName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<ThesisOldSmall> getThesisBySupervisorFullName(@PathVariable String name) {
//        return thesisSmallDao.findBySupervisorFio(name);
//    }
//
//    @GetMapping(value = "/thesisByThesisTitle/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ThesisOldSmall getThesisByThesisTitle(@PathVariable String title) {
//        return thesisSmallDao.findByThesisTitle(title);
//    }
//
//    @GetMapping(value = "/thesisByScienceCode/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<ThesisOldSmall> getThesisByScienceCode(@PathVariable String code) {
//        return thesisSmallDao.findByScienceCode(code);
//    }
//
//    @GetMapping(value = "/thesisByScienceField/{field}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<ThesisOldSmall> getThesisByScienceField(@PathVariable String field) {
//        return thesisSmallDao.findByScienceField(field);
//    }
//
//    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public HttpStatus addThesis(@RequestBody ThesisOldSmall thesis){
//        return thesisSmallDao.save(thesis) != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public HttpStatus delete(@PathVariable Long id){
//        thesisSmallDao.deleteById(id);
//        return HttpStatus.NO_CONTENT;
//    }
//
//    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public HttpStatus updatePerson(@RequestBody ThesisOldSmall thesis) {
//        return thesisSmallDao.save(thesis) != null ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
//    }
//}


