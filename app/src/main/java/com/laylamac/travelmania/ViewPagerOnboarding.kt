package com.laylamac.travelmania

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.laylamac.travelmania.model.OnboardingMdl

class ViewPagerOnboarding(
    private val context: Context,
    private val data: List<OnboardingMdl>
) : PagerAdapter() {

    private val tagClass = this::class.java.simpleName

    private var layoutInflater: LayoutInflater? = null
    private lateinit var getStarted: Button
    private lateinit var titleOnboarding: TextView
    private lateinit var imageOnboarding: ImageView
    //  private var color = intArrayOf(R.color.colorAccent, R.color.colorBackground, R.color.colorPrimary)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.adapter_onboarding, null)
        imageOnboarding = view.findViewById(R.id.onboarding_image)
        imageOnboarding.setImageDrawable(data[position].background)
        titleOnboarding = view.findViewById(R.id.onboarding_title)
        titleOnboarding.text = data[position].title

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }


}