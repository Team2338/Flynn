package team.gif.commands.macros;


import team.gif.commands.auto.AutoCollect;

/**
 * @author PatrickUbelhor
 */
public class CollectToDrive extends lib.gif.commands.CommandGroup {
    
    public  CollectToDrive() {
        addSequential(new AutoCollect());
        addSequential(new AllMid());
    }
    
}
