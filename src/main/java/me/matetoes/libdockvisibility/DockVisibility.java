package me.matetoes.libdockvisibility;

import com.sun.jna.Native;

/**
 * Show and hide the macOS dock icon.
 * Has two methods to show and hide,
 * <code>
 * DockVisibility.show();
 * </code>
 * and
 * <code>
 * DockVisibility.hide();
 * </code>
 * respectively.
 */
public class DockVisibility {

    /**
     * Hides dock icon from macOS dock.
     */
    public static native void hide();

    /**
     * Shows dock icon from macOS dock.
     */
    public static native void show();

    static {
        Native.register("DockVisibility");
    }
}
