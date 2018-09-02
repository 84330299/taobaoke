package com.igogogo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Category;
import com.igogogo.domain.ResultPageJson;
import com.igogogo.service.Ig_CategoryService;
import com.igogogo.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "${server.api-path}/category")
@Api(value = "CategoryController", description = "分类相关接口")
public class Ig_CategoryController extends BaseController<Ig_Category> {

	@Autowired
	private Ig_CategoryService service;

	@ApiOperation(value = "通过父类编号获取所有子分类")
	@RequestMapping(value = "childrens/{id}", method = RequestMethod.GET)
	public ResultPageJson queryAllChildrenByParentId(@PathVariable Integer id) {
		List<Ig_Category> list = service.queryAllChildrenByParentId(id);
		if (list != null && list.size() > 0) {
			return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list).setTotalCount(list.size()).setTotalPage(0);
		}
		return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(null).setTotalCount(0).setTotalPage(0);
	}
}
