package com.igogogo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.Ig_Itemcoupon;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "${server.api-path}/itemcoupon")
@Api(value = "ItemcouponController", description = "好券清单相关接口")
public class Ig_ItemcouponController extends BaseController<Ig_Itemcoupon> {

}
