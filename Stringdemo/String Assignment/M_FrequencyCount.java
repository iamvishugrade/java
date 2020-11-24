class M_FrequencyCount
{
	static void frequencyCount(String s)
	{
		System.out.println(s);

		char ch[]=s.toCharArray();
		System.out.println("Character      Frequency");
		for(int i=0;i<s.length()-1;i++)
		{
			int count=0;
			for(int j=0;j<s.length();j++)
			{
				if(ch[i]==ch[j])
				{
					count=count+1;
				}
			}
			System.out.println(ch[i]+"          "+count);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		frequencyCount("Indiaaaai");
	}
}