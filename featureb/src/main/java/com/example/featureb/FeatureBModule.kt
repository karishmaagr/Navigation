package com.example.featureb

import com.example.core.FeatureScreenBRouteContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FeatureBModule {

    @Singleton
    @Provides
    fun providesFeatureBRouteContract(): FeatureScreenBRouteContract = FeatureBRouteContractImpl()
}