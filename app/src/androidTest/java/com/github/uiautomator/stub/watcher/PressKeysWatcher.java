package com.github.uiautomator.stub.watcher;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.view.KeyEvent;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;
import com.github.uiautomator.stub.Log;

/**
 * Created with IntelliJ IDEA.
 * User: b036
 * Date: 8/21/13
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class PressKeysWatcher extends SelectorWatcher{
    private String[] keys = new String[]{};
    private UiDevice device = null;

    public PressKeysWatcher(UiSelector[] conditions, String[] keys) {
        super(conditions);
        this.keys = keys;
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Override
    public void action() {
        Log.d("PressKeysWatcher triggered!");
        for (String key: keys) {
            key = key.toLowerCase();
            if ("home".equals(key))
                device.pressHome();
            else if ("back".equals(key))
                device.pressBack();
            else if ("left".equals(key))
                device.pressDPadLeft();
            else if ("right".equals(key))
                device.pressDPadRight();
            else if ("up".equals(key))
                device.pressDPadUp();
            else if ("down".equals(key))
                device.pressDPadDown();
            else if ("center".equals(key))
                device.pressDPadCenter();
            else if ("menu".equals(key))
                device.pressMenu();
            else if ("search".equals(key))
                device.pressSearch();
            else if ("enter".equals(key))
                device.pressEnter();
            else if ("delete".equals(key) || "del".equals(key))
                device.pressDelete();
            else if ("recent".equals(key))
                try {
                    device.pressRecentApps();
                } catch (RemoteException e) {
                    Log.d(e.getMessage());
                }
            else if ("volume_up".equals(key))
                device.pressKeyCode(KeyEvent.KEYCODE_VOLUME_UP);
            else if ("volume_down".equals(key))
                device.pressKeyCode(KeyEvent.KEYCODE_VOLUME_DOWN);
            else if ("volume_mute".equals(key))
                device.pressKeyCode(KeyEvent.KEYCODE_VOLUME_MUTE);
            else if ("camera".equals(key))
                device.pressKeyCode(KeyEvent.KEYCODE_CAMERA);
            else if ("power".equals(key))
                device.pressKeyCode(KeyEvent.KEYCODE_POWER);
        }
    }
}