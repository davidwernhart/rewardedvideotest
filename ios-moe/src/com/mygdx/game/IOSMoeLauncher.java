package com.mygdx.game;

import com.badlogic.gdx.backends.iosmoe.IOSApplication;
import com.badlogic.gdx.backends.iosmoe.IOSApplicationConfiguration;
import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;

import com.mygdx.binding.googlemobileads.GADAdReward;
import com.mygdx.binding.googlemobileads.GADMobileAds;
import com.mygdx.binding.googlemobileads.GADRequest;
import com.mygdx.binding.googlemobileads.GADRewardBasedVideoAd;
import com.mygdx.binding.googlemobileads.protocol.GADRewardBasedVideoAdDelegate;
import com.mygdx.game.MyGdxGame;

import apple.foundation.NSArray;
import apple.foundation.NSDictionary;
import apple.foundation.NSError;
import apple.foundation.NSMutableArray;
import apple.uikit.UIApplication;
import apple.uikit.c.UIKit;

public class IOSMoeLauncher extends IOSApplication.Delegate implements GADRewardBasedVideoAdDelegate{


    private GADRewardBasedVideoAd rewardBasedVideoAd;
    private IOSApplication application;

    protected IOSMoeLauncher(Pointer peer) {
        super(peer);
    }

    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        config.useAccelerometer = false;
        application = new IOSApplication(new MyGdxGame(), config);
        return application;
    }

    @Override
    public void applicationDidBecomeActive(UIApplication application) {
        super.applicationDidBecomeActive(application);

        GADMobileAds.configureWithApplicationID("ca-app-pub-3940256099942544~1458002511");
        initRewardedVideo();

    }


    public static void main(String[] argv) {
        UIKit.UIApplicationMain(0, null, null, IOSMoeLauncher.class.getName());
    }

    public void initRewardedVideo(){
        rewardBasedVideoAd = GADRewardBasedVideoAd.sharedInstance();

        rewardBasedVideoAd.setDelegate(this);

        GADRequest request = GADRequest.request();

        final NSMutableArray<String> testDevices = (NSMutableArray<String>) NSMutableArray.alloc().init();
        testDevices.add("3c68c4c3c39e6c9077cc158d81a32dea");
        //request.setTestDevices(testDevices);

        rewardBasedVideoAd.loadRequestWithAdUnitID(request,"ca-app-pub-3940256099942544/1712485313");
    }

    @Override
    @Selector("rewardBasedVideoAd:didFailToLoadWithError:")
    public void rewardBasedVideoAdDidFailToLoadWithError(GADRewardBasedVideoAd rewardBasedVideoAd, NSError error) {
        System.out.println("rewardBasedVideoAdDidFailToLoadWithError");
    }

    @Override
    @Selector("rewardBasedVideoAd:didRewardUserWithReward:")
    public void rewardBasedVideoAdDidRewardUserWithReward(GADRewardBasedVideoAd rewardBasedVideoAd, GADAdReward reward) {
        System.out.println("rewardBasedVideoAdDidRewardUserWithReward");
    }

    @Override
    @Selector("rewardBasedVideoAdDidClose:")
    public void rewardBasedVideoAdDidClose(GADRewardBasedVideoAd rewardBasedVideoAd) {
        System.out.println("rewardBasedVideoAdDidClose");
    }

    @Override
    @Selector("rewardBasedVideoAdDidOpen:")
    public void rewardBasedVideoAdDidOpen(GADRewardBasedVideoAd rewardBasedVideoAd) {
        System.out.println("rewardBasedVideoAdDidOpen");
    }

    @Override
    @Selector("rewardBasedVideoAdDidReceiveAd:")
    public void rewardBasedVideoAdDidReceiveAd(GADRewardBasedVideoAd rewardBasedVideoAd) {
        System.out.println("rewardBasedVideoAdDidReceiveAd");
        rewardBasedVideoAd.presentFromRootViewController(application.getUIViewController());
    }

    @Override
    @Selector("rewardBasedVideoAdDidStartPlaying:")
    public void rewardBasedVideoAdDidStartPlaying(GADRewardBasedVideoAd rewardBasedVideoAd) {
        System.out.println("rewardBasedVideoAdDidStartPlaying");
    }

    @Override
    @Selector("rewardBasedVideoAdWillLeaveApplication:")
    public void rewardBasedVideoAdWillLeaveApplication(GADRewardBasedVideoAd rewardBasedVideoAd) {
        System.out.println("rewardBasedVideoAdWillLeaveApplication");
    }
}
