package com.igogogo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igogogo.domain.ItemDescx;
import com.igogogo.domain.ItemDetails;
import com.igogogo.domain.ItemRate;
import com.igogogo.domain.ResultJson;
import com.igogogo.service.TaobaokeService;
import com.igogogo.utils.StringUtils;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.domain.NTbkShop;
import com.taobao.api.request.JuItemsSearchRequest.TopItemQuery;
import com.taobao.api.request.TbkCouponGetRequest;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkShopGetRequest;
import com.taobao.api.request.TbkShopRecommendGetRequest;
import com.taobao.api.request.TbkSpreadGetRequest.TbkSpreadRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.JuItemsSearchResponse.Items;
import com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon;
import com.taobao.api.response.TbkDgMaterialOptionalResponse.MapData;
import com.taobao.api.response.TbkJuTqgGetResponse.Results;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "${server.api-path}/tbk")
@Api(value = "TaobaokeApi", description = "淘宝客相关API")
public class TaobaokeApi {

	@Autowired
	private TaobaokeService service;

	/**
	 * 通过商品编号获取商品信息 (商品基础信息、优惠券信息、淘口令)
	 * 
	 * @param itemId
	 *            商品编号
	 */
	@ApiOperation(value = "通过商品编号获取商品基础、优惠券、淘口令信息")
	@RequestMapping(value = "/itemdetail/{itemId}", method = RequestMethod.GET)
	public ResultJson queryItemInfoByItemId(@PathVariable String itemId) {
		ItemDetails itemDetails = service.queryItemInfoByItemId(itemId);
		if (itemDetails != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(itemDetails);
		} else {
			return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
		}
	}

	/**
	 * 通过商品编号、卖家编号、当前页码，获取商品评论
	 * 
	 * @param itemId
	 *            商品编号
	 * @param sellerId
	 *            卖家编号
	 * @param currentPage
	 *            当前页码
	 */
	@ApiOperation(value = "通过编号获取商品评论")
	@RequestMapping(value = "/rate/{itemId}/{sellerId}/{currentPage}", method = RequestMethod.GET)
	public ResultJson queryRateByCondition(@PathVariable String itemId, @PathVariable String sellerId,
			@PathVariable String currentPage) {
		ItemRate itemRate = service.queryRateByCondition(itemId, sellerId, currentPage);
		return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(itemRate);
	}

	/**
	 * 通过商品编号获取商品详情
	 * 
	 * @param id
	 *            商品编号
	 */
	@ApiOperation(value = "通过商品编号获取商品详情")
	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
	public ResultJson queryItemById(@PathVariable String id) {
		ItemDescx itemInfo = service.queryItemById(id);
		return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
				.setData(itemInfo);
	}

