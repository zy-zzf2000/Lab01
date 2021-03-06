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

    public void add_nation(Nation nation){
        nationMapper.add(nation);
    }

    public void delete_nation(int id){
        nationMapper.delete(id);
    }

    public void update_nation(Nation nation){
        nationMapper.update(nation);
    }

    public List<Nation> select_all(){
        return nationMapper.sel_all();
    }

    public List<Nation> select_by_name(String name){
        return nationMapper.sel_by_name(name);
    }

    public List<Nation> select_by_pop(int population){
        return nationMapper.sel_by_male(population);
    }

    public Nation select_one(int id){
        return nationMapper.sel(id);
    }
}
