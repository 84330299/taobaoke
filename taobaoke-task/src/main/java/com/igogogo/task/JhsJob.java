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

import com.igogogo.domain.Ig_Jhs;
import com.igogogo.service.Ig_JhsService;
import com.igogogo.service.TaobaokeService;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.response.JuItemsSearchResponse.Items;
import com.taobao.api.response.TbkSpreadGetResponse.TbkSpread;
import com.taobao.api.response.TbkTpwdCreateResponse.MapData;

public class JhsJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(JhsJob.class);

	@Autowired
	private Ig_JhsService ig_JhsService;

	@Autowired
	private TaobaokeService taobaokeService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String[] words = { "连衣裙", "情趣内衣", "儿童玩具" };
		for (String w : words) {
			try {
				List<Ig_Jhs> jhsList = new ArrayList<Ig_Jhs>();
				List<Items> itemList = taobaokeService.jhs(w, 1L, 100L);
				for (Items item : itemList) {
					Ig_Jhs checkJhs = ig_JhsService.checkById(item.getItemId());
					if (checkJhs == null) {
						Ig_Jhs jhs = new Ig_Jhs();
						jhs.setItemId(item.getItemId());
						jhs.setPcUrl(item.getPcUrl());
						jhs.setPicUrlForWL(item.getPicUrlForWL());
						List<NTbkItem> itemInfoList = taobaokeService.queryItemsByIds(item.getItemId().toString());
						if (itemInfoList != null && itemInfoList.size() > 0) {
							NTbkItem currentItem = itemInfoList.get(0);
							jhs.setSmallImages(
									currentItem.getSmallImages().toString().replace("[", "").replace("]", ""));
						}
						jhs.setTitle(item.getTitle());
						jhs.setCategoryName(item.getCategoryName());
						jhs.setOrigPrice(Double.parseDouble(item.getOrigPrice()));
						jhs.setActPrice(Double.parseDouble(item.getActPrice()));
						jhs.setOnlineStartTime(item.getShowStartTime());
						jhs.setOnlineEndTime(item.getOnlineEndTime());
						// 生成短链接
						List<TbkSpread> shortLinkList = taobaokeService.shortLink(item.getPcUrl());
						jhs.setShortUrl(shortLinkList.get(0).getContent());
						// 淘口令
						MapData mapData = taobaokeService.createCode(item.getTitle(), item.getPcUrl(),
								item.getPicUrlForPC());
						jhs.setTpwd(mapData.getModel());
						jhsList.add(jhs);
					}
				}
				ig_JhsService.addmoreTemp(jhsList);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				logger.info("JhsJob: 总共 " + jhsList.size() + " 条记录被添加");
				logger.info("time:" + sdf.format(new Date()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
