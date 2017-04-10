package com.seltsam;

class EggVoice extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(1000);
            }catch(InterruptedException e){}

            System.out.println("яйце!");
        }
    }
}

class ChickenVoice extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(1000);
            }catch(InterruptedException e){}

            System.out.println("курка!");
        }
    }
}

public class Example1
{
    static EggVoice eggVoice = new EggVoice();
    static ChickenVoice chickenVoice = new ChickenVoice();

    public static void main(String[] args)
    {
        System.out.println("Почали...");
        eggVoice.start();
        chickenVoice.start();


        if(eggVoice.isAlive())
        {
            try{
                eggVoice.join();	//join чекає доки процес закінчить роботу
            }catch(InterruptedException e){}

            System.out.println("Першим було яйце!");
        }
        else
        {
            System.out.println("Перша була курка!");
        }
        System.out.println("Завершили!");
    }
}