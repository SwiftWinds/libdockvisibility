package me.matetoes.libdockvisibility;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface DockVisibility extends Library {

    DockVisibility INSTANCE = Native.load("DockVisibility", DockVisibility.class);

    void hide();

    void show();
}
