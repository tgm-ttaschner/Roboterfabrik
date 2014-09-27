package build;

import java.util.*;

public class UniqueNumbers {

	private HashSet<Long> hs;
	private Iterator<Long> iterator;

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

		if (count < 1)	{
			throw new IllegalArgumentException("Geben Sie eine Zahl > 0 an");
		}

		for (int i = 0; i < count; i++)	{
			this.add();
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

	public int wievieleZahlen()	{
		return hs.size();
	}
}