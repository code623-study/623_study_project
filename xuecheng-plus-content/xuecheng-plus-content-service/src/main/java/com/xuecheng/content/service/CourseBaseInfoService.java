package com.xuecheng.content.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;


public interface CourseBaseInfoService {

    //课程信息管理接口
    //查询课程信息分页
    public PageResult<CourseBase> queryCourseBaseList(PageParams PageParams, QueryCourseParamsDto queryCourseParamsDto);

}
