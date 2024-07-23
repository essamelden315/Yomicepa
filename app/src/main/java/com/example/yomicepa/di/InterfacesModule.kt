//package com.example.yomicepa.di
//
//import com.example.yomicepa.network.PharmacyClient
//import com.example.yomicepa.network.RemoteDataSource
//import com.example.yomicepa.repository.Repository
//import com.example.yomicepa.repository.RepositoryInterface
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class InterfacesModule {
//    @Binds
//    @Singleton
//    abstract fun remoteDataSourceInjection(
//        remoteSourceImpl: PharmacyClient
//    ): RemoteDataSource
//    @Binds
//    @Singleton
//    abstract fun repoInjection(
//        repoImpl: Repository
//    ): RepositoryInterface
//}