	/**
	 * taobao.ju.items.search (聚划算商品搜索接口)
	 * 
	 * @param keyword
	 *            搜索关键词
	 * @param page
	 *            当前页码
	 * @param pagesize
	 *            每页大小
	 */
	@ApiOperation(value = "聚划算商品搜索接口")
	@RequestMapping(value = "/jhs", method = RequestMethod.POST)
	public ResultJson jhs(@RequestBody TopItemQuery req) {
		List<Items> list = service.jhs(req.getWord(), req.getCurrentPage(), req.getPageSize());
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.dg.material.optional (通用物料搜索API（导购）)
	 * 
	 * @param keyword
	 *            搜索关键词
	 * 
	 * @param page
	 *            当前页码
	 * @param pagesize
	 *            每页大小(默认20，1~100)
	 */
	@ApiOperation(value = "通用物料搜索API（导购）")
	@RequestMapping(value = "/querymaterialbykeyword", method = RequestMethod.POST)
	public ResultJson queryMaterialByKeyWord(@RequestParam Long page, @RequestParam Long pagesize,
			@RequestParam String cids, @RequestParam Long startprice, @RequestParam Long endprice) {
		List<MapData> list = service.queryMaterialByKeyWord(page, pagesize, cids, startprice, endprice);
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.tpwd.create (淘宝客淘口令) 提供淘客生成淘口令接口,生成淘口令关键key如：￥SADadW￥
	 * 
	 * @param title
	 *            标题
	 * @param gourl
	 *            需要打开的商品地址
	 * @param img
	 *            商品封面图片
	 */
	@ApiOperation(value = "生成淘口令关键key")
	@RequestMapping(value = "/createcode", method = RequestMethod.POST)
	public ResultJson createCode(@RequestBody TbkTpwdCreateRequest req) {
		com.taobao.api.response.TbkTpwdCreateResponse.MapData mapData = service.createCode(req.getText(), req.getUrl(),
				req.getLogo());
		if (mapData != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(mapData);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.coupon.get (阿里妈妈推广券信息查询) 配合好券清单API 一起用
	 * 
	 * @param me
	 *            https://uland.taobao.com/coupon/edetail?e= 后面的参数部分
	 */
	@ApiOperation(value = "阿里妈妈推广券信息查询")
	@RequestMapping(value = "/querycouponinfobyme", method = RequestMethod.POST)
	public ResultJson queryCouponInfoByMe(@RequestBody TbkCouponGetRequest req) {

		com.taobao.api.response.TbkCouponGetResponse.MapData mapData = service
				.queryCouponInfoByMe(StringUtils.meargs(req.getMe()));
		if (mapData != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(mapData);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.dg.item.coupon.get (好券清单API【导购】)
	 * 最多出10000个结果，即page_no*page_size不能超过200
	 * 
	 * @param keyword
	 *            关键词
	 * @param page
	 *            当前页码
	 * @param pagesize
	 *            每页大小(默认20，1~100)
	 */
	@ApiOperation(value = "好券清单API【导购】")
	@RequestMapping(value = "/querycouponbykeyword", method = RequestMethod.POST)
	public ResultJson queryCouponByKeyWord(@RequestBody TbkDgItemCouponGetRequest req) {
		List<TbkCoupon> list = service.queryCouponByKeyWord(req.getQ(), req.getPageNo(), req.getPageSize());
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.spread.get (物料传播方式获取) 输入一个原始的链接，转换得到指定的传播方式，如二维码，淘口令，短连接；
	 * 现阶段只支持短连接。
	 * 支持uland.taobao.com，s.click.taobao.com，ai.taobao.com，temai.taobao.com的域名转换
	 * 
	 * @param requesturl
	 *            需要转换的url地址
	 */
	@ApiOperation(value = "短连接")
	@RequestMapping(value = "/shortlink", method = RequestMethod.POST)
	public ResultJson shortLink(@RequestBody TbkSpreadRequest req) {
		List<TbkSpread> list = service.shortLink(req.getUrl());
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.ju.tqg.get (淘抢购api) 限时抢购
	 * 
	 * @param starttime
	 *            开始时间
	 * @param endtime
	 *            结束时间
	 * @param page
	 *            页码(默认1，1~100)
	 * @param pagesize
	 *            每页大小(默认40，1~40)
	 */
	@ApiOperation(value = "淘抢购")
	@RequestMapping(value = "/tqg", method = RequestMethod.POST)
	public ResultJson tqg(@RequestParam String startTime, @RequestParam String endTime, @RequestParam Long pageNo,
			@RequestParam Long pageSize) {
		List<Results> list = service.tqg(startTime, endTime, pageNo, pageSize);
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.shop.recommend.get (淘宝客店铺关联推荐查询) 例如:373250426
	 * 
	 * @param userid
	 *            店铺用户编号
	 * @param count
	 *            返回数量(默认20，最大值40)
	 */
	@ApiOperation(value = "淘宝客店铺关联推荐查询")
	@RequestMapping(value = "/queryshopsbykeyuidrelated", method = RequestMethod.POST)
	public ResultJson queryShopsByKeyUidRelated(@RequestBody TbkShopRecommendGetRequest req) {
		List<NTbkShop> list = service.queryShopsByKeyUidRelated(req.getUserId(), req.getCount());
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.shop.get (淘宝客店铺查询)
	 * 
	 * @param keyword
	 *            店铺关键词
	 * @param page
	 *            当前页码
	 * @param pagesize
	 *            每页大小
	 */
	@ApiOperation(value = "淘宝客店铺查询")
	@RequestMapping(value = "/queryshopbykeyword", method = RequestMethod.POST)
	public ResultJson queryShopByKeyWord(@RequestBody TbkShopGetRequest req) {
		List<NTbkShop> list = service.queryShopByKeyWord(req.getQ(), req.getPageNo(), req.getPageSize());
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.item.info.get (淘宝客商品详情（简版）) 例如:557930101000,558285153116
	 * 
	 * @param numIids
	 *            商品编号串
	 */
	@ApiOperation(value = "淘宝客商品详情（简版）")
	@RequestMapping(value = "/queryitemsbyids", method = RequestMethod.POST)
	public ResultJson queryItemsByIds(@RequestBody TbkItemInfoGetRequest req) {
		List<NTbkItem> list = service.queryItemsByIds(req.getNumIids());
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.item.recommend.get (淘宝客商品关联推荐查询) 例子:546521533831L
	 * 
	 * @param pid
	 *            商品编号
	 * @param count
	 *            返回数量(默认20，最大值40)
	 */
	@ApiOperation(value = "淘宝客商品关联推荐查询")
	@RequestMapping(value = "/queryitemsbykeypidrelated", method = RequestMethod.POST)
	public ResultJson queryItemsByKeyPidRelated(@RequestParam Long numIid, @RequestParam Long count) {
		List<NTbkItem> list = service.queryItemsByKeyPidRelated(numIid, count);
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

	/**
	 * taobao.tbk.item.get (淘宝客商品查询)
	 * 
	 * @param keyword
	 *            查询关键词
	 * @param page
	 *            当前页码
	 * @param pagesize
	 *            每页大小
	 */
	@ApiOperation(value = "淘宝客商品查询")
	@RequestMapping(value = "/queryitemsbykeyword", method = RequestMethod.POST)
	public ResultJson queryItemsByKeyWord(@RequestBody TbkItemGetRequest req) {
		List<NTbkItem> list = service.queryItemsByKeyWord(req.getQ(), req.getPageNo(), req.getPageSize());
		if (list != null) {
			return ResultJson.getInstance().setCode(StringUtils.SUCCESS_CODE).setMsg(StringUtils.SUCCESS_MSG)
					.setData(list);
		}
		return ResultJson.getInstance().setCode(StringUtils.FAIL_CODE).setMsg(StringUtils.FAIL_MSG).setData(null);
	}

}
