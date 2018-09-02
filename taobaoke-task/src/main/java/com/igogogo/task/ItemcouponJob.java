package com.igogogo.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.igogogo.domain.Ig_Itemcoupon;
import com.igogogo.service.Ig_ItemcouponService;
import com.igogogo.service.TaobaokeService;
import com.igogogo.utils.StringUtils;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;
import com.taobao.api.response.TbkTpwdCreateResponse.MapData;

public class ItemcouponJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(ItemcouponJob.class);

	@Autowired
	private Ig_ItemcouponService ig_ItemcouponService;

	@Autowired
	private TaobaokeService taobaokeService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String keywords = context.getJobDetail().getJobDataMap().get("keywords").toString();
		System.out.println("keywords:" + keywords);
		String[] words = keywords.split(",");
		for (String w : words) {
			try {
				List<Ig_Itemcoupon> itemcouponList = new ArrayList<Ig_Itemcoupon>();
				List<TbkCoupon> tbkCouponList = taobaokeService.queryCouponByKeyWord(w, 1L, 100L);
				// Integer flagCount = 0;
				for (TbkCoupon tbkCoupon : tbkCouponList) {
					Ig_Itemcoupon checkItem = ig_ItemcouponService.checkById(tbkCoupon.getNumIid());
					if (checkItem == null) {
						Ig_Itemcoupon item = new Ig_Itemcoupon();
						item.setNumIid(tbkCoupon.getNumIid());
						item.setTitle(tbkCoupon.getTitle());
						item.setItemUrl(tbkCoupon.getItemUrl());
						item.setCouponClickUrl(tbkCoupon.getCouponClickUrl());
						item.setCouponInfo(tbkCoupon.getCouponInfo());
						item.setPictUrl(tbkCoupon.getPictUrl());
						List<String> smallImages = tbkCoupon.getSmallImages();
						if (smallImages != null && smallImages.size() > 0) {
							item.setSmallImages(
									tbkCoupon.getSmallImages().toString().replace("[", "").replace("]", ""));
						}
						item.setItemDescription(tbkCoupon.getItemDescription());
						item.setSellerId(tbkCoupon.getSellerId());

						// 优惠券信息
						com.taobao.api.response.TbkCouponGetResponse.MapData queryCouponInfoByMe = taobaokeService
								.queryCouponInfoByMe(StringUtils.meargs(tbkCoupon.getCouponClickUrl()));
						if (queryCouponInfoByMe != null) {
							item.setCouponAmount(queryCouponInfoByMe.getCouponAmount());
							item.setCouponStartTime(queryCouponInfoByMe.getCouponStartTime().replace("-", "."));
							item.setCouponEndTime(queryCouponInfoByMe.getCouponEndTime().replace("-", "."));
						} else {
							item.setCouponAmount("0");
							item.setCouponStartTime(tbkCoupon.getCouponStartTime());
							item.setCouponEndTime(tbkCoupon.getCouponEndTime());
						}
						// 店铺标题
						item.setShopTitle(tbkCoupon.getShopTitle());
						// 30天销量
						item.setVolume(tbkCoupon.getVolume());
						// 原价
						List<NTbkItem> queryItemsByIds = taobaokeService.queryItemsByIds(tbkCoupon.getNumIid() + "");
						if (queryItemsByIds != null && queryItemsByIds.size() > 0) {
							item.setReservePrice(Double.parseDouble(queryItemsByIds.get(0).getReservePrice()));
						}
						item.setZkFinalPrice(Double.parseDouble(tbkCoupon.getZkFinalPrice()));
						item.setTpwd(null);
						item.setShortUrl(null);
						// 生成短链接
						List<TbkSpread> shortLinkList = taobaokeService.shortLink(tbkCoupon.getCouponClickUrl());
						item.setShortUrl(shortLinkList.get(0).getContent());
						// 淘口令
						MapData mapData = taobaokeService.createCode(tbkCoupon.getTitle(),
								tbkCoupon.getCouponClickUrl(), tbkCoupon.getPictUrl());
						item.setTpwd(mapData.getModel());
						itemcouponList.add(item);

						// ig_ItemcouponService.add(item);
						// flagCount++;
					}
				}
				ig_ItemcouponService.addmoreTemp(itemcouponList);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				logger.info("ItemcouponJob: 总共 " + itemcouponList.size() + " 条记录被添加");
				logger.info("time:" + sdf.format(new Date()));
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("出现异常");
			}
		}

	}

}
