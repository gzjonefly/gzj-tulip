package com.gzj.dao.mapper;

import com.gzj.dao.model.SpiderCorpSmsSendConditions;
import com.gzj.dao.model.SpiderCorpSmsSendDO;
import com.gzj.tulip.jade.annotation.DAO;
import com.gzj.tulip.jade.plugin.sql.GenericDAO;

@DAO(catalog = "dz_db")
public interface SpiderCorpSmsSendDAO extends GenericDAO<SpiderCorpSmsSendDO, Integer, SpiderCorpSmsSendConditions> {
}