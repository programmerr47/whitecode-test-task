package com.programmerr47.whitecodetesttask.representation.tasks;

import android.os.AsyncTask;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public abstract class AsyncTaskWithListener<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static final String CONNECTION_TASK_ERROR = "CONNECTION_TASK_ERROR";

    private OnTaskFinishedListener listener;
    private boolean isConnectionError = false;

    @Override
    protected final void onPostExecute(Result result) {
        if (listener != null) {
            if (isConnectionError) {
                listener.onTaskFinished(CONNECTION_TASK_ERROR, result);
            } else {
                listener.onTaskFinished(this.getClass().getName(), result);
            }
        }
    }

    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.listener = listener;
    }

    protected void connectionError() {
        isConnectionError = true;
    }
}
