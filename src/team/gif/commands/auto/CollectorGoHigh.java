package team.gif.commands.auto;

import team.gif.commands.collector.CollectorCoastUp;
import team.gif.commands.collector.CollectorSetAngle;
import team.gif.subsystems.CollectorAngle;

public class CollectorGoHigh extends lib.gif.commands.CommandGroup {
    
    public  CollectorGoHigh() {
        addSequential(new CollectorSetAngle(CollectorAngle.Level.UP));
        addSequential(new CollectorCoastUp());
        
    }
}
