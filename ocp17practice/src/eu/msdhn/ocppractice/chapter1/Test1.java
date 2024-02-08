package eu.msdhn.ocppractice.chapter1;


/**
 * A jail has a number of prisoners and a number of treats to pass out to them. Their jailer decides the fairest way to divide the treats is to seat the prisoners around a circular table in sequentially numbered chairs. A chair number will be drawn from a hat. Beginning with the prisoner in that chair, one candy will be handed to each prisoner sequentially around the table until all have been distributed.
 * The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful. Determine the chair number occupied by the prisoner who will receive that candy.
 *  
 *  
 * ----------------
 * Sample Input
 * 5 2 1 [5 prisoners | 2 sweets | starting position chair no 1]
 *
 * 2
 *
 * 5 2 2
 * has context menu
 *
 *
 * 2
 *
 *
 * 5 prisoner
 * 2 treats
 * Starting position
 *
 *
 *
 * 1  2 3 4 5
 *
 */
public class Test1 {

    public static void main(String ...args){
        // System.out.println(findBadPosition(7,19,2));
        System.out.println(findBadPosition(3,3,2));
    }

    public static int findBadPosition(int prisoners,int sweets, int startingPosition){
        if(sweets < prisoners){
            return sweets + startingPosition -1 ;
        }
       return ( sweets % 7) + startingPosition;
    }

}
