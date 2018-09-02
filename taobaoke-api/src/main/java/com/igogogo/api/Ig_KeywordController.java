package com.igogogo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Keyword;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "${server.api-path}/keyword")
@Api(value = "KeyWordController", description = "搜索关键词相关接口")
public class Ig_KeywordController extends BaseController<Ig_Keyword> {

}
