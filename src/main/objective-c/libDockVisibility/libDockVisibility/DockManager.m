//
//  libDockVisibility.m
//  libDockVisibility
//
//  Created by Matías on 2019-01-08.
//  Copyright © 2019 Matías. All rights reserved.
//

#import "DockManager.h"

@implementation DockManager


void show() {
    ProcessSerialNumber psn = {0, kCurrentProcess};
    TransformProcessType(&psn, kProcessTransformToForegroundApplication);
}


void hide() {
    ProcessSerialNumber psn = {0, kCurrentProcess};
    TransformProcessType(&psn, kProcessTransformToUIElementApplication);


    /*
    // this should be called from the application delegate's applicationDidFinishLaunching
// method or from some controller object's awakeFromNib method
    if (![[NSUserDefaults standardUserDefaults] boolForKey:@"LaunchAsAgentApp"]) {
        ProcessSerialNumber psn = { 0, kCurrentProcess };
// display dock icon
        TransformProcessType(&psn, kProcessTransformToForegroundApplication);
// enable menu bar
        SetSystemUIMode(kUIModeNormal, 0);
// switch to Dock.app
        [[NSWorkspace sharedWorkspace] launchAppWithBundleIdentifier:@"com.apple.dock" options:NSWorkspaceLaunchDefault additionalEventParamDescriptor:nil launchIdentifier:nil];
// switch back
        [[NSApplication sharedApplication] activateIgnoringOtherApps:TRUE];
    }*/


//    [NSApp setActivationPolicy: NSApplicationActivationPolicyRegular];
}

void debug() {
    NSLog(@"DEBUG");
}

@end
