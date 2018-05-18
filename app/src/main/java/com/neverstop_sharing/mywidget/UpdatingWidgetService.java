package com.neverstop_sharing.mywidget;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.widget.RemoteViews;

public class UpdatingWidgetService extends JobService{

    @Override
    public boolean onStartJob(JobParameters params) {
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        RemoteViews view = new RemoteViews(getPackageName(),R.layout.bilangan_acak_widget);
        ComponentName theWidget = new ComponentName(this,BilanganAcakWidget.class);

        String lastUpdate = "Random:"+NumberGenerator.Generate(100);
        view.setTextViewText(R.id.appwidget_text,lastUpdate);
        manager.updateAppWidget(theWidget,view);
        jobFinished(params,false);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
