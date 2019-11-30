//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.duoihinhbatchu;
public interface RewardedVideoAdListener {
    void onRewardedVideoAdLoaded();

    void onRewardedVideoAdOpened();

    void onRewardedVideoStarted();

    void onRewardedVideoAdClosed();

    void onRewarded(RewardItem var1);

    void onRewardedVideoAdLeftApplication();

    void onRewardedVideoAdFailedToLoad(int var1);

    void onRewardedVideoCompleted();
}
