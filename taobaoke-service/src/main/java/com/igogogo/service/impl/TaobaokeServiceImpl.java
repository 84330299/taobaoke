package com.igogogo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.igogogo.domain.ItemDescx;
import com.igogogo.domain.ItemDetails;
import com.igogogo.domain.ItemRate;
import com.igogogo.service.TaobaokeService;
import com.igogogo.utils.PropertyUtil;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.domain.NTbkShop;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.internal.util.WebUtils;
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.request.JuItemsSearchRequest.TopItemQuery;
import com.taobao.api.request.TbkCouponGetRequest;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkItemRecommendGetRequest;
import com.taobao.api.request.TbkJuTqgGetRequest;
import com.taobao.api.request.TbkShopGetRequest;
import com.taobao.api.request.TbkShopRecommendGetRequest;
import com.taobao.api.request.TbkSpreadGetRequest;
import com.taobao.api.request.TbkSpreadGetRequest.TbkSpreadRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.JuItemsSearchResponse.Items;
import com.taobao.api.response.TbkCouponGetResponse;
import com.taobao.api.response.TbkCouponGetResponse.MapData;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkItemRecommendGetResponse;
import com.taobao.api.response.TbkJuTqgGetResponse;
import com.taobao.api.response.TbkJuTqgGetResponse.Results;
import com.taobao.api.response.TbkShopGetResponse;
import com.taobao.api.response.TbkShopRecommendGetResponse;
import com.taobao.api.response.TbkSpreadGetResponse;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;
import com.taobao.api.response.TbkTpwdCreateResponse;

/**
 * 淘宝客sdk业务封装Ø
 */
@Service
public class TaobaokeServiceImpl implements TaobaokeService {

