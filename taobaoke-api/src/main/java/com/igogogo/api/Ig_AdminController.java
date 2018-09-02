package com.igogogo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Admin;
import com.igogogo.domain.ResultJson;
import com.igogogo.service.Ig_AdminService;
import com.igogogo.utils.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "${server.api-path}/admin")
@Api(value = "AdminController", description = "管理员相关接口")
public class Ig_AdminController {

	@Autowired
	private Ig_AdminService adminService;

	@ApiOperation(value = "登录")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultJson login(@RequestBody Ig_Admin admin) {
		Ig_Admin returnModel = adminService.login(admin);
		if (returnModel != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(returnModel);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "注册")
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ResultJson regist(@RequestBody Ig_Admin admin) {
		if (adminService.regist(admin) > 0) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(null);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	@ApiOperation(value = "检查账号")
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ResultJson check(@RequestBody Ig_Admin admin) {
		Ig_Admin returnModel = adminService.checkAccount(admin);
		if (returnModel != null) {
			return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG)
					.setData(returnModel);
		}
		return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG).setData(null);
	}

}
