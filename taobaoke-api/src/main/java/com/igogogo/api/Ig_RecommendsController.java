package com.igogogo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Recommends;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "${server.api-path}/recommends")
@Api(value = "RecommendsController", description = "推荐位相关接口")
public class Ig_RecommendsController extends BaseController<Ig_Recommends> {

}
