package com.laylamac.travelmania

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.util.Log
import com.laylamac.travelmania.model.OnboardingMdl
import java.util.*

class Onboarding : AppCompatActivity() {

    private val tagClass = this::class.java.simpleName

    private lateinit var viewPager: ViewPager
    private lateinit var mAdapter: ViewPagerOnboarding
    private var currentPage = 0
    private lateinit var indicatorOnboarding: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val data = setBackgroundOnboarding()

        viewPager = findViewById(R.id.onboarding_viewpager)
        indicatorOnboarding = findViewById(R.id.onboarding_indicator)
        indicatorOnboarding.setupWithViewPager(viewPager, true)

        mAdapter = ViewPagerOnboarding(this, data)
        Log.d(tagClass, data.size.toString())
        Log.d(tagClass, data.toString())


        viewPager.adapter = mAdapter


        val mHandler = Handler()
        val swipeTimer = Timer()

        val run = Runnable {
            currentPage++
            if (currentPage >= mAdapter.count) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage, true)

        }

        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                mHandler.post(run)
            }
        }, 3000, 3000)

        viewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                currentPage = position
            }
        })
    }

    private fun setBackgroundOnboarding(): List<OnboardingMdl> {
        val mList: MutableList<OnboardingMdl> = mutableListOf()
        val onboarding_satu = resources.getDrawable(R.drawable.onboard)
        val onboarding_dua = resources.getDrawable(R.drawable.onboard)
        val onboarding_tiga = resources.getDrawable(R.drawable.onboard)

        mList.add(OnboardingMdl(onboarding_satu, getString(R.string.title_onboarding_one)))
        mList.add(OnboardingMdl(onboarding_dua, getString(R.string.title_onboarding_two)))
        mList.add(OnboardingMdl(onboarding_tiga, getString(R.string.title_onboarding_three)))

        return mList
    }

}
