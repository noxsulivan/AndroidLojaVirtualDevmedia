package br.edu.devmedia.loja_virtual.bo;

import br.edu.devmedia.loja_virtual.R;
import android.content.Context;

public class LoginBO {
	
	private Context context;
	
	public LoginBO(Context context) {
		this.context = context;
	}

	public String validarLogin(String login, String senha) {
		if (login == null || login.equals("")) {
			return context.getString(R.string.msg_login_obg);
		} else if (senha == null || senha.equals("")) {
			return context.getString(R.string.msg_senha_obg);
		}
		return null;
	}
	
}