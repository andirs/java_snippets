package Runner;

import java.util.ArrayList;

public class Rennen extends Thread
{
	private ArrayList<Double> timetable = new ArrayList<Double>();
	private ArrayList<String> nametable = new ArrayList<String>();
	private int teilnehmer;
	private String name;
	
	public Rennen(String name, int teilnehmer)
	{
		this.name = name;
		this.teilnehmer = teilnehmer;
		this.timetable = new ArrayList<Double>();
		this.nametable = new ArrayList<String>();
	}
	
	public synchronized void crossLine(double time, String name)
	{
		timetable.add(time);
		nametable.add(name);
		System.out.println(name + " crossed the finish line in " + time);
	}
	
	public synchronized ArrayList<Double> getTimetable()
	{
		return timetable;
	}
	
	public synchronized ArrayList<String> getNametable()
	{
		return nametable;
	}
	
	public void printTable()
	{
		System.out.println("Rennen: " + name);
		for (int i = 0; i < timetable.size(); i++)
			System.out.println(i+1 + ". " + nametable.get(i) + " Zeit: " + timetable.get(i));
	}
	
	public void run()
	{
		
		
		System.out.println("##  Welcome to " + name);
		System.out.println("############################");
		try {
			Thread.sleep(0);
			System.out.println("#######  Ready  #######");
			Thread.sleep(0);
			System.out.println("#######   Set   #######");
			Thread.sleep(0);
			System.out.println("#######   Go    #######");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Runner[] teilnehmer = new Runner[this.teilnehmer];
		// Vergebe Namen und starte Threads
		for (int i = 0; i < teilnehmer.length; i++)
		{
			teilnehmer[i] = new Runner("Renner " + i, this);
			teilnehmer[i].start();
		}
		
		for (int i = 0; i < teilnehmer.length; i++)
		{
		try {
			teilnehmer[i].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		printTable();
	}
	
}
