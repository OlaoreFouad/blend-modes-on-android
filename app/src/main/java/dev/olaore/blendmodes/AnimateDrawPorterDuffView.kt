package dev.olaore.blendmodes

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class AnimateDrawPorterDuffView @JvmOverloads
    constructor(private val ctx: Context, private val attributeSet: AttributeSet? = null, private val defStyleAttr: Int = 0)
    : DrawPorterDuffView(ctx, attributeSet, defStyleAttr) {

    private val porterDuffModes by lazy {
        listOf(
            PorterDuff.Mode.SRC_OVER,
            PorterDuff.Mode.DARKEN,
            PorterDuff.Mode.OVERLAY,
            PorterDuff.Mode.ADD,
            PorterDuff.Mode.SCREEN,
            PorterDuff.Mode.LIGHTEN,
            PorterDuff.Mode.DST_OVER
        )
    }

    private var control = 1
    private var compositeDisposable = CompositeDisposable()

    private fun stopAnimate() {
        compositeDisposable.clear()
    }

    private fun startAnimate() {
        compositeDisposable.add(
            Observable.interval(0, 1, TimeUnit.SECONDS)
                .flatMap {
                    return@flatMap Observable.interval(0, 100, TimeUnit.SECONDS)
                        .take(porterDuffModes.size.toLong())
                }
                .map { it.toInt() }
                .doAfterNext { if (control == (porterDuffModes.size - 1)) control *= -1 }
                .map { if (control == 1) it else porterDuffModes.size - 1 - it }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { mode = porterDuffModes[it] }
        )
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        stopAnimate()
        startAnimate()
    }

    fun stop() = stopAnimate()

}