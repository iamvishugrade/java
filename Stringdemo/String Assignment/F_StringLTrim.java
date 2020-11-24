class F_StringLTrim
{
	static void lTrim(String s)
	{
		System.out.println("Original String is ="+s);

		char ch[]=new char[s.length()];
		ch=s.toCharArray();
		System.out.print("String after lTrim =");
		int i=0;
		int j=0;
		for(i=0; i<ch.length;i++)
		{
			if(ch[i]!=32)
			{
				break;
			}
		}
		for(j=i; j<ch.length; j++)
		{
			System.out.print(ch[j]);
		}
	}

	public static void main(String[] args) {
		lTrim("     India is a good country");
	}
}