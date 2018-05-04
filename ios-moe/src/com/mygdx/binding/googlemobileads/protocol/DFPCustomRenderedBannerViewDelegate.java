package com.mygdx.binding.googlemobileads.protocol;


import com.mygdx.binding.googlemobileads.DFPBannerView;
import com.mygdx.binding.googlemobileads.DFPCustomRenderedAd;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Library;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.ann.ObjCProtocolName;
import org.moe.natj.objc.ann.Selector;

@Generated
@Library("GoogleMobileAds")
@Runtime(ObjCRuntime.class)
@ObjCProtocolName("DFPCustomRenderedBannerViewDelegate")
public interface DFPCustomRenderedBannerViewDelegate {
	@Generated
	@Selector("bannerView:didReceiveCustomRenderedAd:")
	void bannerViewDidReceiveCustomRenderedAd(DFPBannerView bannerView,
			DFPCustomRenderedAd customRenderedAd);
}