/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.bluetoothchat;

/**
 * Defines several constants used between {@link BluetoothChatService} and the UI.
 */
public interface Constants {

    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Bustel comunication protocol
    //Start and end chars
    public static final int STARTCHAR	=	44;
    public static final int ENDCHAR		=	55;

//Topics
    public static final int FLASH		=	1;
    public static final int	BUSSIGNAL	=	2;
    public static final int LIGHTSENSVAL=	3;
    public static final int POTVAL		=	4;
    public static final int PROGVAL		=	5;
    public static final int USEPOT		=	6;
    public static final int DARKCALC	=	7;
    public static final int READMEMORY	=	8;
    public static final int CLEARMEMORY	=	9;
    public static final int MEMVAL		=	10;


//Values
    public static final int LED1		=	1;
    public static final int LED2		=	2;
    public static final int LED3		=	3;
    public static final int NODE1		=	1;
    public static final int NODE2		=	2;
    public static final int NODE3		=	3;
    public static final int NODE4		=	4;
    public static final int REQ			=	0;
    public static final int NO 			=	0;
    public static final int YES			=	1;
    public static final int DARK 	    =	1;
    public static final int NOTDARK		=	2;
    public static final int DONE		=	1;
    public static final int NOTDONE		=	0;
    // har lagt till
    public static final int BEGIN		=	0;
}
