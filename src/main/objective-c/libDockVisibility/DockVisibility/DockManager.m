//
//  DockVisibility.m
//  DockVisibility
//
//  Created by Matías on 2019-01-08.
//  Copyright © 2019 Matías. All rights reserved.
//

#import "DockManager.h"
#import <Cocoa/Cocoa.h>

@implementation DockManager

bool firstTimeShown = true;

void show() {
    if (firstTimeShown) {
        [NSApplication sharedApplication];
        firstTimeShown = false;
    }
    NSArray *windows = [NSApp windows];
    for (NSUInteger i = 0; i < [windows count]; i++) {
        [windows[i] setCollectionBehavior:NSWindowCollectionBehaviorCanJoinAllSpaces];
        [windows[i] setCollectionBehavior: NSWindowCollectionBehaviorMoveToActiveSpace];
//        NSLog(@"setting collection behavior of %@", windows[i]);
    }

//    NSWindow* window = [NSApp keyWindow];
//    NSWindow* window2 = [NSApp mainWindow];
//    NSLog(@"keyWindow: %@", window);
//    NSLog(@"mainWindow: %@", window2);
//    NSLog(@"%@", [NSApp windows]); //testing to see how many NSWindows are there

    [NSApp setActivationPolicy:NSApplicationActivationPolicyRegular];
    [NSApp activateIgnoringOtherApps:YES];
}

void hide() {
    [NSApp setActivationPolicy:NSApplicationActivationPolicyAccessory];
}

@end
