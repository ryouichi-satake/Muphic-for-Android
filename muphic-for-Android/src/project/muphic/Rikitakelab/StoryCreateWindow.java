package project.muphic.Rikitakelab;


import android.content.res.Resources;
import android.graphics.*;
import android.content.Context;
import android.view.View;
import android.view.MotionEvent;

public class StoryCreateWindow extends View implements Creator {

	private Resources r;
	private int touchX;
	private int touchY;
	private int touchAction=-999;

	private Button backtitlebutton;
	private Bitmap backtitlebbutton;
	private Bitmap backtitleabutton;

	private Button exchbutton;
	private Bitmap exchbbutton;
	private Bitmap exchabutton;

	private Button editbutton;
	private Bitmap editbbutton;
	private Bitmap editabutton;

	private Muphic activity = (Muphic)getContext();
	private static StoryCreateWindow SCW;


	public static void CreateSCW(Muphic activity){
		SCW = new StoryCreateWindow(activity);
	}

	public static StoryCreateWindow getInstance(){
		return SCW;
	}

	public StoryCreateWindow(Context context){
		super(context);
		r=getResources();
		backtitlebbutton=BitmapFactory.decodeResource(r, R.drawable.backtotitle);
		backtitleabutton=BitmapFactory.decodeResource(r, R.drawable.backtotitle_t);
		exchbbutton=BitmapFactory.decodeResource(r, R.drawable.music);
		exchabutton=BitmapFactory.decodeResource(r, R.drawable.music_t);
		editbbutton=BitmapFactory.decodeResource(r, R.drawable.edit);
		editabutton=BitmapFactory.decodeResource(r, R.drawable.edit_t);
		setBackgroundColor(Color.BLACK);
	}

	public void onDraw(Canvas canvas){
		Paint paint = new Paint();
		backtitlebutton=new Button(getWidth()-95,40,backtitlebbutton,backtitleabutton);
		exchbutton=new Button(getWidth()-95,240,exchbbutton,exchabutton);
		editbutton=new Button(getWidth()-95,335,editbbutton,editabutton);
		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			exchbutton.changeflag(touchX, touchY,false);
			backtitlebutton.changeflag(touchX, touchY,false);
			editbutton.changeflag(touchX, touchY, false);
		}

		if(touchAction==MotionEvent.ACTION_UP){
			exchbutton.changeflag(touchX, touchY,true);
			backtitlebutton.changeflag(touchX, touchY, true);
			editbutton.changeflag(touchX, touchY, true);
		}
		exchbutton.display(canvas, paint);
		backtitlebutton.display(canvas, paint);
		editbutton.display(canvas, paint);
	}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();

		if(touchAction==MotionEvent.ACTION_UP){
			if(exchbutton.changeflag(touchX, touchY,true)){
				exchange();
			}
			if(backtitlebutton.changeflag(touchX, touchY, true)){
				titleBack();
			}
			if(editbutton.changeflag(touchX, touchY, true)){
				edit();
			}
		}

		return true;
	}

	public void edit() {
		activity.setView(Muphic.viewBackGroundSelect);
	}

	public void play() {

	}

	public void titleBack() {
		activity.setView(Muphic.viewTitle);

	}

	public void save() {

	}

	public void exchange() {
		activity.setView(Muphic.viewMusicCreateWindow);
	}

	public void readFile() {

	}

	public void help() {

	}

}
