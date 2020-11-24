class C_CharacterCount
{
	static void characterCount(String s)
	{
		char ch=s.charAt(0);
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			char ch1=s.charAt(i);
			System.out.println(ch1);
			count=count+1;
		}
		
		System.out.println("Number of Character is ="+count);
	}
}