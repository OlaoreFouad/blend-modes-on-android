package dev.olaore.blendmodes

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

open class DrawPorterDuffView @JvmOverloads
    constructor(
        private val ctx: Context, private val attributeSet: AttributeSet? = null, private val defStyleAttr: Int = 0
    ): View(ctx, attributeSet, defStyleAttr) {

    private val paintSrc = Paint()
    private val paintDst = Paint()
    private var srcImage = R.drawable.pigeon
    private var dstImage = R.drawable.balloon

    private val fullRect by lazy { Rect(0, 0, width, height) }

    var mode: PorterDuff.Mode = PorterDuff.Mode.CLEAR
        set(value) {
            field = value
            paintSrc.xfermode = PorterDuffXfermode(mode)
            invalidate()
        }

    private val bitmapSource: Bitmap by lazy {
        BitmapFactory.decodeResource(resources, srcImage)
    }
    private val bitmapDestination: Bitmap by lazy {
        BitmapFactory.decodeResource(resources, dstImage)
    }

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        val typedArray = ctx.obtainStyledAttributes(attributeSet, R.styleable.DrawPorterDuffView)
        typedArray.let {
            srcImage = it.getResourceId(R.styleable.DrawPorterDuffView_srcImage, R.drawable.pigeon)
            dstImage = it.getResourceId(R.styleable.DrawPorterDuffView_dstImage, R.drawable.balloon)
        }
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas?.drawBitmap(bitmapDestination, null, fullRect, paintDst)
        canvas?.drawBitmap(bitmapSource, null, fullRect, paintSrc)
    }

}