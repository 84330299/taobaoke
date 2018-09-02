package com.igogogo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Jhs;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "${server.api-path}/jhs")
@Api(value = "JhsController", description = "聚划算相关接口")
public class Ig_JhsController extends BaseController<Ig_Jhs> {

}
