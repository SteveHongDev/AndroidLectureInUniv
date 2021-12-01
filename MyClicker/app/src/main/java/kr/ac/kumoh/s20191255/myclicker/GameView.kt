package kr.ac.kumoh.s20191255.myclicker

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class GameView: View {
    private val activity = context as MainActivity
    private var bmp = BitmapFactory.decodeResource(resources, androidx.core.R.drawable.notify_panel_notification_icon_bg)
    private val p = Paint()

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        bmp = Bitmap.createScaledBitmap(bmp, 100, 100, false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val r = Random(activity.seed)
        for (i in 0 until activity.level) {
            val x = r.nextInt(width).toFloat()
            val y = r.nextInt(height).toFloat()
            canvas.drawBitmap(bmp, x, y, p)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                activity.addMoney()
                invalidate()
            }
        }
        return true
    }
}