/**    
 * @author chenjh  
 * @Description: 
 * @Package com.weip.law.service.weip.impl   
 * @Title: WeipServiceImpl.java   
 * @date 2016年8月29日 上午10:20:39   
 * @version V1.0 
 * @说明  代码版权归 杭州艮山网络科技有限公司 所有
 */
package com.fuli.web.service.main.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fuli.web.dao.main.InterfaceDao;
import com.fuli.web.pojo.InterfaceInfo;
import com.fuli.web.service.main.InterfaceService;

@Service("interfaceService")
public class InterfaceServiceImpl implements InterfaceService {

	@Autowired
	private InterfaceDao interfaceDao;

	public void createAccessKey(InterfaceInfo weip) {
		interfaceDao.insertSelective(weip);
	}

	public InterfaceInfo queryByAccessKey(String token) {
		return interfaceDao.queryByAccessKey(token);
	}

	public List<InterfaceInfo> queryAll() {
		return interfaceDao.selectAll();
	}


}
