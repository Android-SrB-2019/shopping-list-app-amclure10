//Alex McLure 2019-02-11

package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Cart cart = new Cart();
    String theCart;

    public void launchMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        theCart = intent.getStringExtra("cart");
        if(theCart != null){
            cart.getCart(theCart);
        }
    }

    public void addProduct(View view) {
        Button button = (Button)view;
        String item = button.getText().toString();
        cart.addItem(item);

        Intent replyIntent = new Intent(this, MainActivity.class);
        replyIntent.putExtra("cart", cart.sendCart());
        setResult(Activity.RESULT_OK, replyIntent);
        finish();
    }
}
