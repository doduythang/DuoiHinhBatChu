package com.example.duoihinhbatchu.View;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;

public interface RewardedVideoAd {
    void loadAd(String var1, AdRequest var2);

    void loadAd(String var1, PublisherAdRequest var2);

    boolean isLoaded();

    void show();

    void setRewardedVideoAdListener(RewardedVideoAdListener var1);

    void setAdMetadataListener(AdMetadataListener var1);

    Bundle getAdMetadata();

    void setUserId(String var1);

    RewardedVideoAdListener getRewardedVideoAdListener();

    String getUserId();

    /** @deprecated */
    @Deprecated
    void pause();

    void pause(Context var1);

    /** @deprecated */
    @Deprecated
    void resume();

    void resume(Context var1);

    /** @deprecated */
    @Deprecated
    void destroy();

    void destroy(Context var1);

    String getMediationAdapterClassName();

    void setImmersiveMode(boolean var1);

    void setCustomData(String var1);

    String getCustomData();
}
