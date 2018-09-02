package com.igogogo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Tqg;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "${server.api-path}/tqg")
@Api(value = "TqgController", description = "淘抢购相关接口")
public class Ig_TqgController extends BaseController<Ig_Tqg> {

}
