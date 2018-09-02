package com.igogogo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Banner;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "${server.api-path}/banner")
@Api(value = "BannerController", description = "Banner相关接口")
public class Ig_BannerController extends BaseController<Ig_Banner> {

}
