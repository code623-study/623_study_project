package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class CourseBaseInfoServiceImpl implements CourseBaseInfoService {

    @Autowired
    CourseBaseMapper courseBaseMapper;
    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams PageParams, QueryCourseParamsDto courseParamsDto) {

        //拼装查询条件
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        //根据名称模糊查询，在sql中拼接 course_base.name like '%值%'
        queryWrapper.like(StringUtils.isNotEmpty(courseParamsDto.getCourseName()),CourseBase::getName,courseParamsDto.getCourseName());
        //根据课程状态查询， course_base.auditStatus = ？
        queryWrapper.eq(StringUtils.isNotEmpty(courseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,courseParamsDto.getAuditStatus());
        //根据课程发布查询， course_base.status = ？
        queryWrapper.eq(StringUtils.isNotEmpty(courseParamsDto.getPublishStatus()),CourseBase::getStatus,courseParamsDto.getPublishStatus());

        //创建page分页参数对象，参数：当前页码，每页记录数
        Page<CourseBase> page = new Page<>(PageParams.getPageNo(), PageParams.getPageSize());
        //开始进行分页查询
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page,queryWrapper);
        //数据列表
        List<CourseBase> items = pageResult.getRecords();
        //总记录数
        long total = pageResult.getTotal();

        //List<T> items counts,long page,long pageSize
        PageResult<CourseBase> courseBasePageResult = new PageResult<CourseBase>(items,total,PageParams.getPageNo(),PageParams.getPageSize());

        return courseBasePageResult;
    }
}