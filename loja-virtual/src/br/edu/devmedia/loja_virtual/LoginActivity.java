package br.edu.devmedia.loja_virtual;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import br.edu.devmedia.*;
import br.edu.devmedia.loja_virtual.bo.LoginBO;
import br.edu.devmedia.loja_virtual.util.MensagemUtil;

public class LoginActivity extends Activity {

	private LoginBO loginBO;
	
	private EditText edtLogin;
	
	private EditText edtSenha;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		edtLogin = (EditText) findViewById(R.id.edt_login);
		edtSenha = (EditText) findViewById(R.id.edt_senha);
	}
	
	public void logar(View view) {
		new LoadingAsync().execute();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		menu.add(0, 1, 1, "Sair");
//		menu.add(0, 2, 2, "Info");
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int idMenuItem = item.getItemId();
		switch (idMenuItem) {
		case R.id.menuSair:
			MensagemUtil.addMsgConfirm(LoginActivity.this, getString(R.string.lbl_sair), 
					getString(R.string.msg_logout), R.drawable.logout, new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							finish();
						}
					});
			break;
		case R.id.menuSobre:
			MensagemUtil.addMsgOk(LoginActivity.this, getString(R.string.lbl_sobre), 
					getString(R.string.msg_sobre), R.drawable.about);
			break;
		}
		
		return true;
	}
	
	private class LoadingAsync extends AsyncTask<Void, Void, String> {

		private ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
		
		@Override
		protected void onPreExecute() {
			progressDialog.setMessage("Carregando...");
			progressDialog.show();
		}
		
		@Override
		protected String doInBackground(Void... params) {
			String login = edtLogin.getText().toString();
			String senha = edtSenha.getText().toString();
			
			loginBO = new LoginBO(LoginActivity.this);
			
			return loginBO.validarLogin(login, senha);
		}

		@Override
		protected void onPostExecute(String msg) {
			progressDialog.dismiss();
			
			if (msg == null) {
				Intent i = new Intent(LoginActivity.this, DashBoardActivity.class);
				startActivity(i);
				finish();
			} else {
				MensagemUtil.addMsg(LoginActivity.this, msg);
			}
		}
	}

}
