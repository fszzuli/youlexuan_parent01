package com.offcn.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassNameBrandController
 * @Description TODO
 * Auther FSZZULI
 * @Date2020/4/4 17:18
 * @Version 1.0
 **/


@RestController
@RequestMapping("/brand")
public class BrandController {

    /**
     *
     * 远程的注入
     * @return
     */
@Reference
private BrandService brandService;

@RequestMapping("/findAll")
public List<TbBrand> findAll(){
  return   brandService.findAll();
}

/**
 * 分页查询
 *
 */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){

        return brandService.findPage(page, rows);
    }

    /**
     * 新增
     * @param brand
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {

            brandService.add(brand);
            return new Result(true,"增加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加失败");
        }
    }
    /**
     * 根据id查询品牌
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
       return brandService.findOne(id);
    }






    /**
     * 修改
     * @param brand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {

            brandService.update(brand);
            return new Result(true,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping("/dele")
    public Result dele(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    /**
     * 条件分页查询
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand,int page, int rows){

        return brandService.findPage(tbBrand,page, rows);
    }

}
