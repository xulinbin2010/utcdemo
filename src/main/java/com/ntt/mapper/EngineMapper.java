package com.ntt.mapper;

import com.ntt.model.Engine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EngineMapper {

    int insert(Engine record);

    int insertSelective(Engine record);

    Engine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Engine record);

    int updateByPrimaryKey(Engine record);

    int deleteByPrimaryKey(Integer id);

    int deleteByIds(String[] ids);

    List<Engine> getAllEngineList();
}