/*     */ package com.android.qiyicontroller;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.ComponentName;
/*     */ import android.content.Intent;
/*     */ import android.content.ServiceConnection;
/*     */ import android.hardware.Sensor;
/*     */ import android.hardware.SensorEvent;
/*     */ import android.hardware.SensorEventListener;
/*     */ import android.hardware.SensorManager;
/*     */ import android.os.IBinder;
/*     */ import android.os.RemoteException;
/*     */ import android.util.Log;
/*     */ import com.unity3d.player.UnityPlayer;
/*     */ 
/*     */ public class ControllerUtil
/*     */ {
/*  23 */   public AIDLController mAIDLController = null;
/*  24 */   private Activity activity = null;
/*  25 */   private int batterLevel = -1;
/*  26 */   private boolean DEBUG = false;
/*     */ 
/*  32 */   private boolean readBackMaskDown = false;
/*     */ 
/*  34 */   private boolean readBackMaskUp = false;
/*  35 */   private boolean backButtonDown = false;
/*  36 */   private boolean backButton = false;
/*  37 */   private boolean backButtonUp = false;
/*     */ 
/*  40 */   private boolean readAppButtonMaskDown = false;
/*  41 */   private boolean readAppButtonMaskUp = false;
/*  42 */   private boolean appButtonDown = false;
/*  43 */   private boolean appButton = false;
/*  44 */   private boolean appButtonUp = false;
/*     */ 
/*  47 */   private boolean readTriggerMaskDown = false;
/*  48 */   private boolean readTriggerMaskUp = false;
/*  49 */   private boolean triggerDown = false;
/*  50 */   private boolean trigger = false;
/*  51 */   private boolean triggerUp = false;
/*     */ 
/*  54 */   private float quans_x = 0.0F;
/*  55 */   private float quans_y = 0.0F;
/*  56 */   private float quans_z = 0.0F;
/*  57 */   private float quans_w = 1.0F;
/*     */ 
/*  60 */   private int mTimeStamp = 0;
/*  61 */   private int mEvent = 0;
/*  62 */   private int mEventParameter = 0;
/*  63 */   int[] objects = { 0, 0, 0 };
/*     */   private SensorManager sensorManager;
/*     */   private SensorEventListener mySensorListener;
/* 235 */   private ServiceConnection mServiceConn = new ServiceConnection()
/*     */   {
/*     */     public void onServiceConnected(ComponentName name, IBinder service) {
/* 238 */       ControllerUtil.this.mAIDLController = AIDLController.Stub.asInterface(service);
/*     */       try
/*     */       {
/* 242 */         ControllerUtil.this.mAIDLController.registerListener(ControllerUtil.this.aidlListener);
/* 243 */         ControllerUtil.this.mAIDLController.control_handDevice(5, 0, 0);
/*     */       } catch (RemoteException e) {
/* 245 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */ 
/*     */     public void onServiceDisconnected(ComponentName name)
/*     */     {
/* 252 */       ControllerUtil.this.mAIDLController = null;
/*     */     }
/* 235 */   };
/*     */ 
/* 498 */   private AIDLListener aidlListener = new AIDLListener.Stub()
/*     */   {
/*     */     public synchronized void shortClickBackEvent(int state)
/*     */     {
/* 503 */       if (ControllerUtil.this.DEBUG) Log.d("zyc", "<<<<shortClickBackEvent:" + state);
/* 504 */       UnityPlayer.UnitySendMessage("Controller", "setBackButtonState", "" + state);
/*     */     }
/*     */ 
/*     */     public synchronized void batterLevelEvent(int level)
/*     */     {
/* 513 */       if (ControllerUtil.this.DEBUG) Log.d("zyc", "<<<<batterLevelEvent:" + level);
/* 514 */       UnityPlayer.UnitySendMessage("Controller", "setBatterLevel", "" + level);
/*     */     }
/*     */ 
/*     */     public synchronized void clickAppButtonEvent(int state)
/*     */     {
/* 523 */       if (ControllerUtil.this.DEBUG) Log.d("zyc", "<<<<clickAppButtonEvent:" + state);
/* 524 */       UnityPlayer.UnitySendMessage("Controller", "setAppButtonState", "" + state);
/*     */     }
/*     */ 
/*     */     public synchronized void clickAndTriggerEvent(int state)
/*     */     {
/* 533 */       if (ControllerUtil.this.DEBUG) Log.d("zyc", "<<<<clickAndTriggerEvent:" + state);
/* 534 */       UnityPlayer.UnitySendMessage("Controller", "setTriggerState", "" + state);
/*     */     }
/*     */ 
/*     */     public synchronized void quansDataEvent(float x, float y, float z, float w)
/*     */     {
/* 543 */       if (ControllerUtil.this.DEBUG)
/* 544 */         Log.d("[SYS]", "quans data quansDataEvent : x = " + x + " y = " + y + " z = " + z + " w = " + w);
/* 545 */       UnityPlayer.UnitySendMessage("Controller", "setQaundData", x + "," + y + "," + z + "," + w);
/*     */     }
/*     */ 
/*     */     public synchronized void shakeEvent(int timeStamp, int event, int eventParameter)
/*     */     {
/* 554 */       if (ControllerUtil.this.DEBUG)
/* 555 */         Log.d("[SYS]", "shakeEvent : timeStamp = " + timeStamp + " event = " + event + " eventParameter = " + eventParameter);
/* 556 */       UnityPlayer.UnitySendMessage("Controller", "setShakeEvent", timeStamp + "," + event + "," + eventParameter);
/*     */     }
/*     */ 
/*     */     public synchronized void longClickHomeEvent(int state)
/*     */     {
/* 567 */       if (ControllerUtil.this.DEBUG) Log.d("zyc", "<<<<longClickHomeEvent:" + state);
/* 568 */       UnityPlayer.UnitySendMessage("Controller", "setHomeLongClickState", "" + state);
/*     */     }
/*     */ 
/*     */     public synchronized void gyroDataEvent(float x, float y, float z)
/*     */     {
/* 573 */       if (ControllerUtil.this.DEBUG) Log.d("zyc", "<<<<gyroDataEvent: x = " + x + " y = " + y + " z = " + z);
/* 574 */       UnityPlayer.UnitySendMessage("Controller", "GetGyroState", x + "," + y + "," + z);
/*     */     }
/*     */ 
/*     */     public synchronized void accelDataEvent(float x, float y, float z)
/*     */     {
/* 579 */       if (ControllerUtil.this.DEBUG)
/* 580 */         Log.d("zyc", "<<<<accelDataEvent: x = " + x + " y = " + y + " z = " + z);
/* 581 */       UnityPlayer.UnitySendMessage("Controller", "GetAccelState", x + "," + y + "," + z);
/*     */     }
/*     */ 
/*     */     public synchronized void touchDataEvent(float x, float y)
/*     */     {
/* 586 */       if (ControllerUtil.this.DEBUG) Log.d("zyc", "<<<<touchDataEvent: x = " + x + " y = " + y);
/* 587 */       UnityPlayer.UnitySendMessage("Controller", "SetTouchState", x + "," + y);
/*     */     }
/*     */ 
/*     */     public synchronized void handDeviceVersionInfoEvent(int appVersion, int deviceVersion, int deviceType)
/*     */     {
/* 593 */       if (ControllerUtil.this.DEBUG)
/* 594 */         Log.d("[SYS]", "handDeviceVersionInfo : appVersion = " + appVersion + " deviceVersion = " + deviceVersion + " deviceType = " + deviceType);
/* 595 */       UnityPlayer.UnitySendMessage("Controller", "GetHandDeviceVersionInfo", appVersion + "," + deviceVersion + "," + deviceType);
/*     */     }
/* 498 */   };
/*     */ 
/*     */   public void InitService(String str1)
/*     */   {
/*  69 */     if (this.DEBUG) Log.d("zyc", "<<<<InitService:" + str1);
/*  70 */     this.activity = UnityPlayer.currentActivity;
/*  71 */     InitSensorParameter(this.activity);
/*  72 */     bindService();
/*     */   }
/*     */ 
/*     */   private void InitSensorParameter(Activity activity)
/*     */   {
/*  77 */     if (activity != null) {
/*  78 */       this.sensorManager = ((SensorManager)activity.getSystemService("sensor"));
/*     */ 
/*  80 */       Sensor accelerSensor = this.sensorManager.getDefaultSensor(4);
/*     */ 
/*  82 */       this.mySensorListener = new SensorEventListener()
/*     */       {
/*     */         public void onSensorChanged(SensorEvent event)
/*     */         {
/*  86 */           int type = event.sensor.getType();
/*  87 */           if (type == 4) {
/*  88 */             float x = event.values[0];
/*  89 */             float y = event.values[1];
/*  90 */             float z = event.values[2];
/*  91 */             UnityPlayer.UnitySendMessage("Controller", "SetSensorZ", x + " " + y + " " + z);
/*     */           }
/*     */         }
/*     */ 
/*     */         public void onAccuracyChanged(Sensor sensor, int accuracy)
/*     */         {
/*     */         }
/*     */       };
/* 105 */       this.sensorManager.registerListener(this.mySensorListener, accelerSensor, 3);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void DestroyService(String str1)
/*     */   {
/* 111 */     if (this.DEBUG) Log.d("zyc", "<<<<DestroyService:" + str1);
/* 112 */     this.activity = UnityPlayer.currentActivity;
/* 113 */     if (this.sensorManager != null) {
/* 114 */       this.sensorManager.unregisterListener(this.mySensorListener);
/*     */     }
/* 116 */     unRegister();
/* 117 */     unbindService();
/*     */   }
/*     */ 
/*     */   public void getHandDeviceVersionInfo(String str1) {
/* 121 */     if (this.DEBUG) Log.d("zyc", "<<<<getHandDeviceVersionInfo:" + str1);
/* 122 */     if (this.mAIDLController != null)
/*     */       try {
/* 124 */         this.mAIDLController.getHandDeviceVersionInfo();
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public void set_enable_home_key(boolean isEnable) {
/* 131 */     if (this.DEBUG) Log.d("ggg", "<<<<set_enable_home_key:" + isEnable);
/* 132 */     if (this.mAIDLController != null)
/*     */       try {
/* 134 */         this.mAIDLController.enable_home_key(isEnable);
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public boolean get_enable_home_key() {
/* 141 */     boolean enable = true;
/* 142 */     if (this.mAIDLController != null)
/*     */       try {
/* 144 */         enable = this.mAIDLController.get_enable_home_key();
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/* 148 */     if (this.DEBUG) Log.d("ggg", "<<<<get_enable_home_key: " + enable);
/* 149 */     return enable;
/*     */   }
/*     */ 
/*     */   public void OpenVibrator(String str1)
/*     */   {
/* 154 */     if (this.DEBUG) Log.d("zyc", "<<<<OpenVibrator:" + str1);
/* 155 */     if (this.mAIDLController != null)
/*     */       try {
/* 157 */         this.mAIDLController.OpenVibrator();
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public void vibrate(long milliseconds) {
/* 164 */     if (this.DEBUG) Log.d("zyc", "<<<<vibrate1:" + milliseconds);
/* 165 */     if (this.mAIDLController != null)
/*     */       try {
/* 167 */         this.mAIDLController.vibrate(milliseconds / 100L);
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public void vibrate(long milliseconds, int mode) {
/* 174 */     if (this.DEBUG) Log.d("zyc", "<<<<vibrate2:" + mode);
/* 175 */     if (this.mAIDLController != null)
/*     */       try {
/* 177 */         this.mAIDLController.vibrate_mode(milliseconds / 100L, mode);
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */   }
/*     */ 
/*     */   public void vibrate(long[] pattern, int repeat) {
/* 185 */     for (int i = 0; i < pattern.length; i++) {
/* 186 */       pattern[i] /= 100L;
/*     */     }
/* 188 */     if (this.DEBUG) Log.d("zyc", "<<<<vibrate3:" + repeat);
/* 189 */     if (this.mAIDLController != null)
/*     */       try {
/* 191 */         this.mAIDLController.vibrate_repeat(pattern, repeat);
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */   }
/*     */ 
/*     */   public void vibrate_cancel(String str1) {
/* 199 */     if ((this.DEBUG) && (this.DEBUG)) Log.d("zyc", "<<<<vibrate_cancel:" + str1);
/* 200 */     if (this.mAIDLController != null)
/*     */       try {
/* 202 */         this.mAIDLController.vibrate_cancel();
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/*     */   }
/*     */ 
/*     */   public String GetBatteryLevel(String str1) {
/* 209 */     String level = null;
/* 210 */     if (this.DEBUG) Log.d("zyc", "<<<<GetBatteryLevelxxxx:" + str1);
/* 211 */     if (this.mAIDLController != null)
/*     */       try {
/* 213 */         level = this.mAIDLController.GetBatteryLevel();
/*     */       }
/*     */       catch (Exception localException) {
/*     */       }
/* 217 */     return level;
/*     */   }
/*     */ 
/*     */   public void SetHandRecenter()
/*     */   {
/* 223 */     if (this.DEBUG) Log.d("zyc", "<<<<SetHandRecenter:");
/* 224 */     if (this.mAIDLController != null)
/*     */       try
/*     */       {
/* 227 */         this.mAIDLController.control_handDevice(5, 0, 0);
/*     */       }
/*     */       catch (Exception localException)
/*     */       {
/*     */       }
/*     */   }
/*     */ 
/*     */   public void bindService()
/*     */   {
/* 257 */     if (this.DEBUG) Log.d("zyc", "<<<<bindService mAIDLController:" + this.mAIDLController);
/*     */ 
/* 259 */     Intent intent = new Intent();
/* 260 */     intent.setAction("com.android.qiyicontroller.BIND");
/* 261 */     intent.setComponent(new ComponentName("com.google.vr.vrcore", "com.android.qiyicontroller.AIDLControllerService"));
/* 262 */     this.activity.bindService(intent, this.mServiceConn, 1);
/*     */   }
/*     */ 
/*     */   public void unbindService()
/*     */   {
/* 268 */     if (this.DEBUG) Log.d("zyc", "" + this.mAIDLController);
/*     */     try
/*     */     {
/* 271 */       this.activity.unbindService(this.mServiceConn);
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setBatterLevel(int level)
/*     */   {
/* 300 */     this.batterLevel = level;
/*     */   }
/*     */ 
/*     */   public int getBatterLevel() {
/* 304 */     if (this.DEBUG) Log.d("zyc", "<<<<getBatterLevel:" + this.batterLevel);
/* 305 */     return this.batterLevel;
/*     */   }
/*     */ 
/*     */   private void setBackButtonState(int state)
/*     */   {
/* 310 */     switch (state) {
/*     */     case 100:
/* 312 */       this.readBackMaskDown = true;
/*     */ 
/* 315 */       this.backButton = false;
/* 316 */       this.backButtonUp = false;
/*     */ 
/* 318 */       break;
/*     */     case 102:
/* 323 */       this.backButton = false;
/*     */ 
/* 325 */       this.backButtonUp = true;
/* 326 */       this.readBackMaskUp = true;
/*     */ 
/* 328 */       break;
/*     */     case 101:
/* 330 */       if (!this.readBackMaskDown)
/*     */       {
/* 332 */         this.backButton = true;
/* 333 */         this.backButtonUp = false;
/* 334 */         this.readBackMaskUp = false; } break;
/*     */     default:
/* 338 */       this.backButtonUp = false;
/*     */ 
/* 340 */       this.backButton = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean BackButtonDown()
/*     */   {
/* 346 */     if (this.readBackMaskDown) {
/* 347 */       if (this.DEBUG) Log.d("ZZZ", "<<<<BackButtonDown:" + this.backButtonDown);
/* 348 */       this.readBackMaskDown = false;
/* 349 */       return true;
/*     */     }
/* 351 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean BackButton() {
/* 355 */     if (this.DEBUG) Log.d("UUU", "<<<<BackButton:" + this.backButton);
/* 356 */     return this.backButton;
/*     */   }
/*     */ 
/*     */   public boolean BackButtonUp() {
/* 360 */     if (this.readBackMaskUp) {
/* 361 */       this.readBackMaskUp = false;
/* 362 */       if (this.DEBUG) Log.d("ZZZ", "<<<<BackButtonUp:" + this.readBackMaskUp);
/* 363 */       return this.backButtonUp;
/*     */     }
/* 365 */     this.backButtonUp = false;
/* 366 */     return this.backButtonUp;
/*     */   }
/*     */ 
/*     */   private void setAppButtonState(int state)
/*     */   {
/* 371 */     switch (state) {
/*     */     case 200:
/* 373 */       this.readAppButtonMaskDown = true;
/*     */ 
/* 375 */       this.appButton = false;
/* 376 */       this.appButtonUp = false;
/*     */ 
/* 378 */       break;
/*     */     case 202:
/* 381 */       this.appButton = false;
/* 382 */       this.appButtonUp = true;
/* 383 */       this.readAppButtonMaskUp = true;
/* 384 */       break;
/*     */     case 201:
/* 386 */       if (!this.readAppButtonMaskDown)
/*     */       {
/* 388 */         this.appButton = true;
/* 389 */         this.appButtonUp = false;
/* 390 */         this.readAppButtonMaskUp = false; } break;
/*     */     default:
/* 394 */       this.appButtonUp = false;
/*     */ 
/* 396 */       this.appButton = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean AppButtonDown()
/*     */   {
/* 402 */     if (this.readAppButtonMaskDown) {
/* 403 */       if (this.DEBUG) Log.d("ZZZ", "<<<<AppButtonDown:" + this.appButtonDown);
/* 404 */       this.readAppButtonMaskDown = false;
/* 405 */       return true;
/*     */     }
/* 407 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean AppButton() {
/* 411 */     if (this.DEBUG) Log.d("UUU", "<<<<AppButton:" + this.appButton);
/* 412 */     return this.appButton;
/*     */   }
/*     */ 
/*     */   public boolean AppButtonUp() {
/* 416 */     if (this.readAppButtonMaskUp) {
/* 417 */       this.readAppButtonMaskUp = false;
/* 418 */       if (this.DEBUG) Log.d("ZZZ", "<<<<AppButtonUp:" + this.readAppButtonMaskUp);
/* 419 */       return this.appButtonUp;
/*     */     }
/* 421 */     this.appButtonUp = false;
/* 422 */     return this.appButtonUp;
/*     */   }
/*     */ 
/*     */   private void setTriggerState(int state)
/*     */   {
/* 427 */     switch (state) {
/*     */     case 300:
/* 429 */       this.readTriggerMaskDown = true;
/*     */ 
/* 431 */       this.trigger = false;
/* 432 */       this.triggerUp = false;
/* 433 */       break;
/*     */     case 302:
/* 436 */       this.trigger = false;
/* 437 */       this.triggerUp = true;
/* 438 */       this.readTriggerMaskUp = true;
/* 439 */       break;
/*     */     case 301:
/* 441 */       if (!this.readTriggerMaskDown)
/*     */       {
/* 443 */         this.trigger = true;
/* 444 */         this.triggerUp = false;
/* 445 */         this.readTriggerMaskUp = false; } break;
/*     */     default:
/* 449 */       this.triggerUp = false;
/*     */ 
/* 451 */       this.trigger = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean TriggerButtonDown()
/*     */   {
/* 457 */     if (this.readTriggerMaskDown) {
/* 458 */       if (this.DEBUG) Log.d("ZZZ", "<<<<TriggerButtonDown:" + this.triggerDown);
/* 459 */       this.readTriggerMaskDown = false;
/* 460 */       return true;
/*     */     }
/* 462 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean TriggerButton() {
/* 466 */     if (this.DEBUG) Log.d("UUU", "<<<<TriggerButton:" + this.trigger);
/* 467 */     return this.trigger;
/*     */   }
/*     */ 
/*     */   public boolean TriggerButtonUp() {
/* 471 */     if (this.readTriggerMaskUp) {
/* 472 */       this.readTriggerMaskUp = false;
/* 473 */       if (this.DEBUG) Log.d("ZZZ", "<<<<TriggerButtonUp:" + this.readTriggerMaskUp);
/* 474 */       return this.triggerUp;
/*     */     }
/* 476 */     this.triggerUp = false;
/* 477 */     return this.triggerUp;
/*     */   }
/*     */ 
/*     */   public float[] getQaundData()
/*     */   {
/* 482 */     if (this.DEBUG) Log.d("ZZZ", "<<<<getQaundData");
/*     */ 
/* 484 */     return new float[] { this.quans_x, this.quans_y, this.quans_z, this.quans_w };
/*     */   }
/*     */ 
/*     */   public int[] getShakeEvent() {
/* 488 */     if (this.DEBUG) {
/* 489 */       Log.d("ZZZ", "<<<<getShakeEvent objects = " + this.objects[0] + ", " + this.objects[1] + ", " + this.objects[2]);
/*     */     }
/*     */ 
/* 494 */     return this.objects;
/*     */   }
/*     */ 
/*     */   public void unRegister()
/*     */   {
/* 601 */     if ((this.mAIDLController != null) && (this.mAIDLController.asBinder().isBinderAlive()))
/*     */       try
/*     */       {
/* 604 */         this.mAIDLController.unRegisterListener(this.aidlListener);
/*     */       } catch (RemoteException e) {
/* 606 */         e.printStackTrace();
/*     */       }
/*     */   }
/*     */ }

/* Location:           /disk1/tools/decompile/dex2jar/jar_src/classes.jar
 * Qualified Name:     com.android.qiyicontroller.ControllerUtil
 * JD-Core Version:    0.6.2
 */