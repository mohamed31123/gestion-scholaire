package ma.fstgm.security.shcoolmanagement.services;

import ma.fstgm.security.shcoolmanagement.mapper.DepartementMapper;
import ma.fstgm.security.shcoolmanagement.repositories.DepartementRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartementService {
    private  final DepartementRepository departementRepository ;
    private final DepartementMapper departementMapper ;

    public DepartementService(DepartementRepository departementRepository , DepartementMapper departementMapper){
        this.departementRepository = departementRepository ;
        this.departementMapper = departementMapper ;
    }
}
