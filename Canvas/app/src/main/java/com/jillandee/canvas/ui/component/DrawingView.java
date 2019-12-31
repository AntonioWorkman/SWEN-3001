package com.jillandee.canvas.ui.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View
{
	private Path mDrawPath;
	private Paint mBackgroundPaint;
	private Paint mDrawPaint;
	private Canvas mDrawCanvas;
	private Bitmap mCanvasBitmap;

	private ArrayList<Path> mPaths = new ArrayList<>();
	private ArrayList<Paint> mPaints = new ArrayList<>();
	private ArrayList<Path> mUndonePaths = new ArrayList<>();
	private ArrayList<Paint> mUndonePaints = new ArrayList<>();

	// Set default values
	private int mBackgroundColor = 0xFFFFFFFF;
	private int mPaintColor = 0xFF660000;
	private int mStrokeWidth = 10;

	private int cx;
	private int cy;
	private int radius;



	public DrawingView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

	private void init()
	{
		mDrawPath = new Path();
		mBackgroundPaint = new Paint();
		initPaint();
	}

	private void initPaint()
	{
		mDrawPaint = new Paint();
		mDrawPaint.setColor(mPaintColor);
		mDrawPaint.setAntiAlias(true);
		mDrawPaint.setStrokeWidth(mStrokeWidth);
		mDrawPaint.setStyle(Paint.Style.STROKE);
		mDrawPaint.setStrokeJoin(Paint.Join.ROUND);
		mDrawPaint.setStrokeCap(Paint.Cap.ROUND);
	}

	private void drawBackground(Canvas canvas)
	{
		mBackgroundPaint.setColor(mBackgroundColor);
		mBackgroundPaint.setStyle(Paint.Style.FILL);
		canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), mBackgroundPaint);
	}

	private void drawPaths(Canvas canvas)
	{
		int i = 0;
		for (Path p : mPaths)
		{
			canvas.drawPath(p, mPaints.get(i));
			i++;
		}
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		drawBackground(canvas);
		drawPaths(canvas);

		canvas.drawPath(mDrawPath, mDrawPaint);

		canvas.drawLine(0, 25, 250, 250, mDrawPaint);

		canvas.drawCircle(400, 125, 100, mDrawPaint);

		canvas.drawRect(300, 800, 600, 400, mDrawPaint);

		Point a = new Point(100, 50);
		Point b = new Point(25, 175);
		Point c = new Point(175, 175);
		Path path = new Path();
		path.moveTo(a.x, a.y);
		path.lineTo(b.x, b.y);
		path.lineTo(c.x, c.y);
		path.lineTo(a.x, a.y);
		canvas.drawPath(path, mDrawPaint);




	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		super.onSizeChanged(w, h, oldw, oldh);

		mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

		mDrawCanvas = new Canvas(mCanvasBitmap);


	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		float touchX = event.getX();
		float touchY = event.getY();

		switch (event.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				mDrawPath.moveTo(touchX, touchY);
				//mDrawPath.addCircle(touchX, touchY, mStrokeWidth/10, Path.Direction.CW);
				break;
			case MotionEvent.ACTION_MOVE:
				mDrawPath.lineTo(touchX, touchY);
				break;
			case MotionEvent.ACTION_UP:
				mDrawPath.lineTo(touchX, touchY);
				mPaths.add(mDrawPath);
				mPaints.add(mDrawPaint);
				mDrawPath = new Path();
				initPaint();
				break;
			default:
				return false;
		}

		invalidate();
		return true;
	}

	public void clearCanvas()
	{
		mPaths.clear();
		mPaints.clear();
		mUndonePaths.clear();
		mUndonePaints.clear();
		mDrawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
		invalidate();
	}

	public void setPaintColor(int color)
	{
		mPaintColor = color;
		mDrawPaint.setColor(mPaintColor);
	}

	public void setPaintStrokeWidth(int strokeWidth)
	{
		mStrokeWidth = strokeWidth;
		mDrawPaint.setStrokeWidth(mStrokeWidth);
	}

	public void setBackgroundColor(int color)
	{
		mBackgroundColor = color;
		mBackgroundPaint.setColor(mBackgroundColor);
		invalidate();
	}

	public Bitmap getBitmap()
	{
		drawBackground(mDrawCanvas);
		drawPaths(mDrawCanvas);
		return mCanvasBitmap;
	}

	public void undo()
	{
		if (mPaths.size() > 0)
		{
			mUndonePaths.add(mPaths.remove(mPaths.size() - 1));
			mUndonePaints.add(mPaints.remove(mPaints.size() - 1));
			invalidate();
		}
	}

	public void redo()
	{
		if (mUndonePaths.size() > 0)
		{
			mPaths.add(mUndonePaths.remove(mUndonePaths.size() - 1));
			mPaints.add(mUndonePaints.remove(mUndonePaints.size() - 1));
			invalidate();
		}
	}

	/*public void drawRectangle(int x, int y) {
		mDrawPaint.setColor(Color.RED);
		Rect rectangle = new Rect((int) (x - ((0.8) * RADIUS)), (int) (y - ((0.6) * RADIUS)), (int) (x + ((0.8) * RADIUS)), (int) (y + ((0.6 * RADIUS))));
		mDrawCanvas.drawRect(rectangle, mDrawPaint);
	}

	public void drawCircle (float cx, float cy, float radius, Paint paint){
		mDrawCanvas.drawCircle(cx, cy, RADIUS, mDrawPaint);
	}

	double squareSideHalf = 1 / Math.sqrt(2);


	public void drawSquare(int x, int y) {
		mDrawPaint.setColor(Color.RED);
		Rect rectangle = new Rect((int) (x - (squareSideHalf * RADIUS)), (int) (y - (squareSideHalf * RADIUS)), (int) (x + (squareSideHalf * RADIUS)), (int) (y + ((squareSideHalf * RADIUS))));
		mDrawCanvas.drawRect(rectangle, mDrawPaint);
	}*/

	public void drawCircle() {


		/*int minX = radius * 2;
		int maxX = getWidth() - (radius * 2);

		int minY = radius * 2;
		int maxY = getHeight() - (radius * 2);

		//Generate random numbers for x and y locations of the circle on screen
		Random random = new Random();
		cx = random.nextInt(maxX - minX + 1) + minX;
		cy = random.nextInt(maxY - minY + 1) + minY;

		Random x = new Random();
		int cx = x.nextInt(250 - 100) + 100;

		Random y = new Random();
		int cy = y.nextInt(250 - 100) + 100;



		//Refreshes the view by calling onDraw function
		invalidate();*/
	}
}
