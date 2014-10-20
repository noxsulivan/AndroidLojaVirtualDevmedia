package br.edu.devmedia.loja_virtual.util;

import android.app.Activity;
import android.widget.Toast;

public class MensagemUtil {
	
	/**
	 * Método de criação de mensagens rápidas.
	 * 
	 * @param activity
	 * @param msg
	 */
	public static void addMsg(Activity activity, String msg) {
		Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
	}

}
