package pl.pmerdala.kursandroid.feature.commons.ui

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import dagger.android.AndroidInjection

abstract class BaseActivity() : AppCompatActivity() {

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        ButterKnife.bind(this)
    }

    fun <T> startActivity(
        activityClass: Class<T>,
        flags: List<Int>? = null,
        parcelable: Pair<String,Parcelable>? = null
    ) where T : BaseActivity {
        val intent = Intent(this, activityClass)
        flags?.forEach { intent.addFlags(it) }
        parcelable?.let{intent.putExtra(it.first,it.second)}
        startActivity(intent)
    }
}