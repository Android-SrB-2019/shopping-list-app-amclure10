//Alex McLure 2019-02-11

package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int TEXT_REQUEST = 1;
    String theCart;
    private TextView cartText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartText = (TextView)findViewById(R.id.cartText);
        if (savedInstanceState != null){
            cartText.setText(savedInstanceState.getString("rotate_cart"));
        }
    }

    public void addProduct(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("cart", theCart);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == Activity.RESULT_OK){
                theCart = "";
                theCart = data.getStringExtra("cart");
                cartText.setText(theCart);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if(cartText != null){
            outState.putString("rotate_cart", cartText.getText().toString());
        }
    }
}


