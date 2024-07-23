//package com.example.yomicepa.di
//
//import com.example.yomicepa.network.PharmacyApiService
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ActivityComponent
//import dagger.hilt.components.SingletonComponent
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//@Module
//@InstallIn(ActivityComponent::class)
//object AppModule {
//    @Provides
//    fun getPharmacyApiServiceInstance(): PharmacyApiService {
//        return Retrofit.Builder().baseUrl("https://portal-test.rxmaxreturns.com/rxmax")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(PharmacyApiService::class.java)
//    }
//}