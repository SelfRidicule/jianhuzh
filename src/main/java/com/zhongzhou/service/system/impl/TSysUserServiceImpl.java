package com.zhongzhou.service.system.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.system.TSysUserDAO;
import com.zhongzhou.entity.DepartVo;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.entity.system.TSysUserCriteria;
import com.zhongzhou.service.system.TSysUserService;
import com.zhongzhou.utils.AccessToken;
import com.zhongzhou.utils.HttpRequestUtil;

@Service
public class TSysUserServiceImpl implements TSysUserService {
    @Autowired
    private TSysUserDAO sysUserDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysUserServiceImpl.class);
    
    private ObjectMapper objectMapper=new ObjectMapper();

    public int countByExample(TSysUserCriteria example) {
        int count = this.sysUserDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysUser selectByPrimaryKey(Integer id) {
        return this.sysUserDAO.selectByPrimaryKey(id);
    }

    public List<TSysUser> selectByExample(TSysUserCriteria example) {
        return this.sysUserDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.sysUserDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysUser record) {
        return this.sysUserDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysUser record) {
        return this.sysUserDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysUserCriteria example) {
        return this.sysUserDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysUser record, TSysUserCriteria example) {
        return this.sysUserDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysUser record, TSysUserCriteria example) {
        return this.sysUserDAO.updateByExample(record, example);
    }

    public int insert(TSysUser record) {
        return this.sysUserDAO.insert(record);
    }

    public TSysUser insertSelective(TSysUser record) {
        this.sysUserDAO.insertSelective(record);
        return record;
    }
    
    
    @Override
    public PageInfo selectByExample(TSysUserCriteria example, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<TSysUser> list = sysUserDAO.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        return page;
    }

	@Override
	public List<DepartVo> queryDepartMans() {
		
		return sysUserDAO.queryDepartMans();
	}
    
    
	
	@Override
	public void initUser() {
		Integer[] arr={52,86,53,55,56,54,69,68,63,67,66,72,61,71,57,65,73,74,75,76,77,80,82,83,84,85,62,60,93,153};
		String token = AccessToken.getAccessToken();
		for(Integer departid:arr){
			List<TSysUser> listUser=new ArrayList<TSysUser>();
			String url = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token="+token+"&department_id="+departid+"&fetch_child=1";
			String s = HttpRequestUtil.sendGet(url);
			System.out.println("获取到的人员信息==" + s);
			try {
				JsonNode jsonNode=objectMapper.readTree(s);
				JsonNode jnarr=jsonNode.get("userlist");
				for(int i=0;i<jnarr.size();i++){
					TSysUser user=new TSysUser();
					JsonNode jn=jnarr.get(i);
					String policenum=jn.get("userid").textValue();
					String name=jn.get("name").textValue();
					String mobile=jn.get("mobile").textValue();
					String avatar=jn.get("avatar").textValue();
					String gender=jn.get("gender").textValue();
					user.setAvatar(avatar);
					user.setPhone(mobile);
					user.setSex(Integer.parseInt(gender));
					user.setUsername(name);
					user.setWeixinid(policenum);
					user.setDepartid(departid);
					user.setAccount(policenum);
					listUser.add(user);
				}
				sysUserDAO.insertBatch(listUser);
			}catch (IOException e) {
				System.out.println("解析异常");
				e.printStackTrace();
			}
			
		}
		
		System.out.println("导入成功");
		
	}

    @Override
    public HttpResult pageList(String keyword, Integer pageSize, Integer pageNum) {

        PageHelper.startPage(pageNum, pageSize);
        List<TSysUser> list = sysUserDAO.pageList(keyword);
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);

        HttpResult httpResult = new HttpResult();
        httpResult.setCode(Consts.SUCCESS);
        httpResult.setData(page.getList());
        httpResult.setCount(page.getTotal());

        return httpResult;
    }


}