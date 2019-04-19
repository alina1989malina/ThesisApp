package pack.thesis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pack.thesis.dto.ScienceFieldCodeDto;
import pack.thesis.dto.ThesisDto;
import pack.thesis.model.ScienceCode;
import pack.thesis.model.Thesis;

import java.util.List;

public interface ThesisDao extends JpaRepository<Thesis, Long> {
    @Query("SELECT new pack.thesis.dto.ThesisDto(t.id, t.thesisTitle, a.aspirantFio, a.dissDefTime, tt.thesisType, sc.code, sf.title, o.title) "
            + "FROM Thesis t LEFT JOIN t.advert a LEFT JOIN t.thesisType tt LEFT JOIN t.scienceCode sc LEFT JOIN sc.scienceField sf LEFT JOIN a.organization o")
    List<ThesisDto> fetchThesisDataLeftJoin();
}

