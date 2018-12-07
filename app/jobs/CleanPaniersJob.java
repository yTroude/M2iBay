package jobs;

import play.jobs.Every;
import play.jobs.Job;
import services.PanierService;

@Every("5mn")
class CleanPaniersJob extends Job {
    public void doJob(){
        PanierService.INSTANCE.clean();
    }
}
