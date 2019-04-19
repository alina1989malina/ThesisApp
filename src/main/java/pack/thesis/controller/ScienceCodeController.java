package pack.thesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pack.thesis.dto.ScienceFieldCodeDto;
import pack.thesis.service.ScienceCodeService;

import java.util.List;

@RestController
public class ScienceCodeController {

    @Autowired
    private ScienceCodeService scienceCodeService;

    @GetMapping(value = "/codesAndFields", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ScienceFieldCodeDto> getCodesAndFields() {
        return scienceCodeService.fetchScienceCodeAndFieldData();
    }
}
