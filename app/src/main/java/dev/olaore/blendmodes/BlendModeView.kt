package dev.olaore.blendmodes

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

/**
 * TODO: document your custom view class.
 */
class BlendModeView @JvmOverloads
    constructor(private val ctx: Context, private val attributeSet: AttributeSet? = null, private val defStyleAttr: Int = 0)
    : View(ctx, attributeSet, defStyleAttr) {

//    dimensions
    private var shapeHeight = 0f
    private val DST_IN_PORTER_DUFF_MODE = PorterDuffXfermode(PorterDuff.Mode.DST_IN)

//    paint
    private val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG)

//    colors
    private val colorRect = Color.RED
    private val colorCircle = Color.BLUE

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawCircle(canvas)
        circlePaint.xfermode = DST_IN_PORTER_DUFF_MODE
        drawRect(canvas)
    }

    private fun drawRect(canvas: Canvas?) {
        circlePaint.color = colorRect
        canvas?.let {
            it.drawRect(0f, (0.25 * height).toFloat(), width.toFloat(), (0.75 * height).toFloat(), circlePaint)
        }
    }

    private fun drawCircle(canvas: Canvas?) {
        shapeHeight = toDP(height.toFloat())
        circlePaint.color = colorCircle
        canvas?.let {
            it.drawCircle(
                (0.5 * width).toFloat(), (0.5 * height).toFloat(), width.div(2).toFloat(), circlePaint
            )
        }
    }

    private fun toDP(value: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics
        )
    }

}