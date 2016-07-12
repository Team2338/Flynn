package team.gif.commands.auto;

import team.gif.commands.collector.CollectorAngleStandby;
import team.gif.commands.collector.CollectorSetAngle;
import team.gif.subsystems.CollectorAngle;

public class MultiStageCross extends lib.gif.commands.CommandGroup {
    
    public  MultiStageCross() {
    	addSequential(new CollectorSetAngle(CollectorAngle.Level.MID));
    	addParallel(new CollectorAngleStandby());
    	addSequential(new DriveStraightEnc(19000));
    	
    }
}
