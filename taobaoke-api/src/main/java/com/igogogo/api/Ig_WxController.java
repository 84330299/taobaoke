package com.igogogo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Wx;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "${server.api-path}/wx")
@Api(value = "WxController", description = "微信相关接口")
public class Ig_WxController extends BaseController<Ig_Wx> {

}
