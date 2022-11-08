/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 * No deletion without permission, or be held responsible to law.
 */
package com.jeesite.modules.test.api;

import com.jeesite.common.entity.Page;
import com.jeesite.modules.test.entity.TestTree;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 测试数据API
 * @author ThinkGem
 * @version 2018-10-18
 */
@RequestMapping(value = "/api/test2/testTree")
public interface TestTreeServiceApi {
	
	/**
	 * 获取单条数据
	 * @param testTree
	 * @return
	 */
	@RequiresPermissions("test:testTree:view")
	@PostMapping(value = "getByPk")
	public TestTree get(@RequestParam(name = "id", required = false) String id);
	
	/**
	 * 获取单条数据
	 * @param testTree
	 * @return
	 */
	@RequiresPermissions("test:testTree:view")
	@PostMapping(value = "getByPkAndIsNewRecord")
	public TestTree get(@RequestParam(name = "id", required = false) String id, @RequestParam("isNewRecord") boolean isNewRecord);
	
	/**
	 * 根据父节点单条数据
	 * @param testTree
	 * @return
	 */
	@RequiresPermissions("test:testTree:view")
	@PostMapping(value = "getLastByParentCode")
	public TestTree getLastByParentCode(TestTree testTree);
	
	/**
	 * 查询分页数据
	 * @param testTree
	 * @return
	 */
	@RequiresPermissions("test:testTree:view")
	@PostMapping(value = "findList")
	public List<TestTree> findList(TestTree testTree);
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param testTree
	 * @return
	 */
	@RequiresPermissions("test:testTree:view")
	@PostMapping(value = "findPage")
	public Page<TestTree> findPage(TestTree testTree);
	
	/**
	 * 查询数据总数
	 * @param testTree
	 * @return
	 */
	@RequiresPermissions("test:testTree:view")
	@PostMapping(value = "findCount")
	public long findCount(TestTree testTree);
	
	/**
	 * 保存数据（插入或更新）
	 * @param testTree
	 */
	@RequiresPermissions("test:testTree:edit")
	@PostMapping(value = "save")
	public void save(TestTree testTree);
	
	/**
	 * 更新状态
	 * @param testTree
	 */
	@RequiresPermissions("test:testTree:edit")
	@PostMapping(value = "updateStatus")
	public void updateStatus(TestTree testTree);
	
	/**
	 * 删除数据
	 * @param testTree
	 */
	@RequiresPermissions("test:testTree:edit")
	@PostMapping(value = "delete")
	public void delete(TestTree testTree);
	
	/**
	 * 修复树结构数据
	 * @param testTree
	 */
	@RequiresPermissions("test:testTree:edit")
	@PostMapping(value = "fixTreeData")
	public void fixTreeData();
	
}