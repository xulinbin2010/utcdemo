package com.ntt.service;

import com.ntt.model.Option;

import java.util.List;

public interface OptionService {
    public int addOption(Option option);

    public int editOption(Option option);

    public int deleteOptions(String[] ids);

    public List<Option> findAllOption();
}
