package sh.calaba.instrumentationbackend.actions.wifi;

import sh.calaba.instrumentationbackend.InstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.actions.Action;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiState implements Action {
	
	@Override
	public Result execute(String... args) {
		String status = args[0];
		
		WifiManager wifiManager = (WifiManager) InstrumentationBackend.solo.getCurrentActivity().getSystemService(Context.WIFI_SERVICE);
		
		if (status.equals("on")) {
			if (wifiManager.isWifiEnabled()) {
				
			} else {
				wifiManager.setWifiEnabled(true);
			}
		} else {
			wifiManager.setWifiEnabled(false);
		}
		
		return Result.successResult();
		
	}
	
	@Override
	public String key() {
		return "wifi_state";
	}
}