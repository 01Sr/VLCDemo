package com.example.pingtaitest;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

import cn.ffcs.vlcdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activitydian extends Activity {
	Button Adianya;
	Button Adianliu;
	Button Agonglv;
	Button Bdianya;
	Button Bdianliu;
	Button Bgonglv;
	Button Cdianya;
	Button Cdianliu;
	Button Cgonglv;
	TextView textview1;
	TextView textview2;
	TextView textview3;
	String a = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dian);

		init();
		try {
			new Thread(new Runnable() {
				public void run() {
					try {
						a = WebServiceUtil.getHd("sss", "njuptcloud");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Adianya.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new Thread(new Runnable() {
					public void run() {
						try {
							final String b = WebServiceUtil.getMs(a, 252);
							runOnUiThread(new Runnable() {
								public void run() {
									if (b != null) {
										textview1.setText(b + " V");
									} else {
										textview1.setText(b + " Vv");									}
								}
							});
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});
		Adianliu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview1.setText(WebServiceUtil.getMs(a, 255) + " A");
					System.out.println(WebServiceUtil.getMs(a, 20));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Agonglv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview1.setText(WebServiceUtil.getMs(a, 258) + " KW");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Bdianya.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview2.setText(WebServiceUtil.getMs(a, 253) + " V");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Bdianliu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview2.setText(WebServiceUtil.getMs(a, 256) + " A");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Bgonglv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview2.setText(WebServiceUtil.getMs(a, 259) + " KW");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Cdianya.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview3.setText(WebServiceUtil.getMs(a, 254) + " V");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Cdianliu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview3.setText(WebServiceUtil.getMs(a, 257) + " A");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Cgonglv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				try {
					textview3.setText(WebServiceUtil.getMs(a, 260) + " KW");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

	}
	/*
	 * String getMs(String deviceID) throws Exception { String serviceUrl =
	 * "http://10.10.22.220:10222/AndroidService"; String methodName =
	 * "getCurrentValue"; SoapObject request = new
	 * SoapObject("http://nupt.cloud.android.com/", methodName);
	 * request.addProperty("deviceID", deviceID); SoapSerializationEnvelope
	 * envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	 * envelope.bodyOut = request; envelope.dotNet=true;
	 * envelope.encodingStyle="UTF-8"; AndroidHttpTransport ht = new
	 * AndroidHttpTransport(serviceUrl); ht.call(null, envelope); Object result
	 * = (Object) envelope.bodyIn; String s=result.toString(); String
	 * k=s.substring(43, 48); return k; }
	 */

	private void init() {
		Adianya = (Button) this.findViewById(R.id.Adianya);
		Adianliu = (Button) this.findViewById(R.id.Adianliu);
		Agonglv = (Button) this.findViewById(R.id.Agonglv);
		Bdianya = (Button) this.findViewById(R.id.Bdianya);
		Bdianliu = (Button) this.findViewById(R.id.Bdianliu);
		Bgonglv = (Button) this.findViewById(R.id.Bgonglv);
		Cdianya = (Button) this.findViewById(R.id.Cdianya);
		Cdianliu = (Button) this.findViewById(R.id.Cdianliu);
		Cgonglv = (Button) this.findViewById(R.id.Cgonglv);
		textview1 = (TextView) this.findViewById(R.id.textView1);
		textview2 = (TextView) this.findViewById(R.id.textView2);
		textview3 = (TextView) this.findViewById(R.id.textView3);
	}
}
