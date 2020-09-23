package zy.demo.mapper;

import org.springframework.stereotype.Repository;
import zy.demo.entity.Nation;

import java.util.List;

@Repository
public interface NationMapper {
    List<Nation> sel_all();
    Nation sel(int id);
    void add(Nation nation);
    void update(Nation nation);
    void delete(int id);
}
