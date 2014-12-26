package br.edu.devmedia.loja_virtual;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DashBoardListActivity extends Activity {
	
	private ListView lstDash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard_list);
		
		lstDash = (ListView) findViewById(R.id.lstDash);
		
		List<CharSequence> lista = new ArrayList<CharSequence>();
		lista.add("Consulta");
		lista.add("Pesquisar");
		lista.add("Perfil");
		lista.add("Perfil");
		lista.add("Perfil");
		lista.add("Perfil");
		lista.add("Perfil");
		lista.add("Perfil");
		lista.add("Perfil");
		
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
				DashBoardListActivity.this, android.R.layout.simple_list_item_1, lista);
		lstDash.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, "Em quadros");
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case 1:
			Intent intent = new Intent(this, DashBoardActivity.class);
			startActivity(intent);
			finish();
			break;
		}
		return true;
	}

}
