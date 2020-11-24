class G_StringRTrim
{
	static void rTrim(String s)
	{
		System.out.println("Original string ="+s);

		char ch[]=new char[s.length()];
		ch=s.toCharArray();
		System.out.print("String after rtrim =");
		int i=0;
		int j=0;

		for(i=ch.length-1;i>=0;i--)
		{
			if(ch[i]!=32)
			{
				break;
			}
		}
		for(j=0;j<=i;j++)
		{
			System.out.print(ch[j]);
		}
	}

	public static void main(String[] args) {
		rTrim("India is a good country     ");
	}
}