package com.xuecheng.content.api;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 课程查询接口
 */
@Api(value = "课程信息管理接口",tags="课程信息管理接口")
@RestController
public class CourseBaseInfoController {

    //分页查询课程接口
    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false)  QueryCourseParamsDto queryCourseParamsDto){
        CourseBase courseBase = new CourseBase();
        courseBase.setId(1L);
        courseBase.setName("测试");
        courseBase.setCreateDate(LocalDateTime.now());
        List<CourseBase> courseBasesList = new ArrayList<>();
        courseBasesList.add(courseBase);

        return new PageResult<>(courseBasesList,15,1,10);
    };

    @RequestMapping("/course/string")
    @ResponseBody
    public String string(PageParams pageParams,QueryCourseParamsDto queryCourseParamsDto){
        return "123";
    };

}
