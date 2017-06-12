/*     */ package com.android.qiyicontroller;
/*     */ 
/*     */ import android.os.Binder;
/*     */ import android.os.IBinder;
/*     */ import android.os.IInterface;
/*     */ import android.os.Parcel;
/*     */ import android.os.RemoteException;
/*     */ 
/*     */ public abstract interface AIDLController extends IInterface
/*     */ {
/*     */   public abstract String GetBatteryLevel()
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void OpenVibrator()
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void CloseVibrator()
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void registerListener(AIDLListener paramAIDLListener)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void unRegisterListener(AIDLListener paramAIDLListener)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void vibrate(long paramLong)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void vibrate_mode(long paramLong, int paramInt)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void vibrate_repeat(long[] paramArrayOfLong, int paramInt)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void vibrate_cancel()
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void getHandDeviceVersionInfo()
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void enable_home_key(boolean paramBoolean)
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract boolean get_enable_home_key()
/*     */     throws RemoteException;
/*     */ 
/*     */   public abstract void control_handDevice(int paramInt1, int paramInt2, int paramInt3)
/*     */     throws RemoteException;
/*     */ 
/*     */   public static abstract class Stub extends Binder
/*     */     implements AIDLController
/*     */   {
/*     */     private static final String DESCRIPTOR = "com.android.qiyicontroller.AIDLController";
/*     */     static final int TRANSACTION_GetBatteryLevel = 1;
/*     */     static final int TRANSACTION_OpenVibrator = 2;
/*     */     static final int TRANSACTION_CloseVibrator = 3;
/*     */     static final int TRANSACTION_registerListener = 4;
/*     */     static final int TRANSACTION_unRegisterListener = 5;
/*     */     static final int TRANSACTION_vibrate = 6;
/*     */     static final int TRANSACTION_vibrate_mode = 7;
/*     */     static final int TRANSACTION_vibrate_repeat = 8;
/*     */     static final int TRANSACTION_vibrate_cancel = 9;
/*     */     static final int TRANSACTION_getHandDeviceVersionInfo = 10;
/*     */     static final int TRANSACTION_enable_home_key = 11;
/*     */     static final int TRANSACTION_get_enable_home_key = 12;
/*     */     static final int TRANSACTION_control_handDevice = 13;
/*     */ 
/*     */     public Stub()
/*     */     {
/*  17 */       attachInterface(this, "com.android.qiyicontroller.AIDLController");
/*     */     }
/*     */ 
/*     */     public static AIDLController asInterface(IBinder obj)
/*     */     {
/*  25 */       if (obj == null) {
/*  26 */         return null;
/*     */       }
/*  28 */       IInterface iin = obj.queryLocalInterface("com.android.qiyicontroller.AIDLController");
/*  29 */       if ((iin != null) && ((iin instanceof AIDLController))) {
/*  30 */         return (AIDLController)iin;
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
/*  44 */         reply.writeString("com.android.qiyicontroller.AIDLController");
/*  45 */         return true;
/*     */       case 1:
/*  49 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*  50 */         String _result = GetBatteryLevel();
/*  51 */         reply.writeNoException();
/*  52 */         reply.writeString(_result);
/*  53 */         return true;
/*     */       case 2:
/*  57 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*  58 */         OpenVibrator();
/*  59 */         reply.writeNoException();
/*  60 */         return true;
/*     */       case 3:
/*  64 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*  65 */         CloseVibrator();
/*  66 */         reply.writeNoException();
/*  67 */         return true;
/*     */       case 4:
/*  71 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*     */ 
/*  73 */         AIDLListener _arg0 = AIDLListener.Stub.asInterface(data.readStrongBinder());
/*  74 */         registerListener(_arg0);
/*  75 */         reply.writeNoException();
/*  76 */         return true;
/*     */       case 5:
/*  80 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*     */ 
/*  82 */         AIDLListener _arg0 = AIDLListener.Stub.asInterface(data.readStrongBinder());
/*  83 */         unRegisterListener(_arg0);
/*  84 */         reply.writeNoException();
/*  85 */         return true;
/*     */       case 6:
/*  89 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*     */ 
/*  91 */         long _arg0 = data.readLong();
/*  92 */         vibrate(_arg0);
/*  93 */         reply.writeNoException();
/*  94 */         return true;
/*     */       case 7:
/*  98 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*     */ 
/* 100 */         long _arg0 = data.readLong();
/*     */ 
/* 102 */         int _arg1 = data.readInt();
/* 103 */         vibrate_mode(_arg0, _arg1);
/* 104 */         reply.writeNoException();
/* 105 */         return true;
/*     */       case 8:
/* 109 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*     */ 
/* 111 */         long[] _arg0 = data.createLongArray();
/*     */ 
/* 113 */         int _arg1 = data.readInt();
/* 114 */         vibrate_repeat(_arg0, _arg1);
/* 115 */         reply.writeNoException();
/* 116 */         return true;
/*     */       case 9:
/* 120 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/* 121 */         vibrate_cancel();
/* 122 */         reply.writeNoException();
/* 123 */         return true;
/*     */       case 10:
/* 127 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/* 128 */         getHandDeviceVersionInfo();
/* 129 */         reply.writeNoException();
/* 130 */         return true;
/*     */       case 11:
/* 134 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*     */ 
/* 136 */         boolean _arg0 = 0 != data.readInt();
/* 137 */         enable_home_key(_arg0);
/* 138 */         reply.writeNoException();
/* 139 */         return true;
/*     */       case 12:
/* 143 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/* 144 */         boolean _result = get_enable_home_key();
/* 145 */         reply.writeNoException();
/* 146 */         reply.writeInt(_result ? 1 : 0);
/* 147 */         return true;
/*     */       case 13:
/* 151 */         data.enforceInterface("com.android.qiyicontroller.AIDLController");
/*     */ 
/* 153 */         int _arg0 = data.readInt();
/*     */ 
/* 155 */         int _arg1 = data.readInt();
/*     */ 
/* 157 */         int _arg2 = data.readInt();
/* 158 */         control_handDevice(_arg0, _arg1, _arg2);
/* 159 */         reply.writeNoException();
/* 160 */         return true;
/*     */       }
/*     */ 
/* 163 */       return super.onTransact(code, data, reply, flags);
/*     */     }
/*     */ 
/*     */     private static class Proxy implements AIDLController {
/*     */       private IBinder mRemote;
/*     */ 
/*     */       Proxy(IBinder remote) {
/* 170 */         this.mRemote = remote;
/*     */       }
/*     */ 
/*     */       public IBinder asBinder() {
/* 174 */         return this.mRemote;
/*     */       }
/*     */ 
/*     */       public String getInterfaceDescriptor() {
/* 178 */         return "com.android.qiyicontroller.AIDLController";
/*     */       }
/*     */ 
/*     */       public String GetBatteryLevel()
/*     */         throws RemoteException
/*     */       {
/* 186 */         Parcel _data = Parcel.obtain();
/* 187 */         Parcel _reply = Parcel.obtain();
/*     */         try
/*     */         {
/* 190 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 191 */           this.mRemote.transact(1, _data, _reply, 0);
/* 192 */           _reply.readException();
/* 193 */           _result = _reply.readString();
/*     */         }
/*     */         finally
/*     */         {
/*     */           String _result;
/* 196 */           _reply.recycle();
/* 197 */           _data.recycle();
/*     */         }
/*     */         String _result;
/* 199 */         return _result;
/*     */       }
/*     */ 
/*     */       public void OpenVibrator() throws RemoteException {
/* 203 */         Parcel _data = Parcel.obtain();
/* 204 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 206 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 207 */           this.mRemote.transact(2, _data, _reply, 0);
/* 208 */           _reply.readException();
/*     */ 
/* 211 */           _reply.recycle();
/* 212 */           _data.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 211 */           _reply.recycle();
/* 212 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void CloseVibrator() throws RemoteException {
/* 217 */         Parcel _data = Parcel.obtain();
/* 218 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 220 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 221 */           this.mRemote.transact(3, _data, _reply, 0);
/* 222 */           _reply.readException();
/*     */ 
/* 225 */           _reply.recycle();
/* 226 */           _data.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 225 */           _reply.recycle();
/* 226 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void registerListener(AIDLListener listener) throws RemoteException {
/* 231 */         Parcel _data = Parcel.obtain();
/* 232 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 234 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 235 */           _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
/* 236 */           this.mRemote.transact(4, _data, _reply, 0);
/* 237 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 240 */           _reply.recycle();
/* 241 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void unRegisterListener(AIDLListener listener) throws RemoteException {
/* 246 */         Parcel _data = Parcel.obtain();
/* 247 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 249 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 250 */           _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
/* 251 */           this.mRemote.transact(5, _data, _reply, 0);
/* 252 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 255 */           _reply.recycle();
/* 256 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void vibrate(long milliseconds) throws RemoteException {
/* 261 */         Parcel _data = Parcel.obtain();
/* 262 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 264 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 265 */           _data.writeLong(milliseconds);
/* 266 */           this.mRemote.transact(6, _data, _reply, 0);
/* 267 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 270 */           _reply.recycle();
/* 271 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void vibrate_mode(long milliseconds, int mode) throws RemoteException {
/* 276 */         Parcel _data = Parcel.obtain();
/* 277 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 279 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 280 */           _data.writeLong(milliseconds);
/* 281 */           _data.writeInt(mode);
/* 282 */           this.mRemote.transact(7, _data, _reply, 0);
/* 283 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 286 */           _reply.recycle();
/* 287 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void vibrate_repeat(long[] pattern, int repeat) throws RemoteException {
/* 292 */         Parcel _data = Parcel.obtain();
/* 293 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 295 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 296 */           _data.writeLongArray(pattern);
/* 297 */           _data.writeInt(repeat);
/* 298 */           this.mRemote.transact(8, _data, _reply, 0);
/* 299 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 302 */           _reply.recycle();
/* 303 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void vibrate_cancel() throws RemoteException {
/* 308 */         Parcel _data = Parcel.obtain();
/* 309 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 311 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 312 */           this.mRemote.transact(9, _data, _reply, 0);
/* 313 */           _reply.readException();
/*     */ 
/* 316 */           _reply.recycle();
/* 317 */           _data.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 316 */           _reply.recycle();
/* 317 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void getHandDeviceVersionInfo() throws RemoteException {
/* 322 */         Parcel _data = Parcel.obtain();
/* 323 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 325 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 326 */           this.mRemote.transact(10, _data, _reply, 0);
/* 327 */           _reply.readException();
/*     */ 
/* 330 */           _reply.recycle();
/* 331 */           _data.recycle();
/*     */         }
/*     */         finally
/*     */         {
/* 330 */           _reply.recycle();
/* 331 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public void enable_home_key(boolean isEnable) throws RemoteException {
/* 336 */         Parcel _data = Parcel.obtain();
/* 337 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 339 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 340 */           _data.writeInt(isEnable ? 1 : 0);
/* 341 */           this.mRemote.transact(11, _data, _reply, 0);
/* 342 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 345 */           _reply.recycle();
/* 346 */           _data.recycle();
/*     */         }
/*     */       }
/*     */ 
/*     */       public boolean get_enable_home_key() throws RemoteException {
/* 351 */         Parcel _data = Parcel.obtain();
/* 352 */         Parcel _reply = Parcel.obtain();
/*     */         try
/*     */         {
/* 355 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 356 */           this.mRemote.transact(12, _data, _reply, 0);
/* 357 */           _reply.readException();
/* 358 */           _result = 0 != _reply.readInt();
/*     */         }
/*     */         finally
/*     */         {
/*     */           boolean _result;
/* 361 */           _reply.recycle();
/* 362 */           _data.recycle();
/*     */         }
/*     */         boolean _result;
/* 364 */         return _result;
/*     */       }
/*     */ 
/*     */       public void control_handDevice(int type, int data1, int data2)
/*     */         throws RemoteException
/*     */       {
/* 374 */         Parcel _data = Parcel.obtain();
/* 375 */         Parcel _reply = Parcel.obtain();
/*     */         try {
/* 377 */           _data.writeInterfaceToken("com.android.qiyicontroller.AIDLController");
/* 378 */           _data.writeInt(type);
/* 379 */           _data.writeInt(data1);
/* 380 */           _data.writeInt(data2);
/* 381 */           this.mRemote.transact(13, _data, _reply, 0);
/* 382 */           _reply.readException();
/*     */         }
/*     */         finally {
/* 385 */           _reply.recycle();
/* 386 */           _data.recycle();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           /disk1/tools/decompile/dex2jar/jar_src/classes.jar
 * Qualified Name:     com.android.qiyicontroller.AIDLController
 * JD-Core Version:    0.6.2
 */