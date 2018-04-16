package com.ntt.service;

import com.github.pagehelper.PageHelper;
import com.ntt.mapper.EngineMapper;
import com.ntt.model.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("engineService")
public class EngineServiceImpl implements EngineService {



    @Autowired
    private EngineMapper engineMapper;//这里会报错，但是并不会影响

    @Override
    public Engine getEngineById(int engineId) {
        return null;
    }

    @Override
    public int addEngine(Engine engine) {
        int insertVar = engineMapper.insert(engine);
        return insertVar;
    }
    @Override
    public int editEngine(Engine engine){
        int updateVar = engineMapper.updateByPrimaryKey(engine);
        return updateVar;
    }

    @Override
    public int deleteEngine(int id){
        return engineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteEngines(String[] ids){
        return engineMapper.deleteByIds(ids);
    }

    @Override
    public List<Engine> findAllEngine() {
        return engineMapper.getAllEngineList();

    }

    @Override
    public List<Engine> findAllEngineAndOption(){
        return engineMapper.getAllEngineAndOptionList();
    }
}
