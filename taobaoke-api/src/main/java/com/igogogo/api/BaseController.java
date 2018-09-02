package com.igogogo.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.ResultJson;
import com.igogogo.domain.ResultPageJson;
import com.igogogo.domain.TbkPageRequest;
import com.igogogo.service.BaseService;
import com.igogogo.utils.StringUtils;

import io.swagger.annotations.ApiOperation;

@RestController
public abstract class BaseController<T> {

	@Autowired
	private BaseService<T> service;

	@ApiOperation(value = "添加单个")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResultJson add(@RequestBody T t) {
		if (t != null) {
			if (service.add(t) > 0) {
				return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
						.setData(null);
			}
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "添加多个")
	@RequestMapping(value = "/more", method = RequestMethod.POST)
	public ResultJson addmore(@RequestBody List<T> ts) {
		if (ts != null && ts.size() > 0) {
			if (service.addmore(ts) > 0) {
				return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
						.setData(null);
			}
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "删除")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResultJson delete(@PathVariable Integer id) {
		if (id != null && id > 0) {
			if (service.delete(id) > 0) {
				return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
						.setData(null);
			}
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "删除多个")
	@RequestMapping(value = "/more", method = RequestMethod.DELETE)
	public ResultJson deletemore(@RequestBody List<Integer> ids) {
		if (ids != null && ids.size() > 0) {
			if (service.deleteByMoreId(ids) > 0) {
				return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
						.setData(null);
			}
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "修改")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResultJson update(@PathVariable Integer id, @RequestBody T t) {
		if (t != null) {
			if (service.update(id, t) > 0) {
				return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
						.setData(null);
			}
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "修改多个")
	@RequestMapping(value = "/more", method = RequestMethod.PUT)
	public ResultJson updatemore(@RequestBody List<T> ts) {
		if (ts != null && ts.size() > 0) {
			if (service.updatemore(ts) > 0) {
				return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
						.setData(null);
			}
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "查所有")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResultPageJson query() {
		List<T> list = service.query();
		if (list != null && list.size() > 0) {
			return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list).setTotalCount(list.size()).setTotalPage(0);
		}
		return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(null).setTotalCount(0).setTotalPage(0);
	}

	@ApiOperation(value = "通过编号查")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResultJson queryById(@PathVariable Integer id) {
		if (id != null && id > 0) {
			T obj = service.queryById(id);
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(obj);
		}
		return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG).setData(null);
	}

	@ApiOperation(value = "通过分页查询")
	@RequestMapping(value = "/page/{size}/{page}", method = RequestMethod.GET)
	public ResultPageJson queryByPage(@PathVariable Integer size, @PathVariable Integer page) {
		if (size != null && page != null && size > 0 && page > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("size", size);
			map.put("page", (page - 1) * size);
			List<T> list = service.queryByPage(map);
			Integer count = service.queryCount();
			return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list).setTotalCount(count).setTotalPage(((count - 1) / size) + 1);
		}
		return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(null).setTotalCount(0).setTotalPage(0);
	}

	@ApiOperation(value = "通过关键词模糊分页查询[推荐]")
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public ResultPageJson queryKeyWordByPage(@RequestBody TbkPageRequest request) {
		if (request != null && request.getPage() != null && request.getSize() != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("size", request.getSize());
			map.put("page", (request.getPage() - 1) * request.getSize());
			map.put("title", request.getKeyword());
			List<T> list = service.queryKeyWordByPage(map);
			Integer count = service.queryCountByKeyWord(request.getKeyword());
			return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list).setTotalCount(count).setTotalPage(((count - 1) / request.getSize()) + 1);
		}
		return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(null).setTotalCount(0).setTotalPage(0);
	}

	@ApiOperation(value = "通过条件查询(列名/列值)")
	@RequestMapping(value = "/condition/{columnname}/{columnval}", method = RequestMethod.POST)
	public ResultPageJson queryByCondition(@PathVariable String columnname, @PathVariable String columnval) {
		if (columnname != null && columnval != null && !"".equals(columnname) && !"".equals(columnval)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("columnname", columnname);
			map.put("columnval", columnval);
			List<T> list = service.queryByCondition(map);
			return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list).setTotalCount(list.size()).setTotalPage(0);
		}
		return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(null).setTotalCount(0).setTotalPage(0);
	}

	@ApiOperation(value = "通过条件查询(列名/列值/是否like(1是,0否)/页码/行数)")
	@RequestMapping(value = "/condition/{columnname}/{columnval}/{islike}/{page}/{size}", method = RequestMethod.POST)
	public ResultPageJson queryByConditionByPage(@PathVariable String columnname, @PathVariable String columnval,
			@PathVariable Integer islike, @PathVariable Integer page, @PathVariable Integer size) {
		if (columnname != null && columnval != null && !"".equals(columnname) && !"".equals(columnval)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("columnname", columnname);
			map.put("columnval", columnval);
			map.put("islike", islike);
			map.put("page", (page - 1) * size);
			map.put("size", size);
			List<T> list = service.queryByConditionByPage(map);
			return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list).setTotalCount(list.size()).setTotalPage(0);
		}
		return ResultPageJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(null).setTotalCount(0).setTotalPage(0);
	}
}
