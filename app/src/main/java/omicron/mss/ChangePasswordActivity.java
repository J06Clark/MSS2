
package omicron.mss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.*;


public class ChangePasswordActivity  extends ActionBarActivity {

    protected EditText rPassword;
    protected EditText rConfirmPassword;
    protected Button rChangeButton;

    public void changePassword() {

        //initializing user and pass
        rPassword = (EditText) findViewById(R.id.newPasswordText);
        rConfirmPassword = (EditText) findViewById(R.id.confirmChnagePasswordText);
        rChangeButton = (Button) findViewById(R.id.confirmButton);
        //Setting Button to listen to click
        rChangeButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String newPassword = rPassword.getText().toString().trim();
                String confirmPassword = rConfirmPassword.getText().toString().trim();
                ParseUser currentUser = ParseUser.getCurrentUser();

                if (newPassword.equals(confirmPassword)) {
                    currentUser.setPassword("new_password");
                    currentUser.saveInBackground();

                    Toast.makeText(ChangePasswordActivity.this, "Successfully Changed!", Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    Toast.makeText(ChangePasswordActivity.this, "Password fields dont match..", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
