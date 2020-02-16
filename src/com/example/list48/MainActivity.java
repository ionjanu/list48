package com.example.list48;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
 
public class MainActivity extends Activity {
 
  // denumiri atribute pentru  Map
  final String ATTRIBUTE_NAME_TEXT = "text";
  final String ATTRIBUTE_NAME_CHECKED = "checked";
  final String ATTRIBUTE_NAME_IMAGE = "image";
 
  ListView lvSimple;
 
  /** Called when the activity is first created. */
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
 
    // tablouri de date
    String[] texts = { "inserare tex", "sometext 2", "sometext 3",
        "sometext 4", "sometext 5" };
    boolean[] checked = { false, false, false, true, false };
    int img = R.drawable.ic_launcher;
 // accesati linkul de mai jos pentru a studia ceva reveritor la Map
   //   https://developer.android.com/reference/java/util/Map.html
    // impachetam datele intr-0 structura specifica adaptorului
    ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
        texts.length);
    Map<String, Object> m;
    for (int i = 0; i < texts.length; i++) {
      m = new HashMap<String, Object>();
      m.put(ATTRIBUTE_NAME_TEXT, texts[i]);
      m.put(ATTRIBUTE_NAME_CHECKED, checked[i]);
      m.put(ATTRIBUTE_NAME_IMAGE, img);
      data.add(m);
    }
 
   
    // tablourile denumirilor atributelor de unde vor fi citite datele
    String[] from = { ATTRIBUTE_NAME_TEXT, ATTRIBUTE_NAME_CHECKED,
        ATTRIBUTE_NAME_IMAGE };
  
    // tabloul ID al componentelor View in care vor fi inserate datele
    int[] to = { R.id.tvText, R.id.cbChecked, R.id.ivImg };
 
    // cfeam adaptorul
    SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item,
        from, to);
 
 
    // definim lista si atribuim listei adaptorul respectiv creat
    lvSimple = (ListView) findViewById(R.id.lvSimple);
    lvSimple.setAdapter(sAdapter);
  }
}
