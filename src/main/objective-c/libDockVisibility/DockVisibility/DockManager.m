//
//  DockVisibility.m
//  DockVisibility
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
}

@end
