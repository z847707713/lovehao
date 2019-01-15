package cn.lovehao.service.impl;

import cn.lovehao.dao.TablesDao;
import cn.lovehao.service.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesServiceImpl implements TablesService {

    @Autowired
    TablesDao tablesDao;

    @Override
    public List<String> getAllTablesName() {
        return tablesDao.selectAllTabelsName();
    }

}
