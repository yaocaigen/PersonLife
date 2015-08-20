package com.personlife.view.activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.personlifep.R;
import com.personlife.utils.ActivityCollector;
import com.personlife.utils.Utils;

public class LoginActivity extends Activity implements OnClickListener {
	TextView username, password;
	TextView login, register, retrieve;
	ImageButton weibologin;
	private SharedPreferences.Editor editor;
	private SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ActivityCollector.addActivity(this);
		editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		if (pref.getString("islogin", "0").equals("1")) {
			Intent intent=new Intent(LoginActivity.this, MainActivity.class);
			intent.putExtra("telphone", pref.getString("telphone", ""));
			startActivity(intent);
			finish();
		} else {
			initViews();
		}

	}

	private void initViews() {
		username = (TextView) findViewById(R.id.et_login_username);
		password = (TextView) findViewById(R.id.et_login_password);
		login = (TextView) findViewById(R.id.tv_login_login);
		register = (TextView) findViewById(R.id.tv_login_register);
		retrieve = (TextView) findViewById(R.id.tv_login_retrieve);
		weibologin = (ImageButton) findViewById(R.id.weibologin);
		login.setOnClickListener(this);
		register.setOnClickListener(this);
		retrieve.setOnClickListener(this);
		weibologin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.tv_login_login:
			Utils.start_Activity(LoginActivity.this, MainActivity.class, null);
//			RequestParams params = new RequestParams();
//			params.put("phone", username.getText().toString());
//			params.put("pwd", password.getText().toString());
//			BaseAsyncHttp.postReq(getApplicationContext(),"/users/login", params,
//					new JSONObjectHttpResponseHandler() {
//
//						@Override
//						public void jsonSuccess(JSONObject resp) {
//							// TODO Auto-generated method stub
//							try {
//								if (resp.get("flag").equals(1)) {
//									editor.putString("islogin", "1");
//									editor.putString("telphone", username.getText().toString());
//									editor.commit();
//									PersonInfoLocal.storeLoginTelAndPass(LoginActivity.this, username.getText().toString(),
//											password.getText().toString());
//									Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//									intent.putExtra("telphone", username.getText().toString());
//									startActivity(intent);
//									finish();
//								} else {
//									Toast.makeText(LoginActivity.this,
//											"密码错误或者用户名错误", Toast.LENGTH_LONG)
//											.show();
//								}
//
//							} catch (JSONException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//
//						@Override
//						public void jsonFail(JSONObject resp) {
//							// TODO Auto-generated method stub
//							if(resp!=null)
//								Log.i("login", resp.toString());
//							Toast.makeText(LoginActivity.this,
//									"fail密码错误或者用户名错误", Toast.LENGTH_LONG)
//									.show();
//						}
//					});

			break;
		case R.id.tv_login_register:
			Utils.start_Activity(LoginActivity.this,RegisterActivity1.class);
			break;
		case R.id.tv_login_retrieve:

			break;
		case R.id.weibologin:
			break;
		default:
			System.out.println("view is clicked");
			break;
		}
	}



}
