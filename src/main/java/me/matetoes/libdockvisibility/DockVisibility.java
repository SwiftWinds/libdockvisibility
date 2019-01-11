package me.matetoes.libdockvisibility;

import com.sun.jna.Native;

public class DockVisibility {

    static {
        Native.register("DockVisibility"); //is this the right name?
    }
    public static native void hide();
    public static native void show();
}
