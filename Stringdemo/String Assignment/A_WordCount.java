class A_WordCount
{
	static void wordCount(String s)
	{
		char a[]=s.toCharArray();
		int word=1;
		for(int i=0; i<s.length(); i++)
		{
			if(a[i]==' ')
			{
				word=word+1;
			}
		}
		System.out.println(s);
		System.out.println("Total number of Word is ="+word);
	}
	public static void main(String[] args) {
		wordCount("India is a a a a a Good Country");
	}
}