package de.appplant.cordova.plugin.teste;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Toast;
import android.content.Context;

/**
 * This class echoes a string called from JavaScript.
 */
public class AmILate extends CordovaPlugin {

    @Override
  public boolean execute(
    String action, 
    JSONArray args, 
    CallbackContext callbackContext
  ) throws JSONException {
    if ("echo".equals(action)) {
      echo(args.getString(0), callbackContext);
      return true;
    }
    
    return false;
  }

   private void echo(
    String msg, 
    CallbackContext callbackContext
  ) {
    if (msg == null || msg.length() == 0) {
      callbackContext.error("Empty message!");
    } else {
      Toast.makeText(
        webView.getContext(), 
        msg, 
        Toast.LENGTH_LONG
      ).show();
      callbackContext.success(msg);
    }
  }
}
 
