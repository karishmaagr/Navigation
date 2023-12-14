package com.example.featurea

import com.example.core.FeatureScreenARouteContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FeatureAModule {

    @Singleton
    @Provides
    fun providesFeatureARouteContract(): FeatureScreenARouteContract = FeatureARouteContaractImpl()
}