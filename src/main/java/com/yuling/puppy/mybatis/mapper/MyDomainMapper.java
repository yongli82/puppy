package com.yuling.puppy.mybatis.mapper;

import com.yuling.puppy.mybatis.domain.MyDomain;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyDomainMapper {

    @Select("SELECT * FROM my_domain WHERE NAME = #{name}")
    MyDomain findByName(@Param("name") String name);

    @Insert("INSERT INTO my_domain(NAME, TYPE) VALUES(#{name}, #{type})")
    int insert(@Param("name") String name, @Param("type") String type);
}
