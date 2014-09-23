package storage.io;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class UniqueNumbers {

	private HashSet<Long> hs;
	private Iterator<Long> iterator;
	public static int count = 10;

	public UniqueNumbers()	{
		hs = new HashSet<Long>();
	}

	public void add()	{

		long random = new Random().nextLong();

		if (random < 0)	{
			random = random*(-1);
		}

		hs.add(random);
	}

	public void add(int count)	{

		for (int i = 0; i < count; i++)	{
			long random = new Random().nextLong();
			
			if (random < 0)	{
				random = random*(-1);
			}

			hs.add(random);
		}
	}

	public Long[] getRandomNumbers()	{
		iterator = hs.iterator();
		Long[] ausg = new Long[hs.size()];
		int i = 0;

		while (iterator.hasNext())	{
			ausg[i] = (Long) iterator.next();
			i++;
		}
		return ausg;
	}

	public void setHs(HashSet<Long> hs) {
		this.hs = hs;
	}

	public int wievieleLongs()	{
		return hs.size();
	}


	public static void main(String[] args) {

		UniqueNumbers un = new UniqueNumbers();
		un.add(10);


		System.out.println(un.wievieleLongs());

		for (int i = 0; i < count; i++)	{
			System.out.println(un.getRandomNumbers()[i]);
		}
	}
}
