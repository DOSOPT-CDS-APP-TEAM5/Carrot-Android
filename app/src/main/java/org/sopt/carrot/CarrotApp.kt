package org.sopt.carrot

import android.app.Application
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import org.sopt.carrot.data.api.RetrofitServicePool
import org.sopt.carrot.data.datasource.remote.NeighborhoodLifeRemoteDatasource
import org.sopt.carrot.data.datasource.remote.ProfileRemoteDatasource
import org.sopt.carrot.data.repo.NeighborhoodLifeRepository
import org.sopt.carrot.data.repo.ProfileRepository
import timber.log.Timber

class CarrotApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    companion object {
        private lateinit var neighborhoodLifeRepository: NeighborhoodLifeRepository
        private lateinit var profileRepository: ProfileRepository

        @Synchronized
        fun getNeighborhoodLifeRepositoryInstance(): NeighborhoodLifeRepository {
            if (!::neighborhoodLifeRepository.isInitialized) {
                try {
                    neighborhoodLifeRepository = NeighborhoodLifeRepository(
                        NeighborhoodLifeRemoteDatasource(RetrofitServicePool.carrotService)
                    )
                } catch (e: ExceptionInInitializerError) {
                    Log.e("로그", "${e.message}")
                }
            }
            return neighborhoodLifeRepository
        }
        @Synchronized
        fun getProfileRepositoryInstance(): ProfileRepository {
            if (!::profileRepository.isInitialized) {
                try {
                    profileRepository = ProfileRepository(
                        ProfileRemoteDatasource(RetrofitServicePool.carrotService)
                    )
                } catch (e: ExceptionInInitializerError) {
                    Log.e("로그", "${e.message}")
                }
            }
            return profileRepository
        }
    }
}