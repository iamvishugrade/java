class H_StringAllTrim
{
	static void allTrim(String s)
	{
		System.out.println("Original string ="+s);

		char ch[]=new char[s.length()];
		ch=s.toCharArray();
		System.out.print("String after allTrim =");
		int i=0;
		int j=0;
		int k=0;

		for(i=ch.length-1; i>=0; i--)
		{
			if(ch[i]!=32)
			{
				break;
			}
		}
		for(k=0; k<=i; k++)
		{
			if(ch[k]!=32)
			{
				break;
			}
		}
		for(j=k;j<=i;j++)
		{
			System.out.print(ch[j]);
		}
	}

	public static void main(String[] args) {
		allTrim("         India is a good country            ");
	}
}