	private final String URL = PropertyUtil.getProperty("taobaoke.properties", "url");
	private final String APPKEY = PropertyUtil.getProperty("taobaoke.properties", "appkey");
	private final String SECRET = PropertyUtil.getProperty("taobaoke.properties", "secret");
	private final Long ADZONEID = Long.parseLong(PropertyUtil.getProperty("taobaoke.properties", "adzoneid"));
	private final String USERID = PropertyUtil.getProperty("taobaoke.properties", "userid");
	private final String PID = PropertyUtil.getProperty("taobaoke.properties", "pid");
	private final String ITEM_URL = PropertyUtil.getProperty("taobaoke.properties", "itemurl");
	private final String RATE_URL = PropertyUtil.getProperty("taobaoke.properties", "rateurl");

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
	public ItemRate queryRateByCondition(String itemId, String sellerId, String currentPage) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("itemId", itemId);
		params.put("sellerId", sellerId);
		params.put("currentPage", currentPage);
		try {
			String doGet = WebUtils.doGet(RATE_URL, params).replace("\"rateDetail\":", "");
			return JSONObject.parseObject(doGet, ItemRate.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过商品编号获取商品详情
	 * 
	 * @param id
	 *            商品编号
	 */
	public ItemDescx queryItemById(String id) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("data", "{item_num_id:" + id + "}");
		try {
			String doGet = WebUtils.doGet(ITEM_URL, params);
			return JSONObject.parseObject(doGet, ItemDescx.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
	public List<Items> jhs(String keyword, Long page, Long pagesize) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		JuItemsSearchRequest req = new JuItemsSearchRequest();
		TopItemQuery obj1 = new TopItemQuery();
		// 页码,必传
		obj1.setCurrentPage(page);
		// 一页大小,必传
		obj1.setPageSize(pagesize);
		// 媒体pid,必传
		obj1.setPid(PID);
		// 是否包邮,可不传
		// obj1.setPostage(true);
		// 状态，预热：1，正在进行中：2,可不传
		// obj1.setStatus(2L);
		// 淘宝类目id,可不传
		// obj1.setTaobaoCategoryId(1000L);
		// 搜索关键词,可不传
		obj1.setWord(keyword);
		req.setParamTopItemQuery(obj1);
		try {
			JuItemsSearchResponse rsp = client.execute(req);
			List<Items> list = rsp.getResult().getModelList();
			return list;
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * taobao.tbk.dg.material.optional (通用物料搜索API（导购）)
	 * 
	 * @param keyword
	 *            搜索关键词
	 * @param page
	 *            当前页码
	 * @param pagesize
	 *            每页大小(默认20，1~100)
	 */
	public List<com.taobao.api.response.TbkDgMaterialOptionalResponse.MapData> queryMaterialByKeyWord(Long page,
			Long pagesize, String cids, Long startprice, Long endprice) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
		// 店铺dsr评分，筛选高于等于当前设置的店铺dsr评分的商品0-50000之间
		req.setStartDsr(10L);
		// 第几页，默认：１
		req.setPageNo(page);
		// 页大小，默认20，1~100
		req.setPageSize(pagesize);
		// 链接形式：1：PC，2：无线，默认：１
		// req.setPlatform(1L);
		// 淘客佣金比率上限，如：1234表示12.34%
		// req.setEndTkRate(1234L);
		// 淘客佣金比率下限，如：1234表示12.34%
		// req.setStartTkRate(1234L);
		// 折扣价范围上限，单位：元
		req.setEndPrice(startprice);
		// 折扣价范围下限，单位：元
		req.setStartPrice(endprice);
		// 是否海外商品，设置为true表示该商品是属于海外商品，设置为false或不设置表示不判断这个属性
		// req.setIsOverseas(false);
		// 是否商城商品，设置为true表示该商品是属于淘宝商城商品，设置为false或不设置表示不判断这个属性
		// req.setIsTmall(false);
		// 排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate），
		// 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）
		req.setSort("tk_total_sales_des");
		// 所在地
		// req.setItemloc("杭州");
		// 后台类目ID，用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
		req.setCat(cids);
		// 查询词
//		req.setQ(keyword);
		// 是否有优惠券，设置为true表示该商品有优惠券，设置为false或不设置表示不判断这个属性
		req.setHasCoupon(true);
		// mm_xxx_xxx_xxx的第三位
		req.setAdzoneId(ADZONEID);
		try {
			TbkDgMaterialOptionalResponse rsp = client.execute(req);
			return rsp.getResultList();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
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
	public TbkTpwdCreateResponse.MapData createCode(String title, String gourl, String img) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
		// 生成口令的淘宝用户ID
		req.setUserId(USERID);
		// 口令弹框内容
		req.setText(title);
		// 口令跳转目标页
		req.setUrl(gourl);
		// 口令弹框logoURL
		req.setLogo(img);
		// 扩展字段JSON格式
		// req.setExt("{}");
		try {
			TbkTpwdCreateResponse rsp = client.execute(req);
			return rsp.getData();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * taobao.tbk.coupon.get (阿里妈妈推广券信息查询) 配合好券清单API 一起用
	 * 
	 * @param me
	 *            https://uland.taobao.com/coupon/edetail?e= 后面的参数部分
	 */
	public MapData queryCouponInfoByMe(String me) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkCouponGetRequest req = new TbkCouponGetRequest();
		req.setMe(me);
		// 商品ID(可选)
		// req.setItemId(544216157143L);
		// 券ID(可选)
		// req.setActivityId("sdfwe3eefsdf");
		try {
			TbkCouponGetResponse rsp = client.execute(req);
			return rsp.getData();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
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
	public List<TbkCoupon> queryCouponByKeyWord(String keyword, Long page, Long pagesize) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
		// mm_xxx_xxx_xxx的第三位
		req.setAdzoneId(ADZONEID);
		// 1：PC，2：无线，默认：1
		// req.setPlatform(1L);
		// 后台类目ID，用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
		// req.setCat("16,18");
		// 查询词
		req.setQ(keyword);
		// 第几页，默认：1（当后台类目和查询词均不指定的时候，最多出10000个结果，即page_no*page_size不能超过200；当指定类目或关键词的时候，则最多出100个结果）
		req.setPageNo(page);
		// 页大小，默认20，1~100
		req.setPageSize(pagesize);
		try {
			TbkDgItemCouponGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * taobao.tbk.spread.get (物料传播方式获取) 输入一个原始的链接，转换得到指定的传播方式，如二维码，淘口令，短连接；
	 * 现阶段只支持短连接。
	 * 支持uland.taobao.com，s.click.taobao.com，ai.taobao.com，temai.taobao.com的域名转换
	 * 
	 * @param requesturl
	 *            需要转换的url地址
	 */
	public List<TbkSpread> shortLink(String requesturl) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkSpreadGetRequest req = new TbkSpreadGetRequest();
		List<TbkSpreadRequest> list2 = new ArrayList<TbkSpreadRequest>();
		TbkSpreadRequest obj3 = new TbkSpreadRequest();
		list2.add(obj3);
		obj3.setUrl(requesturl);
		req.setRequests(list2);
		try {
			TbkSpreadGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
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
	public List<Results> tqg(String starttime, String endtime, Long page, Long pagesize) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkJuTqgGetRequest req = new TbkJuTqgGetRequest();
		// 推广位id（推广位申请方式：http://club.alimama.com/read.php?spm=0.0.0.0.npQdST&tid=6306396&ds=1&page=1&toread=1）
		req.setAdzoneId(ADZONEID);
		// 需返回的字段列表
		req.setFields(
				"click_url,pic_url,reserve_price,zk_final_price,total_amount,sold_num,title,category_name,start_time,end_time");
		// 最早开团时间
		req.setStartTime(StringUtils.parseDateTime(starttime));
		// 最晚开团时间
		req.setEndTime(StringUtils.parseDateTime(endtime));
		// 第几页，默认1，1~100
		req.setPageNo(page);
		// 页大小，默认40，1~40
		req.setPageSize(pagesize);
		try {
			TbkJuTqgGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * taobao.tbk.shop.recommend.get (淘宝客店铺关联推荐查询) 例如:373250426
	 * 
	 * @param userid
	 *            店铺用户编号
	 * @param count
	 *            返回数量(默认20，最大值40)
	 */
	public List<NTbkShop> queryShopsByKeyUidRelated(Long userid, Long count) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkShopRecommendGetRequest req = new TbkShopRecommendGetRequest();
		// 需返回的字段列表
		req.setFields("user_id,shop_title,shop_type,seller_nick,pict_url,shop_url");
		req.setUserId(userid);
		// 返回数量，默认20，最大值40
		req.setCount(count);
		// 链接形式：1：PC，2：无线，默认：１
		// req.setPlatform(1L);
		try {
			TbkShopRecommendGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
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
	public List<NTbkShop> queryShopByKeyWord(String keyword, Long page, Long pagesize) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkShopGetRequest req = new TbkShopGetRequest();
		// 需返回的字段列表
		req.setFields("user_id,shop_title,shop_type,seller_nick,pict_url,shop_url");
		// 查询词
		req.setQ(keyword);
		// 排序_des（降序），排序_asc（升序），佣金比率（commission_rate），
		// 商品数量（auction_count），销售总数量（total_auction）
		req.setSort("total_auction_des");
		// 是否商城的店铺，设置为true表示该是属于淘宝商城的店铺，设置为false或不设置表示不判断这个属性
		// req.setIsTmall(false);
		// 信用等级下限，1~20
		// req.setStartCredit(1L);
		// 信用等级上限，1~20
		// req.setEndCredit(20L);
		// 淘客佣金比率下限，1~10000
		// req.setStartCommissionRate(2000L);
		// 淘客佣金比率上限，1~10000
		// req.setEndCommissionRate(123L);
		// 店铺商品总数下限
		// req.setStartTotalAction(1L);
		// 店铺商品总数上限
		// req.setEndTotalAction(100L);
		// 累计推广商品下限
		// req.setStartAuctionCount(123L);
		// 累计推广商品上限
		// req.setEndAuctionCount(200L);
		// 链接形式：1：PC，2：无线，默认：１
		// req.setPlatform(1L);
		// 第几页，默认1，1~100
		req.setPageNo(page);
		// 页大小，默认20，1~100
		req.setPageSize(pagesize);
		try {
			TbkShopGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * taobao.tbk.item.info.get (淘宝客商品详情（简版）) 例如:557930101000,558285153116
	 * 
	 * @param numIids
	 *            商品编号串
	 */
	public List<NTbkItem> queryItemsByIds(String numIids) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
		// 需返回的字段列表
		req.setFields(
				"num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,nick,seller_id,volume,cat_leaf_name,cat_name");
		// 链接形式：1：PC，2：无线，默认：１
		// req.setPlatform(1L);
		// 商品ID串，用,分割，从taobao.tbk.item.get接口获取num_iid字段，最大40个
		req.setNumIids(numIids);
		try {
			TbkItemInfoGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * taobao.tbk.item.recommend.get (淘宝客商品关联推荐查询) 例子:546521533831L
	 * 
	 * @param pid
	 *            商品编号
	 * @param count
	 *            返回数量(默认20，最大值40)
	 */
	public List<NTbkItem> queryItemsByKeyPidRelated(Long pid, Long count) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
		// 需返回的字段列表
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		// 商品Id
		req.setNumIid(pid);
		// 返回数量，默认20，最大值40
		req.setCount(count);
		// 链接形式：1：PC，2：无线，默认：１
		// req.setPlatform(1L);
		try {
			TbkItemRecommendGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
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
	public List<NTbkItem> queryItemsByKeyWord(String keyword, Long page, Long pagesize) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
		TbkItemGetRequest req = new TbkItemGetRequest();
		// 需返回的字段列表
		req.setFields(
				"num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		// 查询词
		req.setQ(keyword);
		// 后台类目ID，用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
		// req.setCat("16,18");
		// 所在地
		// req.setItemloc("杭州");
		// 排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate），
		// 累计推广量（tk_total_sales），总支出佣金（tk_total_commi）
		req.setSort("total_sales_des");
		// 是否商城商品，设置为true表示该商品是属于淘宝商城商品，设置为false或不设置表示不判断这个属性
		// req.setIsTmall(false);
		// 是否海外商品，设置为true表示该商品是属于海外商品，设置为false或不设置表示不判断这个属性
		// req.setIsOverseas(false);
		// 折扣价范围下限，单位：元
		// req.setStartPrice(10L);
		// 折扣价范围上限，单位：元
		// req.setEndPrice(10L);
		// 淘客佣金比率上限，如：1234表示12.34%
		// req.setStartTkRate(123L);
		// 淘客佣金比率下限，如：1234表示12.34%
		// req.setEndTkRate(123L);
		// 链接形式：1：PC，2：无线，默认：１
		// req.setPlatform(1L);
		// 第几页，默认：１
		req.setPageNo(page);
		// 页大小，默认20，1~100
		req.setPageSize(pagesize);
		try {
			TbkItemGetResponse rsp = client.execute(req);
			return rsp.getResults();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过商品编号获取商品信息 (商品基础信息、优惠券信息、淘口令)
	 * 
	 * @param itemId
	 *            商品编号
	 */
	@Override
	public ItemDetails queryItemInfoByItemId(String itemId) {
		List<NTbkItem> itemList = queryItemsByIds(itemId);
		if (itemList != null && itemList.size() > 0) {
			// 商品基础信息
			NTbkItem itemBase = itemList.get(0);
			// 商品图文信息
			ItemDescx itemDesc = queryItemById(itemId);
			// 获取商品评论
			// ItemRate itemRate = queryRateByCondition(itemId.toString(),
			// itemBase.getSellerId().toString(), "1");
			// itemRate.setPaginator(null);
			// itemRate.setRateDanceInfo(null);
			// RateList rateItem = itemRate.getRateList().get(0);
			// List<RateList> rateList = new ArrayList<>();
			// rateList.add(rateItem);
			// itemRate.setRateList(rateList);

			// 通过搜索列表匹配商品
			TbkCouponGetResponse.MapData couponInfo = null;
			TbkTpwdCreateResponse.MapData code = null;
			List<TbkCoupon> couponList = queryCouponByKeyWord(itemBase.getTitle(), 1L, 100L);
			if (couponList != null && couponList.size() > 0) {
				for (TbkCoupon tbkCoupon : couponList) {
					if (tbkCoupon.getTitle().equals(itemBase.getTitle())
							&& tbkCoupon.getSellerId().equals(itemBase.getSellerId())) {
						// 优惠券信息
						String me = com.igogogo.utils.StringUtils.subString(tbkCoupon.getCouponClickUrl(), "e=",
								"&traceId");
						couponInfo = queryCouponInfoByMe(me);
						// 淘口令
						code = createCode(tbkCoupon.getTitle(), tbkCoupon.getCouponClickUrl(), tbkCoupon.getPictUrl());
					}
				}
			}
			ItemDetails details = new ItemDetails();
			details.setItemBase(itemBase);
			details.setItemDesc(itemDesc);
			// details.setItemRate(itemRate);
			details.setCouponInfo(couponInfo);
			details.setCode(code);
			return details;
		}
		return null;
	}

}
