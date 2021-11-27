package kr.ac.kumoh.s20191255.mygraphicsviewmodel

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class GraphicView : View {

    private val p = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL_AND_STROKE
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 10F
    }

    private val activity = context as MainActivity
    private var bmp = BitmapFactory.decodeResource(resources, androidx.core.R.drawable.notify_panel_notification_icon_bg)

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        bmp = Bitmap.createScaledBitmap(bmp, 100, 100, false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        canvas.drawLine(10F, 10F, 100F, 100F, p)
        val list = activity.getPositionList()
//        var oldP: PointF? = null
//
//        for (i in 0 until list.size) {
//            oldP?.run {
//                canvas.drawLine(this.x, this.y, list[i].x, list[i].y, p)
//            }
//            oldP = list[i]
//
//        }

        for (i in 0 until list.size) {
            canvas.drawBitmap(bmp, list[i].x, list[i].y, p)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                activity.addPosition(event.x, event.y)
                invalidate()
            }
        }
        return true
    }
}