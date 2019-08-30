package com.tensquare_base.service;

import com.tensquare_base.mapper.LabelMapper;
import com.tensquare_base.pojo.Label;
import com.tensquare_common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LabelService {
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelMapper.findAll();
    }

    public Label findById(String id) {
        return labelMapper.findById(id).get();
    }

    public void update(Label label) {
        labelMapper.save(label);
    }

    public void save(Label label) {
        label.setId(idWorker.nextId() + "");
        labelMapper.save(label);
    }

    public void deleteById(String id) {
        labelMapper.deleteById(id);
    }

    /**
     * 根据条件分页查询数据  使用动态查询
     *
     * @param map 条件数据
     * @return
     */
    public List<Label> search(Map<String,Object> map) {
        Specification sp = createSpecification(map);
        return labelMapper.findAll(sp);
    }

    private Specification createSpecification(Map<String,Object> map) {
        Specification sp = new Specification() {
            /**
             * 整合筛选条件
             * @param root  代表当前javabean对象
             * @param cq 用于生成sql语句
             * @param cb 用于拼接条件
             * @return Predicate条件合集
             */
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
              /*  if (!"".equals(map.get("id")) && null != map.get("id")) {
                    Predicate p1 = cb.equal(root.get("id").as(String.class), map.get("id"));
                    list.add(p1);
                }*/
                if (!"".equals(map.get("labelname")) && null != map.get("labelname")) {
                    Predicate p2 = cb.like(root.get("labelname").as(String.class), "%" + map.get("labelname") + "%");
                    list.add(p2);
                }
                if (!"".equals(map.get("state")) && null != map.get("state")) {
                    Predicate p3 = cb.equal(root.get("state"), map.get("state"));
                    list.add(p3);

                }
              /*  if (null != map.get("count")) {
                    Predicate p4 = cb.equal(root.get("count").as(Long.class), map.get("count"));
                    list.add(p4);
                }*/
                if (!"".equals(map.get("recommend")) && null != map.get("recommend")) {
                    Predicate p5 = cb.equal(root.get("recommend"), map.get("recommend"));
                    list.add(p5);
                }
                return cb.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return sp;
    }

}
