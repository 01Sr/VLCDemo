package com.example.pingtaitest;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.pingtaitest.utils.Device;
import com.example.pingtaitest.utils.JsonObjectUtil;
import com.example.pingtaitest.utils.MD5Util;
import com.example.pingtaitest.utils.MyDeviceListViewAdapter;
import com.example.pingtaitest.utils.SyncHttpRequestService;
import com.example.pingtaitest.utils.TimeUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.ffcs.vlcdemo.MainActivity;
import cn.ffcs.vlcdemo.R;

public class ActivityShowDevice extends Activity {
	private ListView lv;
	private MyDeviceListViewAdapter adapter;
	private List<Device> lists;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_devlist);
		lv = (ListView) findViewById(R.id.lv_show_devlist);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				final Device device = lists.get(position);// �Լ�¼���в������б�Ի���
				final String devID = device.getDevid();
				final String devKey = device.getDevKey();
				System.out.println(devKey);
				AlertDialog.Builder builder = new AlertDialog.Builder(ActivityShowDevice.this);
				builder.setTitle("ѡ���б�");
				builder.setItems(R.array.control_device, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						// ��Ƶ����
						case 0:
							Intent intent3 = new Intent(ActivityShowDevice.this, MainActivity.class);
							intent3.putExtra("devID", devID);
							intent3.putExtra("devKey", devKey);
							startActivity(intent3);
							break;
						// ����ͷ��ת
						case 1:
							Intent intent4 = new Intent(ActivityShowDevice.this, ActivityReverseDevice.class);
							intent4.putExtra("devID", devID);
							startActivity(intent4);
							break;
						// ��̨����
						case 2:
							Intent intent5 = new Intent(ActivityShowDevice.this, ActivityControlDevice.class);
							intent5.putExtra("devID", devID);
							startActivity(intent5);
							break;
						case 3:
							restartCamera(devID);
							break;
						}
					}
				});
				Dialog dialog = builder.create();
				dialog.show();
			}
		});
		adapter = new MyDeviceListViewAdapter(ActivityShowDevice.this);
		getDeviceList();
	}

	public void getDeviceList() {
		final SyncHttpRequestService service = new SyncHttpRequestService();
		final String url = this.getResources().getString(R.string.getdevlist);
		String date = TimeUtil.getTime();
		String appID = this.getResources().getString(R.string.appID);
		String account = this.getResources().getString(R.string.account);
		String key = this.getResources().getString(R.string.key);
		String md5 = MD5Util.Md5(appID + account + date + key);
		final String params = "appID=" + appID + "&account=" + account + "&opTime=" + date + "&opkey=" + md5;
		// �����̣߳�������������
		new Thread() {
			@Override
			public void run() {
				// ��ȡ��Ӧ����
				String result = service.httpGet(url, params);
				System.out.println(result.length());
				try {
					// ������Ӧ��
					JSONObject jsonObject = new JSONObject(result);
					String responseCode = jsonObject.getString("result");
					lists = JsonObjectUtil.getDeviceList(jsonObject);

					Message msg = handler.obtainMessage();
					if ("1".equals(responseCode)) {
						msg.what = 1;
					} else if ("2".equals(responseCode)) {
						msg.what = 2;
					} else if ("3".equals(responseCode)) {
						msg.what = 3;
					} else if ("0".equals(responseCode)) {
						msg.what = 0;
						msg.obj = result;
						if (lists.size() > 0) {
							runOnUiThread(new Runnable() {

								@Override
								public void run() {
									adapter.setLists(lists);
									lv.setAdapter(adapter);
								}
							});

						}
					}
					handler.sendMessage(msg);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	public void restartCamera(String devID) {
		final SyncHttpRequestService service = new SyncHttpRequestService();
		final String url = this.getResources().getString(R.string.restartDev);
		String date = TimeUtil.getTime();
		String appID = this.getResources().getString(R.string.appID);
		String account = this.getResources().getString(R.string.account);
		String key = this.getResources().getString(R.string.key);
		String md5 = MD5Util.Md5(appID + account +devID+ date + key);
		final String params = "appID=" + appID + "&account=" + account +"&devID=" + devID+ "&opTime=" + date + "&opkey=" + md5;
		// �����̣߳�������������
		new Thread() {
			@Override
			public void run() {
				// ��ȡ��Ӧ����
				String result = service.httpGet(url, params);
				System.out.println(result.length());
				try {
					// ������Ӧ��
					JSONObject jsonObject = new JSONObject(result);
					String responseCode = jsonObject.getString("result");
					String resultText = jsonObject.getString("resultText");

					Message msg = handler.obtainMessage();
					if ("1".equals(responseCode)) {
						msg.what = 1;
					} else if ("2".equals(responseCode)) {
						msg.what = 2;
					} else if ("3".equals(responseCode)) {
						msg.what = 3;
					} else if ("0".equals(responseCode)) {
						msg.what = 10;
						msg.obj = resultText;
					}
					else if ("4".equals(responseCode)) {
						msg.what = 4;
					}
					handler.sendMessage(msg);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:

				Toast.makeText(ActivityShowDevice.this, "��֤�ɹ���", Toast.LENGTH_SHORT).show();
				break;
			case 1:
				Toast.makeText(ActivityShowDevice.this, "Ӧ��ID�Ƿ�", Toast.LENGTH_SHORT).show();
				break;
			case 2:
				Toast.makeText(ActivityShowDevice.this, "�û���������", Toast.LENGTH_SHORT).show();
				break;
			case 3:
				Toast.makeText(ActivityShowDevice.this, "��֤�����", Toast.LENGTH_SHORT).show();
				break;
			case 4:
				Toast.makeText(ActivityShowDevice.this, "�豸������", Toast.LENGTH_SHORT).show();
				break;
			case 10:
				Toast.makeText(ActivityShowDevice.this, "�����ɹ�", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
}
