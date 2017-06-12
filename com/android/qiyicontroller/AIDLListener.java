/*     */ package com.android.qiyicontroller;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public abstract interface AIDLListener extends IInterface
/*     */ {
/*     */   public abstract void shortClickBackEvent(int paramInt)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void clickAppButtonEvent(int paramInt)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void clickAndTriggerEvent(int paramInt)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void batterLevelEvent(int paramInt)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void quansDataEvent(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void shakeEvent(int paramInt1, int paramInt2, int paramInt3)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void longClickHomeEvent(int paramInt)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void gyroDataEvent(float paramFloat1, float paramFloat2, float paramFloat3)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void accelDataEvent(float paramFloat1, float paramFloat2, float paramFloat3)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void touchDataEvent(float paramFloat1, float paramFloat2)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void handDeviceVersionInfoEvent(int paramInt1, int paramInt2, int paramInt3)
/*     */     throws RemoteException;
/*     */ 
/*     */   public static abstract class Stub extends Binder
/*     */     implements AIDLListener
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.android.qiyicontroller.AIDLListener";
/*     */     static final int TRANSACTION_shortClickBackEvent = 1;
/*     */     static final int TRANSACTION_clickAppButtonEvent = 2;
/*     */     static final int TRANSACTION_clickAndTriggerEvent = 3;
/*     */     static final int TRANSACTION_batterLevelEvent = 4;
/*     */     static final int TRANSACTION_quansDataEvent = 5;
/*     */     static final int TRANSACTION_shakeEvent = 6;
/*     */     static final int TRANSACTION_longClickHomeEvent = 7;
/*     */     static final int TRANSACTION_gyroDataEvent = 8;
/*     */     static final int TRANSACTION_accelDataEvent = 9;
/*     */     static final int TRANSACTION_touchDataEvent = 10;
/*     */     static final int TRANSACTION_handDeviceVersionInfoEvent = 11;
/*     */ 
/*     */     public Stub()
/*     */     {
/*  17 */       attachInterface(this, "com.android.qiyicontroller.AIDLListener");
/*     */     }
/*     */ 
/*     */     public static AIDLListener asInterface(IBinder obj)
/*     */     {
/*  25 */       if (obj == null) {
/*  26 */         return null;
/*     */       }
/*  28 */       IInterface iin = obj.queryLocalInterface("com.android.qiyicontroller.AIDLListener");
/*  29 */       if ((iin != null) && ((iin instanceof AIDLListener))) {
/*  30 */         return (AIDLListener)iin;
/*     */       }
/*  32 */       return new Proxy(obj);
/*     */     }
/*     */ 
/*     */     public IBinder asBinder() {
/*  36 */       return this;
/*     */     }
/*     */ 
/*     */     public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
/*  40 */       switch (code)
/*     */       {
/*     */       case 1598968902:
/*  44 */         reply.writeString("com.android.qiyicontroller.AIDLListener");
/*  45 */         return true;
/*     */       case 1:
/*  49 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/*  51 */         int _arg0 = data.readInt();
/*  52 */         shortClickBackEvent(_arg0);
/*  53 */         reply.writeNoException();
/*  54 */         return true;
/*     */       case 2:
/*  58 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/*  60 */         int _arg0 = data.readInt();
/*  61 */         clickAppButtonEvent(_arg0);
/*  62 */         reply.writeNoException();
/*  63 */         return true;
/*     */       case 3:
/*  67 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/*  69 */         int _arg0 = data.readInt();
/*  70 */         clickAndTriggerEvent(_arg0);
/*  71 */         reply.writeNoException();
/*  72 */         return true;
/*     */       case 4:
/*  76 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/*  78 */         int _arg0 = data.readInt();
/*  79 */         batterLevelEvent(_arg0);
/*  80 */         reply.writeNoException();
/*  81 */         return true;
/*     */       case 5:
/*  85 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/*  87 */         float _arg0 = data.readFloat();
/*     */ 
/*  89 */         float _arg1 = data.readFloat();
/*     */ 
/*  91 */         float _arg2 = data.readFloat();
/*     */ 
/*  93 */         float _arg3 = data.readFloat();
/*  94 */         quansDataEvent(_arg0, _arg1, _arg2, _arg3);
/*  95 */         reply.writeNoException();
/*  96 */         return true;
/*     */       case 6:
/* 100 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/* 102 */         int _arg0 = data.readInt();
/*     */ 
/* 104 */         int _arg1 = data.readInt();
/*     */ 
/* 106 */         int _arg2 = data.readInt();
/* 107 */         shakeEvent(_arg0, _arg1, _arg2);
/* 108 */         reply.writeNoException();
/* 109 */         return true;
/*     */       case 7:
/* 113 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/* 115 */         int _arg0 = data.readInt();
/* 116 */         longClickHomeEvent(_arg0);
/* 117 */         reply.writeNoException();
/* 118 */         return true;
/*     */       case 8:
/* 122 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/* 124 */         float _arg0 = data.readFloat();
/*     */ 
/* 126 */         float _arg1 = data.readFloat();
/*     */ 
/* 128 */         float _arg2 = data.readFloat();
/* 129 */         gyroDataEvent(_arg0, _arg1, _arg2);
/* 130 */         reply.writeNoException();
/* 131 */         return true;
/*     */       case 9:
/* 135 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/* 137 */         float _arg0 = data.readFloat();
/*     */ 
/* 139 */         float _arg1 = data.readFloat();
/*     */ 
/* 141 */         float _arg2 = data.readFloat();
/* 142 */         accelDataEvent(_arg0, _arg1, _arg2);
/* 143 */         reply.writeNoException();
/* 144 */         return true;
/*     */       case 10:
/* 148 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/* 150 */         float _arg0 = data.readFloat();
/*     */ 
/* 152 */         float _arg1 = data.readFloat();
/* 153 */         touchDataEvent(_arg0, _arg1);
/* 154 */         reply.writeNoException();
/* 155 */         return true;
/*     */       case 11:
/* 159 */         data.enforceInterface("com.android.qiyicontroller.AIDLListener");
/*     */ 
/* 161 */         int _arg0 = data.readInt();
/*     */ 
/* 163 */         int _arg1 = data.readInt();
/*     */ 
/* 165 */         int _arg2 = data.readInt();
/* 166 */         handDeviceVersionInfoEvent(_arg0, _arg1, _arg2);
/* 167 */         reply.writeNoException();
/* 168 */         return true;
/*     */       }
/*     */ 
/* 171 */       return super.onTransact(code, data, reply, flags);
/*     */     }
/*     */ 
/*     */     private static class Proxy implements AIDLListener {
/*     */       private IBinder mRemote;
/*     */ 
/*     */       Proxy(IBinder remote) {
/* 178 */         this.mRemote = remote;
/*     */       }
/*     */ 
/*     */       public IBinder asBinder() {
/* 182 */         return this.mRemote;
/*     */       }
/*     */ 
/*     */       public String getInterfaceDescriptor() {
/* 186 */         return "com.android.qiyicontroller.AIDLListener";
/*     */       }
/*     */ 
/*     */       public void shortClickBackEvent(int state)
/*     */         throws RemoteException
/*     */       {
/* 194 */         Parcel _data = Parcel.obtain();
/* 195 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 197 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 198 */           _data.writeInt(state);
/* 199 */           this.mRemote.transact(1, _data, _reply, 0);
/* 200 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 203 */           _reply.recycle();
/* 204 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void clickAppButtonEvent(int state) throws RemoteException {
/* 209 */         Parcel _data = Parcel.obtain();
/* 210 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 212 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 213 */           _data.writeInt(state);
/* 214 */           this.mRemote.transact(2, _data, _reply, 0);
/* 215 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 218 */           _reply.recycle();
/* 219 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void clickAndTriggerEvent(int state) throws RemoteException {
/* 224 */         Parcel _data = Parcel.obtain();
/* 225 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 227 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 228 */           _data.writeInt(state);
/* 229 */           this.mRemote.transact(3, _data, _reply, 0);
/* 230 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 233 */           _reply.recycle();
/* 234 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void batterLevelEvent(int level) throws RemoteException {
/* 239 */         Parcel _data = Parcel.obtain();
/* 240 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 242 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 243 */           _data.writeInt(level);
/* 244 */           this.mRemote.transact(4, _data, _reply, 0);
/* 245 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 248 */           _reply.recycle();
/* 249 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void quansDataEvent(float x, float y, float z, float w) throws RemoteException {
/* 254 */         Parcel _data = Parcel.obtain();
/* 255 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 257 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 258 */           _data.writeFloat(x);
/* 259 */           _data.writeFloat(y);
/* 260 */           _data.writeFloat(z);
/* 261 */           _data.writeFloat(w);
/* 262 */           this.mRemote.transact(5, _data, _reply, 0);
/* 263 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 266 */           _reply.recycle();
/* 267 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void shakeEvent(int timeStamp, int event, int eventParameter) throws RemoteException {
/* 272 */         Parcel _data = Parcel.obtain();
/* 273 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 275 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 276 */           _data.writeInt(timeStamp);
/* 277 */           _data.writeInt(event);
/* 278 */           _data.writeInt(eventParameter);
/* 279 */           this.mRemote.transact(6, _data, _reply, 0);
/* 280 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 283 */           _reply.recycle();
/* 284 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void longClickHomeEvent(int state) throws RemoteException {
/* 289 */         Parcel _data = Parcel.obtain();
/* 290 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 292 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 293 */           _data.writeInt(state);
/* 294 */           this.mRemote.transact(7, _data, _reply, 0);
/* 295 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 298 */           _reply.recycle();
/* 299 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void gyroDataEvent(float x, float y, float z) throws RemoteException {
/* 304 */         Parcel _data = Parcel.obtain();
/* 305 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 307 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 308 */           _data.writeFloat(x);
/* 309 */           _data.writeFloat(y);
/* 310 */           _data.writeFloat(z);
/* 311 */           this.mRemote.transact(8, _data, _reply, 0);
/* 312 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 315 */           _reply.recycle();
/* 316 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void accelDataEvent(float x, float y, float z) throws RemoteException {
/* 321 */         Parcel _data = Parcel.obtain();
/* 322 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 324 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 325 */           _data.writeFloat(x);
/* 326 */           _data.writeFloat(y);
/* 327 */           _data.writeFloat(z);
/* 328 */           this.mRemote.transact(9, _data, _reply, 0);
/* 329 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 332 */           _reply.recycle();
/* 333 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void touchDataEvent(float x, float y) throws RemoteException {
/* 338 */         Parcel _data = Parcel.obtain();
/* 339 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 341 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 342 */           _data.writeFloat(x);
/* 343 */           _data.writeFloat(y);
/* 344 */           this.mRemote.transact(10, _data, _reply, 0);
/* 345 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 348 */           _reply.recycle();
/* 349 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void handDeviceVersionInfoEvent(int appVersion, int deviceVersion, int deviceType) throws RemoteException {
/* 354 */         Parcel _data = Parcel.obtain();
/* 355 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 357 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLListener");
/* 358 */           _data.writeInt(appVersion);
/* 359 */           _data.writeInt(deviceVersion);
/* 360 */           _data.writeInt(deviceType);
/* 361 */           this.mRemote.transact(11, _data, _reply, 0);
/* 362 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 365 */           _reply.recycle();
/* 366 */           _data.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /disk1/tools/decompile/dex2jar/jar_src/classes.jar
 * Qualified Name:     com.android.qiyicontroller.AIDLListener
 * JD-Core Version:    0.6.2
 */