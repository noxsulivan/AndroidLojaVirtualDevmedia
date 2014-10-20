package br.edu.devmedia.loja_virtual;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


// fazer alguns comentarios pertinentes
public class LoginActivity extends Activity {

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
			finish();
			break;
		}
		
		return true;
	}
	
	private class LoadingAsync extends AsyncTask<Void, Void, Void> {

		private ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
		
		@Override
		protected void onPreExecute() {
			progressDialog.setMessage("Carregando...");
			progressDialog.show();
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			String login = edtLogin.getText().toString();
			String senha = edtSenha.getText().toString();
			
			boolean dadosValidos = true;
			if (login == null || login.equals("")) {
				dadosValidos = false;
				edtLogin.setError(getString(R.string.msg_login_obg));
			}
			
			if (senha == null || senha.equals("")) {
				dadosValidos = false;
				edtSenha.setError(getString(R.string.msg_senha_obg));
			} 
			
			if (dadosValidos) {
				Intent i = new Intent(LoginActivity.this, DashBoardActivity.class);
				startActivity(i);
				finish();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			progressDialog.dismiss();
		}
	}

}
