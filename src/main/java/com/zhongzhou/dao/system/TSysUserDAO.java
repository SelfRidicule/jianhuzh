/* https://github.com/orange1438 */
package com.zhongzhou.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.IMapper;
import com.zhongzhou.entity.DepartVo;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.entity.system.TSysUserCriteria;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438
 * date:2018/09/29 17:57
 */
@Repository
public interface TSysUserDAO extends IMapper<TSysUser, TSysUserCriteria, Integer> {
	
	public List<DepartVo> queryDepartMans();


    /**
     * 查询指定权限用户
     * @param roleper
     * @return
     */
    List<TSysUser> queryUserRoleper(@Param("roleper") Integer roleper);


    List<TSysUser> pageList(@Param("keyword")String keyword);

}