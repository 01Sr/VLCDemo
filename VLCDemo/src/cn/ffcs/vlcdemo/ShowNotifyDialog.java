package cn.ffcs.vlcdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/**
 * 消息提醒弹出框
 * @author linruijuan
 *
 */
public class ShowNotifyDialog extends Dialog {
	private Context mContext;
	private TextView title,message_tv,sure_tv,cancle_tv,cancle_tv2;
	private String title_name,message;
	
	private String sure_txt = "";
	private String cancle_txt = "";
	private String cancle_txt2 = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_notify_dialog);
		findViews();
		setViews();
		setListeners();
	}
	
	public ShowNotifyDialog(Context context, int theme,String title,String message) {
		super(context, theme);
		mContext = context;
		this.title_name = title;
		this.message = message;
	}
	private void findViews(){
		title = (TextView) findViewById(R.id.title);
		message_tv = (TextView) findViewById(R.id.input_pwd_tv);
		sure_tv = (TextView) findViewById(R.id.sure_tv);
		cancle_tv = (TextView) findViewById(R.id.cancle_tv);
		cancle_tv2 = (TextView) findViewById(R.id.cancle_tv2);
		if(getSure_txt().length()>0){
			sure_tv.setVisibility(View.VISIBLE);
			sure_tv.setText(getSure_txt());
		}
		if(getCancle_txt().length()>0){
			cancle_tv.setVisibility(View.VISIBLE);
			cancle_tv.setText(getCancle_txt());
		}
		if(getCancle_txt2().length()>0){
			cancle_tv2.setVisibility(View.VISIBLE);
			cancle_tv2.setText(getCancle_txt2());
		}
	}
	
	private void setViews(){
		if(title_name.equals("")){
			title.setVisibility(View.GONE);
		}
		title.setText(title_name);
		message_tv.setText(message);
		
	}
	
	private void setListeners(){
		sure_tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onSureClick.onClick(v);
			}
		});
		
		cancle_tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onCancleClick.onClick(v);
			}
		});
		
		cancle_tv2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onCancleClick2.onClick(v);
			}
		});
	}
	
	OnSureClick onSureClick; //“确定”点击
	
	OnCancleClick onCancleClick;//“取消”点击
	
	OnCancleClick2 onCancleClick2;//“取消”点击

	public void setOnSureClick(String title,OnSureClick onSureClick) {
		setSure_txt(title);
		this.onSureClick = onSureClick;
	}

	public void setOnCancleClick(String title,OnCancleClick onCancleClick) {
		setCancle_txt(title);
		this.onCancleClick = onCancleClick;
	}
	
	public void setOnCancleClick2(String title,OnCancleClick2 onCancleClick2) {
		setCancle_txt2(title);
		this.onCancleClick2 = onCancleClick2;
	}
	
	/**
	 * “确定”的点击事件的接口
	 * @author linruijuan
	 *
	 */
	public interface OnSureClick{
		void onClick(View view);
	}
	/**
	 * “取消”的点击事件的接口
	 * @author linruijuan
	 *
	 */
	public interface OnCancleClick{
		void onClick(View view);
	}
	
	/**
	 * 第三个按钮的点击事件接口
	 * @author linruijuan
	 *
	 */
	public interface OnCancleClick2{
		void onClick(View view);
	}
	
	public String getSure_txt() {
		return sure_txt;
	}

	public void setSure_txt(String sure_txt) {
		this.sure_txt = sure_txt;
	}

	public String getCancle_txt() {
		return cancle_txt;
	}

	public void setCancle_txt(String cancle_txt) {
		this.cancle_txt = cancle_txt;
	}
	
	public String getCancle_txt2() {
		return cancle_txt2;
	}

	public void setCancle_txt2(String cancle_txt2) {
		this.cancle_txt2 = cancle_txt2;
	}
	
	
}