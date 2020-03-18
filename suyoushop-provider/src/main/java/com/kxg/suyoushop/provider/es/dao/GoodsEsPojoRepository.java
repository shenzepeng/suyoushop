package com.kxg.suyoushop.provider.es.dao;

import com.kxg.suyoushop.provider.es.domain.GoodsEsPojo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsEsPojoRepository  extends ElasticsearchRepository<GoodsEsPojo,Long> {

}
