package ${controller.packageName}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ren.kura.common.api.vo.Result;
import ${controller.packageName}.entity.${controller.entityName};
import ${controller.packageName}.service.I${controller.entityName}Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;

 /**
 * @Description: ${controller.entityName}Controller
 * @Author: ${controller.author}
 * @Date:   ${.now?string["yyyy-MM-dd"]}
 * @since: V1.0
 */
@Api(tags="${controller.entityName}Controller")
@RestController
@RequestMapping("/${controller.entityName?lower_case}")
@Slf4j
public class ${controller.entityName}Controller {
	@Autowired
	private I${controller.entityName}Service ${controller.entityName?uncap_first}Service;
	
	/**
	 * 分页列表查询
	 *
	 * @param ${controller.entityName?uncap_first}
	 * @param pageNo 页数
	 * @param pageSize 条数
	 * @param req
	 * @return
	 */
	@ApiOperation(value="${controller.entityName}-分页列表查询", notes="${controller.entityName}-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(${controller.entityName} ${controller.entityName?uncap_first},
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<${controller.entityName}> queryWrapper = new QueryWrapper(${controller.entityName?uncap_first})
		Page<${controller.entityName}> page = new Page<${controller.entityName}>(pageNo, pageSize);
		IPage<${controller.entityName}> pageList = ${controller.entityName?uncap_first}Service.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ${controller.entityName?uncap_first}
	 * @return
	 */
	@ApiOperation(value="${controller.entityName}-添加", notes="${controller.entityName}-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody ${controller.entityName} ${controller.entityName?uncap_first}) {
		${controller.entityName?uncap_first}Service.save(${controller.entityName?uncap_first});
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ${controller.entityName?uncap_first}
	 * @return
	 */
	@ApiOperation(value="${controller.entityName}-编辑", notes="${controller.entityName}-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody ${controller.entityName} ${controller.entityName?uncap_first}) {
		${controller.entityName?uncap_first}Service.updateById(${controller.entityName?uncap_first});
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id 主键
	 * @return
	 */
	@ApiOperation(value="${controller.entityName}-通过id删除", notes="${controller.entityName}-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		${controller.entityName?uncap_first}Service.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids 以逗号隔开的主键字符串
	 * @return
	 */
	@ApiOperation(value="${controller.entityName}-批量删除", notes="${controller.entityName}-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.${controller.entityName?uncap_first}Service.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id 主键
	 * @return
	 */
	@ApiOperation(value="${controller.entityName}-通过id查询", notes="${controller.entityName}-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		${controller.entityName} ${controller.entityName?uncap_first} = ${controller.entityName?uncap_first}Service.getById(id);
		if(${controller.entityName?uncap_first}==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(${controller.entityName?uncap_first});
	}


}
