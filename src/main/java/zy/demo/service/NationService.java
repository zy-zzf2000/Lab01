package zy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zy.demo.entity.Nation;
import zy.demo.mapper.NationMapper;

import java.util.List;

@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;

    void add_nation(Nation nation){
        nationMapper.add(nation);
    }

    void delete_nation(int id){
        nationMapper.delete(id);
    }

    void update_nation(Nation nation){
        nationMapper.update(nation);
    }

    List<Nation> select_all(){
        return nationMapper.sel_all();
    }

    Nation select_one(int id){
        return nationMapper.sel(id);
    }
}
