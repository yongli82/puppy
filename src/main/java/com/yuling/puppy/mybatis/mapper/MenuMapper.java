package com.yuling.puppy.mybatis.mapper;


import com.yuling.puppy.mybatis.domain.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yangyongli on 20/11/2016.
 */
@Repository
@Mapper
public interface MenuMapper {

    List<Menu> retrieveMenuList();
}
