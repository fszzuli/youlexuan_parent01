package com.offcn.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.mapper.TbBrandMapper;
import com.offcn.pojo.TbBrand;
import com.offcn.pojo.TbBrandExample;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassNameBrandServiceImpl
 * @Description TODO
 * Auther FSZZULI
 * @Date2020/4/4 17:13
 * @Version 1.0
 **/
@Service
public class BrandServiceImpl implements BrandService {


    /*
    * 本地注入
    * */
    @Autowired
    private TbBrandMapper BrandMapper;


    public List<TbBrand> findAll() {
       return BrandMapper.selectByExample(null);

    }

    public PageResult findPage(int pageNo, int pageSize) {

        PageHelper.startPage(pageNo,pageSize);
        Page<TbBrand>  page= (Page<TbBrand>) BrandMapper.selectByExample(null);


        return new PageResult(page.getTotal(), page.getResult());
    }

    public void add(TbBrand brand) {
        BrandMapper.insert(brand);
    }

    public TbBrand findOne(Long id) {
        return BrandMapper.selectByPrimaryKey(id);
    }

    public void update(TbBrand brand) {
        BrandMapper.updateByPrimaryKey(brand);
    }

    public void delete(Long[] ids) {
        for (Long id:ids){
            BrandMapper.deleteByPrimaryKey(id);
        }
    }

    public PageResult findPage(TbBrand brand, int pageNo, int pageSize) {

        PageHelper.startPage(pageNo,pageSize);

        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();

        //判断模糊名称是否存在
        if (brand != null){
            if (brand.getName() != null && brand.getName().length()>0){
                criteria.andNameLike('%'+brand.getName()+'%');
                //where name like '%+brand.getName()+%'
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().length()>0){

                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }

        }


        Page<TbBrand> page = (Page<TbBrand>) BrandMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }
}
