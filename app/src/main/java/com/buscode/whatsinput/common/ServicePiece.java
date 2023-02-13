package com.buscode.whatsinput.common;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public interface ServicePiece {
	/**
	 * @see {@link Service#onCreate()}
	 */
	public void onCreate();
	/**
	 * @see {@link Service#onDestroy()}
	 */
	public void onDestroy();
	/**
	 * @see {@link Service#onStartCommand(Intent, int, int)}
	 */
	public int onStartCommand(Intent intent, int flags, int startId);

	/**
	 * !!!Only one target.!!!
	 * Only when return true,
	 * {@link #onStartCommand(Intent, int, int)} are exec.
	 * @param action Intent's Action
	 * @return
	 */
	public boolean isTarget(Intent intent);
	/**
	 * Only one Binder in a Service
	 * @see {@link Service#onCreate()}
	 */
	public IBinder onBind(Intent intent);
	
	/**
	 * Set this service.
	 * @param service
	 */
	public void setService(Service service);
}

interface ServicePieceContainer {
	/**
	 * Add new piece
	 * @param piece
	 */
	public void addPiece(ServicePiece piece);
	/**
	 * Remove old piece
	 * @param piece
	 */
	public void removePiece(ServicePiece piece);
}