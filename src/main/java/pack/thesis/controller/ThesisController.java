package pack.thesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pack.thesis.dao.ThesisDao;
import pack.thesis.dto.ThesisDto;

import java.util.List;

@RestController
public class ThesisController {
    @Autowired
    private ThesisDao thesisDao;

    @GetMapping(value = "/theses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ThesisDto> getAllTheses() {
        return thesisDao.fetchThesisDataLeftJoin();
    }
}
