package pack.thesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.thesis.dao.ScienceCodeDao;

import java.util.List;

@Service
public class ScienceCodeService {
    @Autowired
    private ScienceCodeDao scienceCodeDao;

    public List fetchScienceCodeAndFieldData() {
        return scienceCodeDao.fetchScienceCodeScienceFieldDataLeftJoin();
    }
}
