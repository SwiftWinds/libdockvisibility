package me.matetoes.libdockvisibility;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface DockVisibility extends Library {

    /**
     * Singleton of DockVisibility class. To run show or hide, call
     * <code>
     * DockVisibility.INSTANCE.show();
     * </code>
     * or
     * <code>
     * DockVisibility.INSTANCE.hide();
     * </code>
     * respectively.
     */
    DockVisibility INSTANCE = Native.load("DockVisibility", DockVisibility.class);

    /**
     * Hides dock icon from macOS dock.
     */
    void hide();

    /**
     * Shows dock icon from macOS dock.
     */
    void show();
}
