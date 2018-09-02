package com.igogogo.service;

import java.util.List;

import com.igogogo.domain.ItemDescx;
import com.igogogo.domain.ItemDetails;
import com.igogogo.domain.ItemRate;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.domain.NTbkShop;
import com.taobao.api.response.JuItemsSearchResponse.Items;
import com.taobao.api.response.TbkCouponGetResponse.MapData;
import com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon;
import com.taobao.api.response.TbkJuTqgGetResponse.Results;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;
import com.taobao.api.response.TbkTpwdCreateResponse;

public interface TaobaokeService {

	/**
	 * 通过商品编号获取商品信息 (商品基础信息、优惠券信息、淘口令)
	 * 
	 * @param itemId
	 *            商品编号
	 */
	public ItemDetails queryItemInfoByItemId(String itemId);

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
	public ItemRate queryRateByCondition(String itemId, String sellerId, String currentPage);

	/**
	 * 通过商品编号获取商品详情
	 * 
	 * @param id
	 *            商品编号
	 */
	public ItemDescx queryItemById(String id);

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
	public List<Items> jhs(String keyword, Long page, Long pagesize);

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
	public List<com.taobao.api.response.TbkDgMaterialOptionalResponse.MapData> queryMaterialByKeyWord(Long page,
			Long pagesize, String cids, Long startprice, Long endprice);

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
	public TbkTpwdCreateResponse.MapData createCode(String title, String gourl, String img);

	/**
	 * taobao.tbk.coupon.get (阿里妈妈推广券信息查询) 配合好券清单API 一起用
	 * 
	 * @param me
	 *            https://uland.taobao.com/coupon/edetail?e= 后面的参数部分
	 */
	public MapData queryCouponInfoByMe(String me);

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
	public List<TbkCoupon> queryCouponByKeyWord(String keyword, Long page, Long pagesize);

	/**
	 * taobao.tbk.spread.get (物料传播方式获取) 输入一个原始的链接，转换得到指定的传播方式，如二维码，淘口令，短连接；
	 * 现阶段只支持短连接。
	 * 支持uland.taobao.com，s.click.taobao.com，ai.taobao.com，temai.taobao.com的域名转换
	 * 
	 * @param requesturl
	 *            需要转换的url地址
	 */
	public List<TbkSpread> shortLink(String requesturl);

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
	public List<Results> tqg(String starttime, String endtime, Long page, Long pagesize);

	/**
	 * taobao.tbk.shop.recommend.get (淘宝客店铺关联推荐查询) 例如:373250426
	 * 
	 * @param userid
	 *            店铺用户编号
	 * @param count
	 *            返回数量(默认20，最大值40)
	 */
	public List<NTbkShop> queryShopsByKeyUidRelated(Long userid, Long count);

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
	public List<NTbkShop> queryShopByKeyWord(String keyword, Long page, Long pagesize);

	/**
	 * taobao.tbk.item.info.get (淘宝客商品详情（简版）) 例如:557930101000,558285153116
	 * 
	 * @param numIids
	 *            商品编号串
	 */
	public List<NTbkItem> queryItemsByIds(String numIids);

	/**
	 * taobao.tbk.item.recommend.get (淘宝客商品关联推荐查询) 例子:546521533831L
	 * 
	 * @param pid
	 *            商品编号
	 * @param count
	 *            返回数量(默认20，最大值40)
	 */
	public List<NTbkItem> queryItemsByKeyPidRelated(Long pid, Long count);

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
	public List<NTbkItem> queryItemsByKeyWord(String keyword, Long page, Long pagesize);

}
