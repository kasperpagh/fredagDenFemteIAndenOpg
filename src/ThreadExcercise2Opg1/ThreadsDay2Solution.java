/*
    Det tager i gennemsnit (3 betydende ciffre, fem forsøg) 1.580 sec i parallel og 2.148 sequentielt
 */
package ThreadExcercise2Opg1;

/**
 *
 * @author pagh
 */
public class ThreadsDay2Solution
{

    public static void main(String[] args) throws InterruptedException
    {
        //var til opg a og b
        int bubber;
        /////
        System.out.println("Avilable cores: " + Runtime.getRuntime().availableProcessors());

        ImageThreader it1 = new ImageThreader("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        ImageThreader it2 = new ImageThreader("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        ImageThreader it3 = new ImageThreader("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
////////////////////////////////////Den til parallel////////////////////////////
        double startPar = System.nanoTime();
        it1.start();
        it2.start();
        it3.start();

        it1.join();
        it2.join();
        it3.join();

        double endPar = System.nanoTime();

        double finalTimeSec = ((endPar - startPar) / 1000000000);
        System.out.println("Parralel Tid: " + finalTimeSec + " secs");

      //////////////////////////////DEN TIL sekventiel//////////////////////////////7
//        double startTimeRun = System.nanoTime();
//
//        it1.run();
//        it2.run();
//        it3.run();
//
//        double endRun = System.nanoTime();
//        double time = ((endRun - startTimeRun) / 1000000000);
//        System.out.println("Her er tiden: " + time + " secs");
//////////////////////////////////////////////////////////////////////

//        --------------------------
        //Her er opgave a+b
//        it1.start();
//        it2.start();
//        it3.start();
//
//        it1.join();
//        it2.join();
//        it3.join();
//
//        bubber = it1.getSum() + it2.getSum() + it3.getSum();
//
//        //Her er opgave A
//        System.out.println("Her er summen (unsigned) af alle bytes i første billed: " + it1.getSum());
//
//        //Her er opgave B
//        System.out.println("Her er summen unsigned) af alle byte i de tre billeder: " + bubber);
    }

}
