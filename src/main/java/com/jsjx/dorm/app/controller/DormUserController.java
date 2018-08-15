
package com.jsjx.dorm.app.controller;

import com.jsjx.dorm.app.domain.DormUser;
import com.jsjx.dorm.app.service.DormUserService;
import com.jsjx.dorm.app.vo.DormUserAddVo;
import com.jsjx.dorm.app.vo.DormUserEditVo;
import com.jsjx.dorm.app.vo.DormUserQueryInVo;
import com.jsjx.dorm.app.vo.DormUserQueryOutVo;
import com.jsjx.dorm.baseutils.BaseController;
import com.jsjx.dorm.baseutils.MyBatisUtil;
import com.jsjx.dorm.baseutils.PageVo;
import io.swagger.annotations.*;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;


@Api(value = "dorm_user")
@RestController
public class DormUserController extends BaseController {

    @Autowired
    public DozerBeanMapper mapper;

    @Autowired
    private DormUserService bizService;

    @ApiOperation("Get:支持条件查询分页获取")
    @GetMapping(value = "/DormUser")
    public PageVo<DormUserQueryOutVo> getAllBySelective(DormUserQueryInVo param) {
        MyBatisUtil.paging(param);
        List<DormUser> result =  bizService.findBySelective(mapper.map(param,DormUser.class));
        PageVo<DormUserQueryOutVo> pageVo = new PageVo<DormUserQueryOutVo>(result.stream().map(p ->
            mapper.map(p, DormUserQueryOutVo.class)).collect(Collectors.toList()));
        return pageVo;
    }

    @ApiOperation("Get:获取下拉")
    @GetMapping(value = "/DormUserDdl")
    public List<DormUserQueryOutVo> getBySelective(DormUserQueryInVo param) {
        return bizService.findBySelective(mapper.map(param,DormUser.class)).stream()
                .map(p-> mapper.map(p,DormUserQueryOutVo.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("Get:根据key获取，通常用于修改")
    @GetMapping(value = "/DormUser/{id}")
    public DormUserQueryOutVo getById(@PathVariable("id") String id) {
        DormUser result = bizService.findById(id);
        if(result == null) {
            return null;
        }
        return mapper.map(result,DormUserQueryOutVo.class);
    }

    @ApiOperation(value = "Put:根据key修改，返回受影响行数")
    @PutMapping(value = "/DormUser")
    public int putUpdate(@Valid @RequestBody DormUserEditVo param) {
        return bizService.putUpdate(mapper.map(param,DormUser.class));
    }

    @ApiOperation(value = "Post:新增，返回受影响行数")
    @PostMapping(value = "/DormUser")
    public int postInsert(@Valid @RequestBody DormUserAddVo param) {
        return bizService.postInsert(mapper.map(param,DormUser.class));
    }

    @ApiOperation(value = "Delete:根据主键删除")
    @DeleteMapping(value = "/DormUser")
    public int delete(@Valid @RequestBody @NotNull String id) {
        return bizService.delete(id);
    }

    @ApiOperation(value = "Delete:批量删除")
    @DeleteMapping(value = "/DormUserList")
    public int delete(@Valid @RequestBody @NotNull List<String> id) {
        return bizService.deleteAll(id);
    }
}

