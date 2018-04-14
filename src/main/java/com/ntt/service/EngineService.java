package com.ntt.service;

import com.ntt.model.Engine;

import java.util.List;

public interface EngineService {
    public Engine getEngineById(int engineId);

    public int addEngine(Engine engine);

    public int editEngine(Engine engine);

    public int deleteEngine(int id);

    public int deleteEngines(String[] ids);

    public List<Engine> findAllEngine();

}
