package com.programmerr47.whitecodetesttask.representation.tasks;

import android.os.AsyncTask;

/**
 * @author Michael Spitsin
 * @since 2014-08-24
 */
public abstract class AsyncTaskWithListener<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    private OnTaskFinishedListener listener;

    @Override
    protected final void onPostExecute(Result result) {
        if (listener != null) {
            listener.onTaskFinished(this.getClass().getName(), result);
        }
    }

    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        this.listener = listener;
    }
}
