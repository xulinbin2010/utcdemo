package com.ntt.service;

import com.ntt.mapper.OptionMapper;
import com.ntt.model.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("optionService")
public class OptionServiceImpl implements OptionService{

    @Autowired
    private OptionMapper optionMapper;//这里会报错，但是并不会影响

    @Override
    public int addOption(Option option) {
        return optionMapper.insert(option);
    }

    @Override
    public int editOption(Option option) {
        return optionMapper.updateByPrimaryKey(option);
    }

    @Override
    public int deleteOptions(String[] ids) {
        return optionMapper.deleteByIds(ids);
    }

    @Override
    public List<Option> findAllOption() {
        return optionMapper.getAllOptionList();
    }
}
