/* https://github.com/orange1438 */
package com.zhongzhou.dao.system;

import com.zhongzhou.dao.IMapper;
import com.zhongzhou.dao.IMapper;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysMenuCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.zhongzhou.dao.IMapper;
import com.zhongzhou.entity.system.TSysMenu;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438
 * date:2018/07/19 15:55
 */
@Repository
public interface TSysMenuDAO extends IMapper<TSysMenu, TSysMenuCriteria, Integer> {

    List<TSysMenu> selectAllWithPermissionByUserGroupId(@Param("usergroupid") Integer usergroupid);

    List<TSysMenu> selectAllWithPermissionByRoleId(@Param("roleid") Integer roleid);
    
    List<TSysMenu> selectAllWithMenuByRoleId(@Param("roleid") Integer roleid);
    
    

    List<TSysMenu> selectAllGroupByMenuIDRoleId(@Param("roleid") Integer roleid);

    List<TSysMenu> selectRoleMenusInAllMenusByUpId(@Param("roleid") Integer roleid, @Param("upid") Integer upid);
}