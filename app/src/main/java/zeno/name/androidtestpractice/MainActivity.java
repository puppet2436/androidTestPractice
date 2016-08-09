package zeno.name.androidtestpractice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
  private TextView tvName;
  private EditText etName;
  private Button   btnShowTestFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tvName = (TextView) findViewById(R.id.tv_name);
    etName = (EditText) findViewById(R.id.et_name);
    btnShowTestFragment = (Button) findViewById(R.id.btn_show_test_fragment);
    btnShowTestFragment.setOnClickListener(new View.OnClickListener()
    {
      @Override public void onClick(View view)
      {
        showTestFragment(view);
      }
    });
  }

  public void sayHello(View v)
  {
    tvName.setText("Hello," + etName.getText());
  }

  public void showTestFragment(View v)
  {
    String fragmentTag = "TestFragment";
    FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentByTag(fragmentTag);
    if (fragment == null || !fragment.isAdded()) {
      FragmentTransaction transaction = fm.beginTransaction();
      if (fragment == null) {
        fragment = new TestFragment();
      }
      transaction.add(R.id.layout_container, fragment, fragmentTag);
      transaction.commit();
    }
  }
}

